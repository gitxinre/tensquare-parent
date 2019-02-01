package com.xinre.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * System.out 标准输出 控制台
 * System.in 标准输入 键盘
 *
 * @author xinre
 * @date 2019/1/30 14:51
 */
@Slf4j
public class ReadInKeyboard {

    public static void main(String[] args) throws IOException {
        readIn();
        getSystemProperty();
    }

    private static void readIn() throws IOException {

        InputStream in = System.in;
        InputStream in1 = new FileInputStream("G:\\a平台2.0\\mfl\\访问地址.txt");

        // 编码参数指定读取文件的字符编码，由于系统默认使用GBK编码，故读取的文件采用GBK编码，否则会乱码
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in1, Charset.forName("GBK")));

        OutputStream out = System.out;
        OutputStream out1 = new FileOutputStream("G:\\yy.txt");

        // 编码参数指定输出文件的字符编码，由于输出使用的是程序控制，而程序的编码时U8码，故需使用U8字符编码，否则会乱码
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            if ("over".equalsIgnoreCase(s)) {
                break;
            }
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    private static void getSystemProperty() throws IOException {

        PrintStream out = System.out;
        PrintWriter out1 = new PrintWriter(new FileWriter("G:\\SystemInfo.txt"), true);




        Properties properties = System.getProperties();
        properties.list(out1);
    }

}
