package javaselast.lessons.lesson10.generics;

import java.util.ArrayList;
import java.util.List;

public class DontUse {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(123);

        List ulist = list;
        ulist.add("sdf");

        System.out.println(list);

    }
}
