package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author xinre
 * @date 2019/1/30 09:24
 */
@Slf4j
public class MyBufCopyFile {


    public static void main(String[] args) throws IOException {

        @Cleanup BufferedReader bufferedReader = null;

        @Cleanup BufferedWriter bufferedWriter = null;

        bufferedReader = new BufferedReader(new FileReader("tensquare-common\\src\\main\\java\\com\\xinre\\common\\util\\IdWorker.java"));

        bufferedWriter = new BufferedWriter(new FileWriter("yyyyyyyyyffffffffffff.txt"));

        String s = null;

        while ((s = bufferedReader.readLine()) != null) {
            log.info("写入数据：{}", s);
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }


    }
}
