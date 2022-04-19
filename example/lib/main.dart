import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:iposprinter/iposprinter.dart';
import 'package:iposprinter_example/testPrint.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  late IPOSPrinter posPrinter;

  @override
  void initState() {
    super.initState();
    posPrinter = IPOSPrinter.instance;
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    await posPrinter.initPrinter();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('IPOSPrinter Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            onPressed: () async {
              try {
                var status = await posPrinter.printerStatus();
                print("Printer Status: $status");
                if (status == 0) {
                  await posPrinter.printBlankLines(20, lineHeight: 10);
                }
              } catch(error) {
                print("Error: ${error.toString()}");
              }
            },
            child: const Text("Test Print")
          ),
        ),
      ),
    );
  }
}
