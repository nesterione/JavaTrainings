package javaselast.examples.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;

public class CsvReader extends Reader {

    private BufferedReader bufferedReader;

    public CsvReader(Reader reader) {
        bufferedReader = new BufferedReader(reader);
    }

    public <T> T readNext(Class<T> type) {

        try {

            T cl = type.newInstance();
//            Class<?> c = cl.getClass();
//            Field field = c.getDeclaredField("id");
//
//            field.set(cl,);


        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return bufferedReader.read(cbuf,off,len);
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
