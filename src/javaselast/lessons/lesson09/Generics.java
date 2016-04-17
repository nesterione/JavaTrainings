package javaselast.lessons.lesson09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(234);
        //list.add("sdf");

        int val = (int)list.get(0);

        System.out.println(list);

    }
}

class My<T> {

}