package javaselast.lessons.lesson03;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        //int[] b = a;
        int[] b = a.clone();

        b[0] = 777;

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
