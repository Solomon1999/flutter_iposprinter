package com.iposprinter.Utils;

import java.io.UnsupportedEncodingException;

import android.util.Log;

public class ESCUtil{
    public static final String TAG = "ESCUtil";
    public static final byte ESC = 27;  // Escape
    public static final byte FS = 28;   // Text separator
    public static final byte GS = 29;   // Group Separator
    public static final byte DLE = 16;  // Data connection escape
    public static final byte EOT = 4;   // End of transmission
    public static final byte ENQ = 5;   // Query Character
    public static final byte ACK = 6;   // Get Notified
    public static final byte SP = 32;   // Space
    public static final byte HT = 9;    // Horizontal Tab
    public static final byte LF = 10;   // Print and wrap (horizontal positioning)
    public static final byte CR = 13;   // Homing (carriage return)
    public static final byte FF = 12;   // Paper feed control
    public static final byte CAN = 24;  // Cancel printing

    /**
     * Get printer status
     */
    public static byte[] getPrinterStatus()
    {
        byte[] result = new byte[3];
        result[0] = ENQ;
        result[1] = 0x11;
        result[2] = 0x00;
        return result;
    }

    /**
     * Printer initialization
     *@return
     */
    public static byte[] init_printer()
    {
        byte[] result = new byte[2];
        result[0] = ESC;
        result[1] = 64;
        return result;
    }

    /**
     * Newline
     * @param lineNum Number of newlines
     * @return
     */
    public static byte[] nextLines(int lineNum)
    {
        byte[] result = new byte[lineNum];
        for (int i = 0;i < lineNum;i++)
        {
            result[i] = LF;
        }
        return result;
    }

    /**
     * tab
     * @return
     */
    public static byte[] HTCmd()
    {
        byte[] result = new byte[]{HT};
        return result;
    }

