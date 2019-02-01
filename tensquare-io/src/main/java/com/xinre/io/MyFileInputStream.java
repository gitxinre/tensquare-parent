package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author xinre
 * @date 2019/1/29 10:39
 */

@Slf4j
public class MyFileInputStream {

    public static void main(String[] args) throws IOException {
        log.info("args is : {}", args.length);

        @Cleanup FileInputStream fileInputStream = null;

        fileInputStream = new FileInputStream("G:\\a平台2.0\\mfl\\访问地址.txt");

        // 1、创建整好的字节数据进行读取
        /*int size = fileInputStream.available();
        log.info("1、创建整好的字节数据进行读取，字节数组的大小为：{}", size);
        byte[] byteArray = new byte[size];
        fileInputStream.read(byteArray);
        String result = new String(byteArray, "GBK");
        System.out.println("result = " + result);*/

        // 2、固定长度字节数组读取
        int size = 0;
        byte[] byteArray = new byte[2];
        while ((size = fileInputStream.read(byteArray)) != -1) {
            log.info("固定长度字节数组读取，固长为：{}", size);
            System.out.println("new String(byteArray,0,size) = " + new String(byteArray, 0, size, Charset.forName("GBK")));
        }


    }
}
