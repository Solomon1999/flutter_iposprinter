
import 'dart:async';

import 'package:flutter/services.dart';



enum PrinterStatus {
  PRINTER_NORMAL,
  PRINTER_PAPERLESS,
  PRINTER_THP_HIGH_TEMPERATURE,
  PRINTER_MOTOR_HIGH_TEMPERATURE,
  PRINTER_IS_BUSY,
  PRINTER_ERROR_UNKNOWN
}

/**
 * Printer status query
 * 0: PRINTER_NORMAL                      You can start a new print at this time
 * 1: PRINTER_PAPERLESS                   Stop printing at this time, if the current printing is not completed, you need to reprint after adding paper
 * 2: PRINTER_THP_HIGH_TEMPERATURE        Pause printing at this time, if the current printing is not completed, it will continue to print after cooling down, no need to reprint
 * 3: PRINTER_MOTOR_HIGH_TEMPERATURE      Printing is not executed at this time. After cooling down, the printer needs to be initialized and the printing task is re-initiated
 * 4: PRINTER_IS_BUSY                     The printer is printing at this time
 * 5: PRINTER_ERROR_UNKNOWN               Printer abnormal
 */

class IPOSPrinter {
  static const String namespace = "iposprinter_plugin";

  static const MethodChannel _channel =
  MethodChannel(namespace+"/methods");

  // static const EventChannel _stateChannel =
  // EventChannel(namespace+"/state");

  final StreamController<MethodCall> _methodStreamController =
  StreamController.broadcast();


  //Stream<MethodCall> get _methodStream => _methodStreamController.stream;

  IPOSPrinter._() {
    _channel.setMethodCallHandler((MethodCall call) async {
      _methodStreamController.add(call);
    });
  }

  static final IPOSPrinter _instance = IPOSPrinter._();

  static IPOSPrinter get instance => _instance;

  ///onStateChanged()
  // Stream<int?> onStateChanged() async* {
  //   yield await _channel.invokeMethod('state').then((buffer) => buffer);
  //
  //   yield* _stateChannel.receiveBroadcastStream().map((buffer) => buffer);
  // }

  Future<dynamic> initPrinter() async {
    var status = await _channel.invokeMethod('printerInit');
    return status;
  }

  Future<dynamic> printerStatus() async {
    return await _channel.invokeMethod('printerStatus');

  }

  Future<dynamic> printBlankLine({int lineHeight: 1}) async {
    await _channel.invokeMethod('printBlankLines', {
      'lines': 1,
      'lineHeight': lineHeight,
    });
  }

  Future<dynamic> printBlankLines(int linesNumber, {int lineHeight: 1}) async {
    await _channel.invokeMethod('printBlankLines', {
      'lines': linesNumber,
      'lineHeight': lineHeight,
    });
  }

  Future<dynamic> printText(String text) async =>
      await _channel.invokeMethod('printText', {
        'text': text,
      });

  Future<dynamic> printStyledText(String text, {String font: 'ST',  int fontSize: 16}) async =>
      await _channel.invokeMethod('printSpecifiedTypeText', {
        'text': text,
        'font': font,
        'fontSize': fontSize,
      });

  Future<dynamic> printStyledFormatText(String text, {String font: 'ST',  int fontSize: 16, int align: 1}) async =>
      await _channel.invokeMethod('printSpecFormatText', {
        'text': text,
        'font': font,
        'fontSize': fontSize,
        'alignment': align,
      });

  Future<dynamic> printColumnsText(List<String> textArray, List<int> widthArray, List<int> alignmentArray, {bool isContinuousPrint: true}) async =>
      await _channel.invokeMethod('printColumnsText', {
        'colsTextArray': textArray,
        'colsWidthArray': widthArray,
        'colsAlignmentArray': alignmentArray,
        'isContinuousPrint': isContinuousPrint
      });

  Future<dynamic> printBitmap(ByteData imageData, {int imageSize: 32, int alignment: 1}) async =>
      await _channel.invokeMethod('printBitmap', {
        'imageBytesArray': imageData,
        'imageSize': imageSize,
        'alignment': alignment,
      });

  Future<dynamic> testPrint() async =>
      await _channel.invokeMethod('testPrint');

  Future<dynamic> printData(List<Map<String, dynamic>> data) async =>
      await _channel.invokeMethod('PrintData', {"printData": data});

}
