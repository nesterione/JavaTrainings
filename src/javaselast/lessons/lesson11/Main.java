package javaselast.lessons.lesson11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //M<String> a = new M<>(String.class);
        //Object[] ad = new Integer[4];

        double a = 1.0;

        int c = 0;

        for(int i = 0; i< 4;i++) {

            if(a<i*0.1) {
                break;
            }

            a-=i*0.1;
            c++;
        }
        System.out.println(c);
    }



}

class M<T> {

    private Class<? extends T> type;

    public M(  Class<? extends T> type) {
        this.type = type;
    }


    public void g() {

    }

}