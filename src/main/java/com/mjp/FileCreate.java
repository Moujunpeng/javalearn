package com.mjp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreate {

    public static void main(String[] args) {

        String filePath = args[0];
        String fileName = args[1];

        try {
            FileWriter fileWriter = new FileWriter(filePath + File.separator + fileName);
            final BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write("hello\n");
            bw.write("world\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("create file error ");
        }

    }

}