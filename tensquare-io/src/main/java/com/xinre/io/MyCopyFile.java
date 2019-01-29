package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xinre
 * @date 2019/1/29 16:47
 */
@Slf4j
public class MyCopyFile {

    public static void main(String[] args) throws IOException {

        // 1、在目标盘符创建文件
        // 2、读取源文件入流
        // 3、把读到的字符写入到目标文件

        @Cleanup FileReader fileReader = null;
        @Cleanup FileWriter fileWriter = null;


        fileWriter = new FileWriter("F:\\copy_fileWriter.txt");
        fileReader = new FileReader("G:\\fileWriter.txt");

        int size = 0;

        char[] cBuf = new char[3];

        while ((size = fileReader.read(cBuf)) != -1) {
            String s = new String(cBuf, 0, size);
            fileWriter.write(cBuf, 0, size);
            log.info("写入字符串：{}", s);
        }
    }
}
