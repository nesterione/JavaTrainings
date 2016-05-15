package javaselast.lessons.lesson10.classes;

import java.util.ArrayList;
import java.util.List;

public class InlineOverride {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(4);
                add(5);
            }
        };

        List<Integer> list1 = new ArrayList<>();

        System.out.println(list.getClass());
        System.out.println(list1.getClass());


    }
}
