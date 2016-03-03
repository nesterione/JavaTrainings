package javaselast.lessons.lesson02.classes.p2;

import javaselast.lessons.lesson02.classes.Man;

/**
 * Created by igor on 28.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        Man man = Man.get(); //new Man(1,"sdf",234);
        System.out.println(man);
    }
}
