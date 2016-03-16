package javaselast.examples.decorator;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {

    private char[] buffer = new char[15];
    private int start = buffer.length;

    private final Reader reader;

    public MyBufferedReader(Reader reader) {
        this.reader = reader;
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if(start>=buffer.length) {
            reader.read(buffer,0,buffer.length);
            System.out.println("real read start");
            start = 0;
        }

        for (int i = 0; i < len; i++) {
            cbuf[off+i] = buffer[start++];
        }

        return len;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
