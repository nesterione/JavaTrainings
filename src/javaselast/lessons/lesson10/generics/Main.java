package javaselast.lessons.lesson10.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * unchecked passing params.
 */
public final class Main {
    /**
     * static class.
     */
    private Main() { }

    /**
     * example.
     *
     * @param args cmd params.
     */
    public static void main(final String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(5);

        List a = integerList;
        a.add("text");

        System.out.println(integerList);
        System.out.println(integerList.get(2));
        int val = integerList.get(2);
    }
}