    /**
     * Set the character right spacing unit pixel,
     * which is an integer multiple of 8
     * @return
     */
    public static byte[] setRightSpaceChar(byte n)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = SP;
        result[2] = n;
        return result;
    }

    /**
     * print underline mode settings
     *@return
     */
    public static byte[] printUnderlineModeEn(boolean en){
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 33;
        if(en)
            result[2] = (byte) 0x80;
        else
            result[2] =  0x00;
        return result;
    }

    /**
     * Set absolute print position
     *@param n The unit pixel is an integer multiple of 8
     *@return
     */
    public static byte[]  absolutePrintPosition(int n)
    {
        byte[] result = new byte[4];
        result[0] = ESC;
        result[1] = 36;
        result[2] = (byte)(n%256);
        result[3] = (byte)(n/256);
        return result;
    }

    /**
     * print bitmap data
     */
    public static byte[] printBmpData()
    {
        byte[] result = new byte[4];
        return result;
    }

    /**
     * Underline settings
     * @param n  0, 1 , 2 or 48, 49, 50
     * @return
     */
    public static byte[] underlineWithWidthOn(byte n)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 45;
        result[2] = n;
        return result;
    }

    /**
     * set default row height
     */
    public static byte[] defaultLineHeight()
    {
        byte[] result = new byte[2];
        result[0] = ESC;
        result[1] = 50;
        return result;
    }


    /**
     * set row height
     * @param n line height pixels
     * @return
     */
    public static byte[] setLineHeight(byte n)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 51;
        result[2] = n;
        return result;
    }
    /**
     * Shift right n columns horizontally
     * @param cols Unit character width (including right spacing)
     * @return
     */
    public static byte[] set_HT_position(byte[] cols) {
        byte[] result = new byte[6];
        result[0] = ESC;
        result[1] = 68;
        result[2] = cols[0];
        result[3] = cols[1];
        result[4] = cols[2];
        result[5] = 0;
        return result;
    }

    /**
     * Double width, double height mode
     * @return
     */
    public static byte[] widthAndheightMode(byte mode)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 33;
        result[2] = (byte)(mode & 0x30);
        return result;
    }

    /**
     * Bold mode not supported yet
     * @return
     */
    public static byte[] boldOnOff(byte mode)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 69;
        result[2] = mode;
        return result;
    }

    /**
     * print and feed n dot lines
     */
    public static byte[] performPrintAndFeedPaper(byte n)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 74;
        result[2] = n;
        return result;
    }

    /**
     * print and feed n lines character line character height
     */
    public static byte[] performPrintFeedPaperLines(byte n)
    {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 100;
        result[2] = n;
        return result;
    }

    /**
     * Set the horizontal relative print position
     * @param n The number of ASCII characters in the current font size
    */
    public static byte[]  relativePrintPosition(int n)
    {
        byte[] result = new byte[4];
        result[0] = ESC;
        result[1] = 92;
        result[2] = (byte)(n%256);
        result[3] = (byte)(n/256);
        return result;
    }
    /**
     * alignment mode
     * @return
     */
    public static byte[] alignMode(byte align) {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 97;
        result[2] = align;
        return result;
    }


    /**
     * Font (type) settings
     * @param type :0:A  1:B
     * @return
     */
    public static byte[] fontTypeSet(byte type){

        byte[] result = new byte[3];

        result[0] = ESC;
        result[1] = 77;
        result[2] = type;
        return result;
    }


    /**
     * Font (size) settings
     * @param size :0x00:16  0x11:24   0x22:32  0x33:48
     * @return
     */
    public static byte[] fontSizeSet(byte size){

        byte[] result = new byte[3];


        result[0] = GS;
        result[1] = 33;
        result[2] = size;
        return result;
    }

    /**
     * Set the print left margin
     *@param n The unit pixel is an integer multiple of 8
     *@return
     */
    public static byte[]  printLeftMargin(int n)
    {
        byte[] result = new byte[4];
        result[0] = GS;
        result[1] = 76;
        result[2] = (byte)(n%256);
        result[3] = (byte)(n/256);
        return result;
    }

    /**
     * Set the print area width
     *@param n The unit pixel is an integer multiple of 8
     *@return
     */
    public static byte[]  printAreaWidth(int n)
    {
        byte[] result = new byte[4];
        result[0] = GS;
        result[1] = 87;
        result[2] = (byte)(n%256);
        result[3] = (byte)(n/256);
        return result;
    }

    // Set Chinese character mode
    public static byte[] selectChineseMode()
    {
        byte[] result = new byte[2];
        result[0] = FS;
        result[1] = 38;
        return result;
    }


    // Cancel Kanji mode
    public static byte[] CancelChineseMode()
    {
        byte[] result = new byte[2];
        result[0] = FS;
        result[1] = 46;
        return result;
    }

    // Set Kanji Code System
    public static byte[] selectCharCodeSystem(byte mode) {
        byte[] result = new byte[3];
        result[0] = FS;
        result[1] = 67;
        result[2] = mode;
        return result;
    }

    /**
     * Select char code table
     * @param mode 0,48 :System default 1, 49: GBK
     * @return
     */
    public static byte[] selectCharCodeTable(byte mode) {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 116;
        result[2] = mode;
        return result;
    }

    /**
     * Intl Coding system selection
     * @param mode 0,48 :System default 1, 49: GBK
     * @return
     */
    public static byte[] selectIntlCharCodeSystem(byte mode) {
        byte[] result = new byte[3];
        result[0] = ESC;
        result[1] = 82;
        result[2] = mode;
        return result;
    }

    // Barcode Printing
    public static byte[] barcodePrint()
    {
        byte[] result = new byte[]{GS,107};
        return result;
    }

    // Set the print position of HRI characters
    public static byte[] setHRIPosition(int position)
    {
        byte[] result = new byte[3];
        result[0] = GS;
        result[1] = 72;
        result[2] = (byte)position;
        return result;
    }

    /**
     * Set barcode height
     * @param height :1-16 Unit 24 pixels
     * @return
     */

    public static byte[] setBarcodeHeight(int height)
    {
        byte[] result = new byte[3];
        result[0] = GS;
        result[1] = 104;
        result[2] = (byte)height;
        return result;
    }

    /**
     * Set barcode width
     * @param width ：1-16 units of 24 pixels
     * @return
     */
    public static byte[] setBarcodeWidth(int width)
    {
        byte[] result = new byte[3];
        result[0] = GS;
        result[1] = 119;
        result[2] = (byte)width;
        return result;
    }

    /**
     * Generate barcode verification code
     */
    public static int barcodeCheckCode(String codedata)
    {
        int sum=0;
        int sum1=0;
        int sum2=0;
        int checkCode=0;
        for(int i= codedata.length()-1;i >= 0;i -= 2)
        {
           sum1 += (codedata.charAt(i) -'0');
        }

        for(int i= codedata.length()-2;i >= 0;i -= 2)
        {
            sum2 += (codedata.charAt(i) -'0');
        }

        sum = sum1*3 + sum2;

        if(sum%10 == 0)
        {
            checkCode = 0;
        }
        else
        {
            checkCode = 10 - (sum%10);
        }
        Log.d(TAG,"checkCode:"+checkCode);
        return checkCode;
    }
    /**
     * Generate barcode data
     */
    public static byte[] barcodeData(int mode,String data)
    {

        String barcodeData = data;
        byte[] modetype= new byte[]{(byte)mode};
        byte[] codePackageFlage = new byte[1];
        int checkCode = 0;
        switch (mode)
        {
            case 0:
            case 1:
            case 2:
            case 3:
                checkCode = barcodeCheckCode(barcodeData);
                Log.d(TAG,"barcodeData:"+barcodeData+"  ***String.valueOf(checkCode):"+String.valueOf(checkCode));
                barcodeData += String.valueOf(checkCode);
            case 4:
            case 5:
            case 6:
                codePackageFlage[0] = 0;
                break;
            case 65:
            case 66:
            case 67:
            case 68:
                checkCode = (byte)barcodeCheckCode(barcodeData);
                barcodeData += String.valueOf(checkCode);
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                codePackageFlage[0] = (byte)barcodeData.length();
                break;
            default:
        }
        Log.d(TAG,"modetype:"+modetype[0]+"## barcodeData:"+barcodeData+"  **codePackageFlage:"+codePackageFlage[0]);
        byte[] mBarcodeData = new byte[barcodeData.length()];

        try {
            mBarcodeData = barcodeData.getBytes("gb2312");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        if(codePackageFlage[0] == 0)
        {
            byte[][] result = {modetype,mBarcodeData,codePackageFlage};
            return byteMerger(result);
        }
        else
        {
            byte[][] result = {modetype,codePackageFlage,mBarcodeData};
            return byteMerger(result);
        }
    }

    /**
     * Set QR code size
     * @param size 1-16 units of 24 pixels
     */
    public static byte[] setQRsize(int size)
    {
        byte[] result = new byte[]{GS,40,107,3,0,49,67,0};
        result[7] = (byte)size;
        return result;
    }



    /**
     * Set QR code error correction level
     * @param corr
     */
    public static byte[] setQRCorrectionLevel(int corr)
    {
        byte[] result = new byte[]{GS,40,107,3,0,49,69,0};
        result[7] = (byte)corr;
        return result;
    }

    /**
     * Store QR code data
     */
    public static byte[] cacheQRData(byte[] mQRData)
    {
        byte[] mQRHeadCode = new byte[]{GS,40,107,0,0,49,80,48};
        int cmdDataLen = mQRData.length + 3;
        mQRHeadCode[3] = (byte)(cmdDataLen%256);
        mQRHeadCode[4] = (byte)(cmdDataLen/256);

        byte[][] cmdData = {mQRHeadCode,mQRData};

        return byteMerger(cmdData);
    }

    /**
     * Print the stored QR code
     * (other cached data is cleared）
     */
    public static byte[] printCacheQRdata()
    {
        byte[] result = new byte[]{GS,40,107,3,0,49,81,48};
        return result;
    }

    /**
     * Bitmap packet, header information
     */
    public static byte[] bmpCmdHead(int mode, int bitmapWidth)
    {
        byte[] result = new byte[]{ESC,42,0,0,0};
        result[2] = (byte)mode;
        result[3] = (byte)(bitmapWidth%256);
        result[4] = (byte)(bitmapWidth/256);
        return result;
    }

    /**
     * Raster bitmap header information
     */
    public static byte[] rasterBmpHead(int mode, int widthBytes,int height)
    {
        byte[] result = new byte[]{GS,118,48,0,0,0,0,0};
        result[3] = (byte)mode;
        result[4] = (byte)(widthBytes%256);
        result[5] = (byte)(widthBytes/256);
        result[6] = (byte)(height%256);
        result[7] = (byte)(height/256);
        return result;
    }

    /**
     * Integrate print data
     * @param byteList
     * @return
     */
    public static byte[] byteMerger(byte[][] byteList) {

        int length = 0;
        for (int i = 0; i < byteList.length; i++) {
            length += byteList[i].length;
        }
        byte[] result = new byte[length];

        int index = 0;
        for (int i = 0; i < byteList.length; i++) {
            byte[] nowByte = byteList[i];
            for (int k = 0; k < byteList[i].length; k++) {
                result[index] = nowByte[k];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            // CommonUtils.LogWuwei("", "result[" + i + "] is " + result[i]);
        }
        return result;
    }

    public static byte[] generateUserData(){
        try{
            byte[] initPrinter = ESCUtil.init_printer();
            byte[] selectChinese = ESCUtil.selectChineseMode();
            byte[] charCode = ESCUtil.selectCharCodeSystem((byte) 0x01);
            byte[] next2Line = ESCUtil.nextLines(2);
            byte[] lineH1 = ESCUtil.setLineHeight((byte)35);
            byte[] fontSize1 = ESCUtil.fontSizeSet((byte) 0x33);
            byte[] align1 = ESCUtil.alignMode((byte)0x1);
            byte[] title2 = "蓝牙打印机测试\n".getBytes("gb2312");
            byte[] fontSize2 = ESCUtil.fontSizeSet((byte) 0x22);
            byte[] title1 = "Bluetooth Printer test\n".getBytes("gb2312");
            byte[] align2 = ESCUtil.alignMode((byte)0x0);
            byte[] fontSize3 = ESCUtil.fontSizeSet((byte) 0x22);
            byte[] orderSerinum = "1234567890\n".getBytes("gb2312");
            byte[] fontSize4 = ESCUtil.fontSizeSet((byte) 0x11);
            byte[] specialSign= "!@#$%^&*()κρχκμνκλρκνκνμρτυφ".getBytes("gb2312");
            byte[] fontSize5 = ESCUtil.fontSizeSet((byte) 0x11);
            byte[] testSign = "*****************\n-----------------\n".getBytes("gb2312");
            byte[] fontSize6 = ESCUtil.fontSizeSet((byte) 0x33);
            byte[] testInfo = "欢迎使用打印机".getBytes("gb2312");
            byte[] nextLine = ESCUtil.nextLines(1);
            byte[] performPrint = ESCUtil.performPrintAndFeedPaper((byte)200);

            byte[][] cmdBytes = {initPrinter,selectChinese,charCode,lineH1,fontSize1,align1,title2,fontSize2,title1,next2Line,align2,
                                fontSize3,orderSerinum,fontSize4,specialSign,fontSize5,testSign,fontSize6,testInfo,nextLine,performPrint};

            return ESCUtil.byteMerger(cmdBytes);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
