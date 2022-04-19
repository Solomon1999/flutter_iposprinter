package com.iposprinter.iposprinter;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;

import androidx.annotation.NonNull;

import com.iposprinter.iposprinterservice.IPosPrinterCallback;
import com.iposprinter.iposprinterservice.IPosPrinterService;
import com.iposprinter.iposprinterservice.ThreadPoolManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.Map;

import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * PrintingPlugin
 */
public class IPosPrinterPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler  {
  private static final String TAG = "IPOSPrinterPlugin";
  private static final String NAMESPACE = "iposprinter";

  private Context context;
  private MethodChannel channel;
  private Object initializationLock = new Object();

  private FlutterPluginBinding pluginBinding;
  private ActivityPluginBinding activityBinding;

  private Application application;
  private Activity activity;

  private IPosPrinterService iPosPrinterService;

  public static void registerWith(Registrar registrar) {
    final IPosPrinterPlugin instance = new IPosPrinterPlugin();
    //registrar.addRequestPermissionsResultListener(instance);
    Activity activity = registrar.activity();
    Application application = null;
    instance.setup(registrar.messenger(), application, activity, registrar, null);

  }

  private void setup(final BinaryMessenger messenger,
                     final Application application,
                     final Activity activity,
                     final PluginRegistry.Registrar registrar,
                     final ActivityPluginBinding activityBinding) {
    synchronized (initializationLock) {
      Log.i(TAG, "setup");
      this.activity = activity;
      this.application = application;
      this.context = application;
      channel = new MethodChannel(messenger, NAMESPACE + "/methods");
      channel.setMethodCallHandler(this);
      initializeService();
    }
  }

  /**
   * Binding service instance
   */
  private ServiceConnection createPrinterServiceConnection() {
    return new ServiceConnection() {

      @Override
      public void onServiceConnected(ComponentName componentName, IBinder service) {
        iPosPrinterService = IPosPrinterService.Stub.asInterface(service);
      }

      @Override
      public void onServiceDisconnected(ComponentName componentName) {
        iPosPrinterService = null;
      }
    };
  }

  private void initializeService() {
    createPrinterServiceConnection();
    Intent intent = new Intent();
    intent.setPackage("com.iposprinter.iposprinterservice");
    intent.setAction("com.iposprinter.iposprinterservice.IPosPrintService");
  }

  private void detach() {
    Log.i(TAG, "detach");
    context = null;
    activityBinding = null;
    channel.setMethodCallHandler(null);
    channel = null;
    application = null;
  }

