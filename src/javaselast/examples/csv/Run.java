package javaselast.examples.csv;

import java.io.*;
import java.lang.reflect.Field;

public class Run {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        File file = new File("files/books.csv");
        System.out.println(file.exists());

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String[] fields = reader.readLine().split(",");

            Class<?> v = Book.class;
            Object ob = v.newInstance();

            String[] values = reader.readLine().split(",");


            for(int i=0;i< fields.length; i++) {

                Field field = v.getDeclaredField(fields[i].trim());
                field.setAccessible(true);

                if(field.getType().equals(String.class)) {
                    field.set(ob,values[i]);
                } else if (field.getType().equals(int.class)) {
                    field.set(ob, Integer.decode(values[i]));
                }

                field.setAccessible(false);
            }

            System.out.println(ob);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

