package javaselast.lessons.lesson04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections {

    public static void main(String[] args) {

        new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(234);
        //list.add("sdf");
        list.add(1345);

        int a = list.get(1);

        System.out.println(list);
    }
}
