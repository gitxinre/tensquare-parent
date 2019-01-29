package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xinre
 * @date 2019/1/29 10:39
 */

@Slf4j
public class MyInputStream {

    public static void main(String[] args) throws IOException {
        log.info("args is : {}", args.length);

        @Cleanup FileInputStream fileInputStream = null;
        @Cleanup FileOutputStream fileOutputStream = null;
        fileInputStream = new FileInputStream("G:\\a平台2.0\\mfl\\访问地址.txt");
        int size = fileInputStream.available();
        byte[] byteArray = new byte[size];
        fileInputStream.read(byteArray);
        String result = new String(byteArray, "GBK");
        System.out.println("result = " + result);


    }
}
