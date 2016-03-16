package javaselast.examples.decorator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("files/books.csv");

        MyBufferedReader myBufferedReader = new MyBufferedReader(reader);
        char[] b = new char[5];

        for (int i = 0; i < 7; i++) {
            myBufferedReader.read(b,0,b.length);
            System.out.println(new String(b));
        }

        myBufferedReader.close();

    }
}
