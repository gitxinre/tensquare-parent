package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xinre
 * @date 2019/1/29 15:23
 */
@Slf4j
public class MyReader {

    public static void main(String[] args) throws IOException {
        @Cleanup FileReader fileReader = null;

        fileReader = new FileReader("G:\\a平台2.0\\mfl\\访问地址.txt");



        // 单个读取
        /*while (true) {
            int read = fileReader.read();
            if (read == -1) {
                break;
            }
            System.out.println("read = " + (char) read);
        }*/

        // 定义一个字符数组，用于读到的字符字符
        // 方法返回的是读到的字符个数
        char[] charBuf = new char[3];

        int num = 0;
        while ((num = fileReader.read(charBuf)) != -1) {
            System.out.print(new String(charBuf, 0, num));
        }

    }
}