  @Override
  public void onMethodCall(MethodCall call, MethodChannel.Result result) {

    if (iPosPrinterService == null) {
      result.error("ERROR","POS Printer Service is not available", "Please " +
              "ensure you are using a compatible POS device");
      return;
    }

    ThreadPoolManager.getInstance().executeTask(new Runnable() {
      @Override
      public void run() {

        try {
          IPosPrinterCallback.Stub callback = new IPosPrinterCallback.Stub() {
            @Override
            public void onRunResult(final boolean isSuccess) {
              // if (!callbackContext.isFinished()) {
              if (isSuccess) {
                result.success(true);
              } else {
                result.error("ERROR", null, null);
              }
            }

            @Override
            public void onReturnString(final String value) {
              result.success(value);
            }
          };

          switch (call.method.toLowerCase()) {
            case "printerStatus":
              result.success(iPosPrinterService.getPrinterStatus());
              break;

            // Printer initialization The printer is powered on and initialized with default settings.
            // Please check the printer status when using it.
            // Please wait for PRINTER_IS_BUSY.
            case "printerInit":
              iPosPrinterService.printerInit(callback);
              break;

            // Set the print density of the printer,
            // which will affect subsequent printing unless initialized
            // Concentration level, range 1-10, out of range this function will not be executed Default level 6
            case "setPrinterPrintDepth":
              iPosPrinterService.setPrinterPrintDepth(call.arguments(), callback);
              break;

            // Set the print font type, which will affect subsequent printing unless initialized
            // (only one font ST is currently supported, and more fonts will be supported in the future)
            case "setPrinterPrintFontType":
              iPosPrinterService.setPrinterPrintFontType(call.arguments(), callback);
              break;

            // Setting the font size will have an impact on subsequent printing unless initialized.
            // Note: the font size is a printing method that exceeds the standard international
            // instructions.
            // Adjusting the font size will affect the character width, and the number of characters in
            // each line will also change accordingly.
            // The typesetting may be messy, you need to adjust it yourself
            case "setPrinterPrintFontSize":
              iPosPrinterService.setPrinterPrintFontSize(call.arguments(), callback);
              break;

            // Set the alignment, which will affect subsequent printing unless initialized
            // alignment 0--left, 1--center, 2--right, center by default
            case "setPrinterPrintAlignment":
              iPosPrinterService.setPrinterPrintAlignment(call.arguments(), callback);
              break;

            // The printer is feeding paper (forced line feed, after finishing the previous printing
            // content,
            // the paper feeds lines, the motor is idling to feed the paper, and no data is sent to the
            // printer)
            case "printerFeedLines":
              iPosPrinterService.printerFeedLines(call.arguments(), callback);
              break;

            // Print a blank line (force a newline, print a blank line after the end of the previous print
            // content,
            // and the data sent to the printer at this time is all 0x00)
            case "printBlankLines":
              iPosPrinterService.printBlankLines(call.argument("lines"), call.argument
                      ("lineHeight"), callback);
              break;

            // Print Text
            // Print text Automatic line wrapping when the text width is full
            case "printText":
              iPosPrinterService.printText(call.arguments(), callback);
              break;

            // Print Type-faced Text
            // Print the specified font type and size text. The font setting is only valid for this time.
            // The text width is automatically wrapped and typed
            case "printSpecifiedTypeText":
              iPosPrinterService.printSpecifiedTypeText(call.argument("text"), call.argument
                      ("font"), call.argument("fontSize"), callback);
              break;

            // Print Formatted Text
            // Print the specified font type and size text. The font setting is only valid for this time.
            // The text width is automatically wrapped and typed
            case "printSpecFormatText":
              iPosPrinterService.PrintSpecFormatText(call.argument("text"), call.argument
                              ("font"), call.argument("fontSize"), call.argument("alignment"),
                      callback);
              break;

            // Print Column Text
            // Print a row of the table, you can specify the column width and alignment
            case "printColumnsText":
              iPosPrinterService.printColumnsText(jsonArrayToStringArray((JSONArray) call.argument
                      ("colsTextArray")), jsonArrayToIntArray((JSONArray) call.argument
                      ("colsWidthArray")), jsonArrayToIntArray((JSONArray) call.argument
                      ("colsAlignmentArray")), call.argument("isContinuousPrint"), callback);
              break;

            // Print a Bitmap Image
            // Alignment 0--left, 1--center, 2--right, center by default
            // Bitmap size, the incoming size range is 1~16, and the default selection is 10 if it exceeds the range. Unit: 24bit
            case "printBitmap":
              byte[] bytes = jsonArrayToByteArray((JSONArray) call.argument("imageBytesArray"));
              iPosPrinterService.printBitmap(call.argument("alignment"), call.argument
                              ("imageSize"), BitmapFactory.decodeByteArray(bytes, 0, bytes.length),
                      callback);
              break;

            // Print Bar Code
            // Barcode Type 0 -- UPC-A, 1 -- UPC-E, 2 -- JAN13(EAN13), 3 -- JAN8(EAN8), 4 -- CODE39, 5 -- ITF, 6 -- CODABAR, 7 -- CODE93, 8 -- CODE128
            // Barcode height, the value ranges from 1 to 16, if it exceeds the range, the default value is 6, and each unit represents 24 pixels high.
            // Barcode width, the value is 1 to 16, the default value is 12 outside the range, each unit represents the length of 24 pixels
            // Text position 0--do not print text, 1--text above the barcode, 2--text below the barcode, 3--print both above and below the barcode
            case "printBarCode":
              iPosPrinterService.printBarCode(call.argument("StringData"), call.argument
                              ("symbology"), call.argument("height"), call.argument("width"),
                      call.argument("textPosition"), callback);
              break;

            //Print QR Code
            // QR code module size (unit: point, value from 1 to 16 ), the default value is 10 if it exceeds the setting range
            // Two-dimensional error correction level (0:L 1:M 2:Q 3:H)
            case "printQRCode":
              iPosPrinterService.printQRCode(call.argument("StringData"), call.argument
                      ("moduleSize"), call.argument("errorCorrectionLevel"), callback);
              break;

            // Print Raw Data
            case "printRawData":
              iPosPrinterService.printRawData(jsonArrayToByteArray((JSONArray) call.argument
                      ("byteData")), callback);
              break;

            // Printing with ESC/POS commands
            case "sendUserCMDData":
              iPosPrinterService.sendUserCMDData(jsonArrayToByteArray((JSONArray) call.argument
                      ("byteData")), callback);
              break;

            // Execute printing After executing each printing function method
            // this method needs to be executed before the printer can execute printing
            // before this method is executed, the printer status needs to be judged.
            // When the printer is in PRINTER_NORMAL, this method is valid, otherwise it will not be executed.
            case "printerPerformPrint":
              iPosPrinterService.printerPerformPrint(call.arguments(), callback);
              break;

            // Print Data Function
            case "printData":
              printData(call.argument("printData"), callback);

            default:
              result.notImplemented();
          }
        } catch (Exception exception) {
          Log.e(TAG, exception.getMessage());
          result.error("ERROR", exception.getMessage(), null);
        }
      }
    });
  }

