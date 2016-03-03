package javaselast.lessons.lesson02.arrays;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {

        int[] a = {1,2,3,4};


        String[] s = {"asdf","234"};
        //a = {23,4,5};

        int n = 234;
        int[] a1 = new int[n];

        String[] aa = new String[5];
        System.out.println(Arrays.toString(aa));

        System.out.println(a.length);

        for(int i = 0; i< a.length;i++) {
            System.out.println(a[i]);
        }

        for(int el : a) {
            System.out.println(el);
        }

    }
}
