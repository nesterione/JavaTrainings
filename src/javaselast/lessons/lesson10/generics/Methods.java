package javaselast.lessons.lesson10.generics;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static void print(List<? extends Number> list) {


        for (Number v : list) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(24);


        List<String> d = new ArrayList<>();
        d.add("df");
        d.add("432");

        //print(d);

    }
}