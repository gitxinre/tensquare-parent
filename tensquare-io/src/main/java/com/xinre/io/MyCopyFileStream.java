package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author xinre
 * @date 2019/1/30 14:09
 */
@Slf4j
public class MyCopyFileStream {
    public static void main(String[] args) throws IOException {
        // mfl-7-yd.pdf

        @Cleanup BufferedInputStream bufferedInputStream = null;
        @Cleanup BufferedOutputStream bufferedOutputStream = null;

        bufferedInputStream = new BufferedInputStream(new FileInputStream("G:\\VTS_02_1.VOB"));
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("G:\\copy-VTS_02_1.VOB"));

        // 字节流创建完整字节数组进行copy
        /*int available = bufferedInputStream.available();
        System.out.println("available = " + available);
        byte[] bytes = new byte[available];
        int read = bufferedInputStream.read(bytes);
        System.out.println("read = " + read);
        bufferedOutputStream.write(bytes);*/

        int i = 0;
        // 固长字节数组copy
        byte[] bytes = new byte[40960];
        while (bufferedInputStream.read(bytes) != -1) {
            i++;
            System.out.println("i = " + i);
            bufferedOutputStream.write(bytes);
        }

    }

}
