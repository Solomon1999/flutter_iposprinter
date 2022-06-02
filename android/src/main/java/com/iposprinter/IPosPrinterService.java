/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\AndroidStudioProjects\\IposPrinterTestDemo\\app\\src\\main\\aidl\\com\\iposprinter\\iposprinterservice\\IPosPrinterService.aidl
 */
package com.iposprinter.iposprinterservice;
public interface IPosPrinterService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.iposprinter.iposprinterservice.IPosPrinterService
{
private static final java.lang.String DESCRIPTOR = "com.iposprinter.iposprinterservice.IPosPrinterService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.iposprinter.iposprinterservice.IPosPrinterService interface,
 * generating a proxy if needed.
 */
public static com.iposprinter.iposprinterservice.IPosPrinterService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.iposprinter.iposprinterservice.IPosPrinterService))) {
return ((com.iposprinter.iposprinterservice.IPosPrinterService)iin);
}
return new com.iposprinter.iposprinterservice.IPosPrinterService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPrinterStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPrinterStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_printerInit:
{
data.enforceInterface(DESCRIPTOR);
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg0;
_arg0 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printerInit(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPrinterPrintDepth:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.setPrinterPrintDepth(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setPrinterPrintFontType:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.setPrinterPrintFontType(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setPrinterPrintFontSize:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.setPrinterPrintFontSize(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setPrinterPrintAlignment:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.setPrinterPrintAlignment(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printerFeedLines:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printerFeedLines(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printBlankLines:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg2;
_arg2 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printBlankLines(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_printText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printText(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printSpecifiedTypeText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg3;
_arg3 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printSpecifiedTypeText(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_PrintSpecFormatText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg4;
_arg4 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.PrintSpecFormatText(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_printColumnsText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int[] _arg1;
_arg1 = data.createIntArray();
int[] _arg2;
_arg2 = data.createIntArray();
int _arg3;
_arg3 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg4;
_arg4 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printColumnsText(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_printBitmap:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.graphics.Bitmap _arg2;
if ((0!=data.readInt())) {
_arg2 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg3;
_arg3 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printBitmap(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_printBarCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg5;
_arg5 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printBarCode(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_printQRCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg3;
_arg3 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printQRCode(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_printRawData:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printRawData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_sendUserCMDData:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.sendUserCMDData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_printerPerformPrint:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.iposprinter.iposprinterservice.IPosPrinterCallback _arg1;
_arg1 = com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.asInterface(data.readStrongBinder());
this.printerPerformPrint(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.iposprinter.iposprinterservice.IPosPrinterService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int getPrinterStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinterStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Printer initialization
	 * The printer powers up and initializes default settings
	 * Please check the printer status when using, please wait when PRINTER_IS_BUSY
	 * @param callback execution result callback
	 * @return
    */
@Override public void printerInit(com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printerInit, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Set the print density of the printer, which will affect subsequent printing unless initialized
	 * @param depth: concentration level, range 1-10, beyond the range this function will not be executed Default level 6
	 * @param callback execution result callback
	 * @return
    */
@Override public void setPrinterPrintDepth(int depth, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(depth);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setPrinterPrintDepth, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Set the print font type, which will affect subsequent printing unless initialized
	 * (Currently only one font ST is supported, and more fonts will be supported in the future)
	 * @param typeface: Font name ST (California)
	 * @param callback execution result callback
	 * @return
    */
@Override public void setPrinterPrintFontType(java.lang.String typeface, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(typeface);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setPrinterPrintFontType, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Set the font size, which will affect subsequent printing unless initialized
	 *Note: Font size is beyond standard international instructions for printing,
	 * Adjusting the font size will affect the character width, and the number of characters per line will also change,
	 * Therefore, the typesetting formed by monospaced fonts may be confusing and need to be adjusted by yourself
	 * @param fontsize: font size, currently supported sizes are 16, 24, 32, 48, and the default value is 24 if an illegal size is entered
	 * @param callback execution result callback
	 * @return
	*/
@Override public void setPrinterPrintFontSize(int fontsize, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(fontsize);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setPrinterPrintFontSize, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Set the alignment, which will affect subsequent printing unless initialized
	 * @param alignment: alignment 0--left, 1--center, 2--right, center by default
	 * @param callback execution result callback
	 * @return
    */
@Override public void setPrinterPrintAlignment(int alignment, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(alignment);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setPrinterPrintAlignment, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Printer paper feed (Forced line feed, after finishing the previous print content, paper feed lines line, at this time the motor is idling to feed paper, no data is sent to the printer)
	 * @param lines: The number of lines the printer runs on (each line is a pixel)
	 * @param callback execution result callback
	 * @return
    */
@Override public void printerFeedLines(int lines, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(lines);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printerFeedLines, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Print a blank line (force a newline, print a blank line after the end of the previous print content,
 	 * and the data sent to the printer at this time is all 0x00)
	 * @param lines: print blank lines, limit up to 100 lines
	 * @param height: height of blank line (unit: pixel)
	 * @param callback execution result callback
	 * @return
    */
@Override public void printBlankLines(int lines, int height, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(lines);
_data.writeInt(height);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printBlankLines, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * print text
	 * Text width full line wrapping typesetting
	 * @param text: the text string to print
	 * @param callback execution result callback
	 * @return
    */
@Override public void printText(java.lang.String text, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Print the specified font type and size text, the font setting is only valid for this time
	 * Text width full line wrapping typesetting
	 * @param text: the text string to print
	 * @param typeface: font name ST (currently only one is supported)
	 * @param fontsize: font size, currently supported sizes are 16, 24, 32, 48, and the default value is 24 if an illegal size is entered
	 * @param callback execution result callback
	 * @return
    */
@Override public void printSpecifiedTypeText(java.lang.String text, java.lang.String typeface, int fontsize, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeString(typeface);
_data.writeInt(fontsize);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printSpecifiedTypeText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Print the specified font type and size text, the font setting is only valid for this time
	 * Text width full line wrapping typesetting
	 * @param text: the text string to print
	 * @param typeface: font name ST (currently only one is supported)
	 * @param fontsize: font size, currently supported sizes are 16, 24, 32, 48, and the default value is 24 if an illegal size is entered
	 * @param alignment: alignment (0 left, 1 center, 2 right)
	 * @param callback execution result callback
	 * @return
    */
@Override public void PrintSpecFormatText(java.lang.String text, java.lang.String typeface, int fontsize, int alignment, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeString(typeface);
_data.writeInt(fontsize);
_data.writeInt(alignment);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_PrintSpecFormatText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Print a row of the table, you can specify the column width and alignment
	 * @param colsTextArr array of text strings for each column
	 * @param colsWidthArr The width of each column array The total width cannot be greater than ((384 / fontsize) << 1)-(number of columns + 1)
	 * (calculated in English characters, each Chinese character occupies two English characters, each width is greater than 0),
	 * @param colsAlign the alignment of each column (0 to the left, 1 to the center, 2 to the right)
	 * @param isContinuousPrint whether to continue printing the form 1: continue printing 0: do not continue printing
	 * Remark: The array length of the three parameters should be the same, if the width of colsTextArr[i] is greater than colsWidthArr[i], the text wraps
	 * @param callback execution result callback
	 * @return
	*/
@Override public void printColumnsText(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign, int isContinuousPrint, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(colsTextArr);
_data.writeIntArray(colsWidthArr);
_data.writeIntArray(colsAlign);
_data.writeInt(isContinuousPrint);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printColumnsText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * print pictures
	 * @param alignment: alignment 0--left, 1--center, 2--right, center by default
	 * @param bitmapSize : The size of the bitmap, the incoming size range is 1~16, and the default selection is 10 if it exceeds the range. Unit: 24bit
	 * @param mBitmap: Image bitmap object (maximum width is 384 pixels, more than can not be printed and callback exception function)
	 * @param callback execution result callback
	 * @return
    */
@Override public void printBitmap(int alignment, int bitmapSize, android.graphics.Bitmap mBitmap, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(alignment);
_data.writeInt(bitmapSize);
if ((mBitmap!=null)) {
_data.writeInt(1);
mBitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printBitmap, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Print 1D barcode
	 * @param data: barcode data
	 * @param symbology: barcode type
	 * 0 -- UPC-A,
	 *1 -- UPC-E,
	 *2 -- JAN13(EAN13),
	 *3 -- JAN8(EAN8),
	 *4 -- CODE39,
	 *5 -- ITF,
	 *6 -- CODABAR,
	 *7 -- CODE93,
	 *8 -- CODE128
	 * @param height: The height of the barcode, the value is 1 to 16, the default value is 6 if it exceeds the range, and each unit represents the height of 24 pixels
	 * @param width: barcode width, the value ranges from 1 to 16, if it exceeds the range, the default value is 12, each unit represents the length of 24 pixels
	 * @param textposition: text position 0--do not print text, 1--text is above the barcode, 2--text is below the barcode, 3--print both above and below the barcode
	 * @param callback execution result callback
	 * @return
	*/
@Override public void printBarCode(java.lang.String data, int symbology, int height, int width, int textposition, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
_data.writeInt(symbology);
_data.writeInt(height);
_data.writeInt(width);
_data.writeInt(textposition);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printBarCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Print QR code
	 * @param data: QR code data
	 * @param modulesize: QR code block size (unit: point, value from 1 to 16 ), the default value is 10 if it exceeds the setting range
	 * @param mErrorCorrectionLevel : 2D error correction level (0:L 1:M 2:Q 3:H)
	 * @param callback execution result callback
	 * @return
	*/
@Override public void printQRCode(java.lang.String data, int modulesize, int mErrorCorrectionLevel, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
_data.writeInt(modulesize);
_data.writeInt(mErrorCorrectionLevel);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printQRCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * print raw byte data
	 * @param rawPrintData Byte data block
	 * @param callback result callback
	*/
@Override public void printRawData(byte[] rawPrintData, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(rawPrintData);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printRawData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Use ESC/POS command to print
	 * @param data directive
	 * @param callback result callback
	*/
@Override public void sendUserCMDData(byte[] data, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(data);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_sendUserCMDData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * execute print
	 * After executing each printing function method, this method needs to be executed before the printer can execute printing;
	 * Before this method is executed, the printer status needs to be judged. When the printer is in PRINTER_NORMAL, this method is valid, otherwise it will not be executed.
	 * @param feedlines: print and feed freedlines point lines
	 * @param callback result callback
	*/
@Override public void printerPerformPrint(int feedlines, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(feedlines);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_printerPerformPrint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getPrinterStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_printerInit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setPrinterPrintDepth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setPrinterPrintFontType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setPrinterPrintFontSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setPrinterPrintAlignment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_printerFeedLines = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_printBlankLines = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_printText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_printSpecifiedTypeText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_PrintSpecFormatText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_printColumnsText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_printBitmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_printBarCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_printQRCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_printRawData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_sendUserCMDData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_printerPerformPrint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
}
public int getPrinterStatus() throws android.os.RemoteException;
/**
	 * Printer initialization
	 * The printer powers up and initializes default settings
	 * Please check the printer status when using, please wait when PRINTER_IS_BUSY
	 * @param callback execution result callback
	 * @return
    */
public void printerInit(com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Set the print density of the printer, which will affect subsequent printing unless initialized
	 * @param depth: concentration level, range 1-10, beyond the range this function will not be executed Default level 6
	 * @param callback execution result callback
	 * @return
    */
public void setPrinterPrintDepth(int depth, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Set the print font type, which will affect subsequent printing unless initialized
	 * (Currently only one font ST is supported, and more fonts will be supported in the future)
	 * @param typeface: Font name ST (California)
	 * @param callback execution result callback
	 * @return
    */
public void setPrinterPrintFontType(java.lang.String typeface, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Set the font size, which will affect subsequent printing unless initialized
	 *Note: Font size is beyond standard international instructions for printing,
	 * Adjusting the font size will affect the character width, and the number of characters per line will also change,
	 * Therefore, the typesetting formed by monospaced fonts may be confusing and need to be adjusted by yourself
	 * @param fontsize: font size, currently supported sizes are 16, 24, 32, 48, and the default value is 24 if an illegal size is entered
	 * @param callback execution result callback
	 * @return
	*/
public void setPrinterPrintFontSize(int fontsize, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Set the alignment, which will affect subsequent printing unless initialized
	 * @param alignment: alignment 0--left, 1--center, 2--right, center by default
	 * @param callback execution result callback
	 * @return
    */
public void setPrinterPrintAlignment(int alignment, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Printer paper feed (Forced line feed, after finishing the previous print content, paper feed lines line, at this time the motor is idling to feed paper, no data is sent to the printer)
	 * @param lines: The number of lines the printer runs on (each line is a pixel)
	 * @param callback execution result callback
	 * @return
    */
public void printerFeedLines(int lines, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Print a blank line (force a newline, print a blank line after the end of the previous print content, and the data sent to the printer at this time is all 0x00)
	 * @param lines: print blank lines, limit up to 100 lines
	 * @param height: height of blank line (unit: pixel)
	 * @param callback execution result callback
	 * @return
    */
public void printBlankLines(int lines, int height, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * print text
	 * Text width full line wrapping typesetting
	 * @param text: the text string to print
	 * @param callback execution result callback
	 * @return
    */
public void printText(java.lang.String text, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Print the specified font type and size text, the font setting is only valid for this time
	 * Text width full line wrapping typesetting
	 * @param text: the text string to print
	 * @param typeface: font name ST (currently only one is supported)
	 * @param fontsize: font size, currently supported sizes are 16, 24, 32, 48, and the default value is 24 if an illegal size is entered
	 * @param callback execution result callback
	 * @return
    */
public void printSpecifiedTypeText(java.lang.String text, java.lang.String typeface, int fontsize, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Print the specified font type and size text, the font setting is only valid for this time
	 * Text width full line wrapping typesetting
	 * @param text: the text string to print
	 * @param typeface: font name ST (currently only one is supported)
	 * @param fontsize: font size, currently supported sizes are 16, 24, 32, 48, and the default value is 24 if an illegal size is entered
	 * @param alignment: alignment (0 left, 1 center, 2 right)
	 * @param callback execution result callback
	 * @return
    */
public void PrintSpecFormatText(java.lang.String text, java.lang.String typeface, int fontsize, int alignment, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Print a row of the table, you can specify the column width and alignment
	 * @param colsTextArr array of text strings for each column
	 * @param colsWidthArr The width of each column array The total width cannot be greater than ((384 / fontsize) << 1)-(number of columns + 1)
	 * (calculated in English characters, each Chinese character occupies two English characters, each width is greater than 0),
	 * @param colsAlign the alignment of each column (0 to the left, 1 to the center, 2 to the right)
	 * @param isContinuousPrint whether to continue printing the form 1: continue printing 0: do not continue printing
	 * Remark: The array length of the three parameters should be the same, if the width of colsTextArr[i] is greater than colsWidthArr[i], the text wraps
	 * @param callback execution result callback
	 * @return
	*/
public void printColumnsText(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign, int isContinuousPrint, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * print pictures
	 * @param alignment: alignment 0--left, 1--center, 2--right, center by default
	 * @param bitmapSize : The size of the bitmap, the incoming size range is 1~16, and the default selection is 10 if it exceeds the range. Unit: 24bit
	 * @param mBitmap: Image bitmap object (maximum width is 384 pixels, more than can not be printed and callback exception function)
	 * @param callback execution result callback
	 * @return
    */
public void printBitmap(int alignment, int bitmapSize, android.graphics.Bitmap mBitmap, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Print 1D barcode
	 * @param data: barcode data
	 * @param symbology: barcode type
	 * 0 -- UPC-A,
	 *1 -- UPC-E,
	 *2 -- JAN13(EAN13),
	 *3 -- JAN8(EAN8),
	 *4 -- CODE39,
	 *5 -- ITF,
	 *6 -- CODABAR,
	 *7 -- CODE93,
	 *8 -- CODE128
	 * @param height: The height of the barcode, the value is 1 to 16, the default value is 6 if it exceeds the range, and each unit represents the height of 24 pixels
	 * @param width: barcode width, the value ranges from 1 to 16, if it exceeds the range, the default value is 12, each unit represents the length of 24 pixels
	 * @param textposition: text position 0--do not print text, 1--text is above the barcode, 2--text is below the barcode, 3--print both above and below the barcode
	 * @param callback execution result callback
	 * @return
	*/
public void printBarCode(java.lang.String data, int symbology, int height, int width, int textposition, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Print QR code
	 * @param data: QR code data
	 * @param modulesize: QR code block size (unit: point, value from 1 to 16 ), the default value is 10 if it exceeds the setting range
	 * @param mErrorCorrectionLevel : 2D error correction level (0:L 1:M 2:Q 3:H)
	 * @param callback execution result callback
	 * @return
	*/
public void printQRCode(java.lang.String data, int modulesize, int mErrorCorrectionLevel, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * print raw byte data
	 * @param rawPrintData Byte data block
	 * @param callback result callback
	*/
public void printRawData(byte[] rawPrintData, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * Use ESC/POS command to print
	 * @param data directive
	 * @param callback result callback
	*/
public void sendUserCMDData(byte[] data, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
/**
	 * execute print
	 * After executing each printing function method, this method needs to be executed before the printer can execute printing;
	 * Before this method is executed, the printer status needs to be judged. When the printer is in PRINTER_NORMAL, this method is valid, otherwise it will not be executed.
	 * @param feedlines: print and feed freedlines point lines
	 * @param callback result callback
	*/
public void printerPerformPrint(int feedlines, com.iposprinter.iposprinterservice.IPosPrinterCallback callback) throws android.os.RemoteException;
}
