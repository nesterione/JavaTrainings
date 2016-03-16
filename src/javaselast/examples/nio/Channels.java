package javaselast.examples.nio;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class Channels {
    public static void main(String[] args) throws IOException {
        File f = new File("files/books.csv");
        RandomAccessFile ra = new RandomAccessFile(f,"rw");
        FileChannel channel = ra.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int br = channel.read(byteBuffer);

        while (br!=-1) {

            System.out.println(byteBuffer);
            byteBuffer.flip();

            while ((byteBuffer.hasRemaining())) {
                System.out.println((char)byteBuffer.get());
            }

            byteBuffer.clear();
            br = channel.read(byteBuffer);

        }
    }
}
