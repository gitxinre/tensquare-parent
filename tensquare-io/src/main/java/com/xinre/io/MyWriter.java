package com.xinre.io;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xinre
 * @date 2019/1/29 14:04
 */
@Slf4j
public class MyWriter {

    public static void main(String[] args) throws IOException {

        @Cleanup FileWriter fileWriter = null;

        fileWriter = new FileWriter("G:/fileWriter.txt", true);

        fileWriter.write("yfhaha!");

        fileWriter.flush();

        fileWriter.write('8');


    }
}
