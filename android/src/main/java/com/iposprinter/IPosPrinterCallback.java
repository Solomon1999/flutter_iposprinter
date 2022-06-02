/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\AndroidStudioProjects\\IposPrinterTestDemo\\app\\src\\main\\aidl\\com\\iposprinter\\iposprinterservice\\IPosPrinterCallback.aidl
 */
package com.iposprinter.iposprinterservice;
/**
 * Callback for printing service execution result
 */
public interface IPosPrinterCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.iposprinter.iposprinterservice.IPosPrinterCallback
{
private static final java.lang.String DESCRIPTOR = "com.iposprinter.iposprinterservice.IPosPrinterCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.iposprinter.iposprinterservice.IPosPrinterCallback interface,
 * generating a proxy if needed.
 */
public static com.iposprinter.iposprinterservice.IPosPrinterCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.iposprinter.iposprinterservice.IPosPrinterCallback))) {
return ((com.iposprinter.iposprinterservice.IPosPrinterCallback)iin);
}
return new com.iposprinter.iposprinterservice.IPosPrinterCallback.Stub.Proxy(obj);
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
case TRANSACTION_onRunResult:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onRunResult(_arg0);
return true;
}
case TRANSACTION_onReturnString:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onReturnString(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.iposprinter.iposprinterservice.IPosPrinterCallback
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
/**
 	* return execution result
 	* @param isSuccess: true executes successfully, false executes failure
	*/
@Override public void onRunResult(boolean isSuccess) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isSuccess)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onRunResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
 	* return result (string data)
 	* @param result: the result, the length of the print since the printer was powered on (unit: mm)
	*/
@Override public void onReturnString(java.lang.String result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(result);
mRemote.transact(Stub.TRANSACTION_onReturnString, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onRunResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onReturnString = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
 	* return execution result
 	* @param isSuccess: true executes successfully, false executes failure
	*/
public void onRunResult(boolean isSuccess) throws android.os.RemoteException;
/**
 	* return result (string data)
 	* @param result: the result, the length of the print since the printer was powered on (unit: mm)
	*/
public void onReturnString(java.lang.String result) throws android.os.RemoteException;
}
