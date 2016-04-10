package javaselast.lessons.lesson07.init.exp;

import javaselast.lessons.lesson07.constructors.Example;

/**
 * Created by igor on 03.04.2016.
 */
public class Run {

    public static void main(String[] args) {

        try {
            E e = new E();
        } catch (Exception ex) {
            System.out.println("catch");
        }

    }
}