  private byte[] jsonArrayToByteArray(JSONArray data) throws JSONException {
    byte[] bytes = new byte[data.length()];
    for (int i = 0; i < data.length(); i++) {
      bytes[i] = (byte) (((int) data.get(i)) & 0xFF);
    }
    return bytes;
  }

  private String[] jsonArrayToStringArray(JSONArray data) throws JSONException {
    String[] strings = new String[data.length()];
    for(int i = 0; i < data.length(); i++) {
      strings[i] = data.getString(i);
    }
    return strings;
  }

  private int[] jsonArrayToIntArray(JSONArray data) throws JSONException {
    int[] numbers = new int[data.length()];
    for(int i = 0; i < data.length(); i++) {
      numbers[i] = data.getInt(i);
    }
    return numbers;
  }

  public void printData(List<Map<String, Object>> data, IPosPrinterCallback callback) {
    ThreadPoolManager.getInstance().executeTask(new Runnable() {
      @Override
      public void run() {
        try {
          for (Map<String, Object> line : data) {
            String type = (String) line.get("type");
            android.util.Log.i(TAG, type);
            if (type.equals("image")) {
              android.util.Log.i(TAG, "Printing Image");
//                            AssetManager assetManager = getAssets();
              Bitmap bt;
//                            InputStream imageFile = assetManager.open("logo2.jpg");
              byte [] imageBytes = (byte[]) line.get("image");
              bt = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
              iPosPrinterService.printBitmap(1, 12, bt, callback);
            } else {
              iPosPrinterService.printSpecifiedTypeText((String) line.get("text"), "ST", (Integer) line.get("size"), callback);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    pluginBinding = binding;
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    pluginBinding = null;
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    activityBinding = binding;
    setup(
            pluginBinding.getBinaryMessenger(),
            (Application) pluginBinding.getApplicationContext(),
            activityBinding.getActivity(),
            null,
            activityBinding);
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    onDetachedFromActivity();
  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
    onAttachedToActivity(binding);
  }

  @Override
  public void onDetachedFromActivity() {
    detach();
  }
}