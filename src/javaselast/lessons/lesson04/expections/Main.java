package javaselast.lessons.lesson04.expections;

import lesson.enums.Ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void my() {
       m2();
    }

    public static void m2( ) {
        int[] a = {1, 2};

        System.out.println(a[1]);

        int b = 0;
        int c = 23/b;
    }

//    public static void main(String[] args) {
//
//       try {
//           my();
//        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
//           //System.out.println(e.getMessage());
//           e.printStackTrace();
//        }
//
//
//    }

    public static void read() throws IOException {
        BufferedReader reader =
                new BufferedReader(new FileReader("sdf.c"));
        int b = reader.read();
    }


    public static void main(String[] args)  {

        try {
            read();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

}
