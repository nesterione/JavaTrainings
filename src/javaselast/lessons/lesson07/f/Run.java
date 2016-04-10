package javaselast.lessons.lesson07.f;

import javaselast.lessons.lesson07.Init;

/**
 * Created by igor on 03.04.2016.
 */
public class Run {
    public static void main(String[] args) throws CloneNotSupportedException {
        Init a = new Init(123);

        //
        //Init b = new Init(a);
        //b.value = 1111;

        Init b = (Init)a.clone();
        b.value = 1111;

        System.out.println(a.value);
        System.out.println(b.value);
    }
}
