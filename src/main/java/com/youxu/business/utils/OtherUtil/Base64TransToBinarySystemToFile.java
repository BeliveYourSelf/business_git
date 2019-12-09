package com.youxu.business.utils.OtherUtil;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64TransToBinarySystemToFile {
    /**
     * 将base64格式的字符串转换成二进制流，并转换成图片
     */
    public static boolean changeBase64ToImage(String base64String, String pathString){
        //base64格式字符串为空，返回false
        if(base64String == null){
            return false;
        }
        BASE64Decoder decoder =new BASE64Decoder();
        try {
            //解码过程，即将base64字符串转换成二进制流
            byte[] imageByte=decoder.decodeBuffer(base64String);

            //生成图片路径和文件名
            OutputStream out =new FileOutputStream(pathString);
            out.write(imageByte);
            /*
             * 使用流时,都会有一个缓冲区,按一种它认为比较高效的方法来发数据:
             * 把要发的数据先放到缓冲区,缓冲区放满以后再一次性发过去,而不是分开一次一次地发.
             * 而flush()表示强制将缓冲区中的数据发送出去,不必等到缓冲区满.
             * 所以如果在用流的时候,没有用flush()这个方法,很多情况下会出
             * 现流的另一边读不到数据的问题,特别是在数据特别小的情况下.
             */
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return false;
        }
    }
}
