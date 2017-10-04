package com.zhang.Controller;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

/**
 * 读取文件
 */
public class Main {
    public static void main(String[] args) {
        File file = new FileSystemResource("zhang_web/src/main/resources/logback.xml").getFile();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                System.out.println(tempString);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
