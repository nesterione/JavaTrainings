package javaselast.lessons.lesson05.addressbook.ui;

import javaselast.lessons.lesson05.addressbook.bll.Repository;
import javaselast.lessons.lesson05.addressbook.bll.RepositoryFactory;

import java.util.Collections;

public class Run {
    public static void main(String[] args) {


        Repository repository = RepositoryFactory.memRepository();

//        String s = "";
//        for (int i = 0; i < 10; i++) {
//            s+=i;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            sb.append(i);
//        }
//
//        System.out.println(s);
//        System.out.println(sb.toString());

        /*
        StringBuilder ss = new StringBuilder();
        ss.append(34);

        StringBuffer s = new StringBuffer();
        s.append(34);*/
//
//        String a = "abc";
//        String b= new String("abc");
//        String c = b.intern();
//
//        System.out.println(a==c);

        //String b = a.toUpperCase()+"234";

        //a = a.toUpperCase();

        //System.out.println(a);

        //System.out.println(b);




        //Repository repository = RepositoryFactory.memRepository();

        //System.out.println(repository.getAll());

    }
}
