package javaselast.lessons.lesson08.regex;

public class Run {

    public static void main(String[] args) {


        String s = "sa    sdafsdf   \n  asdfsf        qw ret";

        //System.out.println(">>>"+s+"<<<");
        String[] str = s.split("[\t \n]+" );          //"\\s+");
        //s.sp

        System.out.println(str.length);

        for(String s1: str) {
            System.out.println(s1);
        }

    }

}
