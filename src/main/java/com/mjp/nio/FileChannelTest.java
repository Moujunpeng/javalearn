package com.mjp.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {

        String filePath = "D:\\mjp1\\programworkspace\\springbootApplication\\nio.txt";

        File file = new File(filePath);
        FileOutputStream fileOutputStream=new FileOutputStream(file);

        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String name = "aaaaaa " + "";
        byteBuffer.put(name.getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);

        for(int i = 0;i< 1000;i++){

        }

        fileOutputStream.close();

    }


}
