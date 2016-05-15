package javaselast.examples.csv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.StringJoiner;

/**
 * TASK Think about improve this class
 * think about arrays and other types
 * think about fields order
 *
 * implements arrays
 * implements recursive objects
 * add exceptions for every not implemented feature
 * add ignore not supported
 *
 * add ignore annotation
 * @param <T>
 */
public class CsvWriter<T> extends Writer {

    private BufferedWriter bufferedWriter;
    private Class<T> tClass;
    private boolean isHeaderWrote = false;
    private final static String SEPARATOR = "; ";

    public CsvWriter(Writer writer, Class<T> tClass) {

        if(writer instanceof BufferedWriter) {
            this.bufferedWriter = (BufferedWriter)writer;
        } else {
            this.bufferedWriter = new BufferedWriter(writer);
        }

        this.tClass = tClass;
    }


    private String formHeader(Field[] fields) {
        return formHeader(fields,null);
    }

    private String formHeader(Field[] fields, String prefix) {
        StringJoiner joiner = new StringJoiner(SEPARATOR);
        for(Field field: fields) {
            String name;

            String p = prefix==null?"":prefix+".";

            if(field.getType().isPrimitive()||field.getType().equals(String.class)) {
                name = field.getName();
                joiner.add(p+name);
            } else {
                name = formHeader(field.getType().getDeclaredFields(),p+field.getName());
                joiner.add(name);
            }
        }

        return joiner.toString();
    }

    private String typeValueToString(Class<?> type, Object obj) throws IllegalAccessException {
        String result;

        if(type.isPrimitive()) {
            result = obj.toString();
        } else if(type.equals(String.class)) {
            result = String.format("\"%s\"",obj);
        } else {
            result = String.format("%s", csvSerializeObject(obj,type));
        }

        return result;
    }

    private String csvSerializeObject(Object obj, Class<?> type) throws IllegalAccessException {

        Field[] fields = type.getDeclaredFields();
        StringJoiner joiner = new StringJoiner(SEPARATOR);

        for(Field field: fields) {
            field.setAccessible(true);

            Object v = field.get(obj);
            joiner.add( typeValueToString(field.getType(),v) );
            field.setAccessible(false);
        }

        return joiner.toString();
    }

    public void  writeObject(T  obj) throws IOException, IllegalAccessException {

        Field[] fields = tClass.getDeclaredFields();
        if(!isHeaderWrote) {
            bufferedWriter.write(formHeader(fields));
            isHeaderWrote = true;
        }

        bufferedWriter.newLine();
        bufferedWriter.write(csvSerializeObject(obj,tClass));
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        bufferedWriter.write(cbuf,off,len);
    }

    @Override
    public void flush() throws IOException {
        bufferedWriter.flush();
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
    }
}