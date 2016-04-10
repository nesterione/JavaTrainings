package javaselast.lessons.lesson07.init;

public class InitExample {

    int a = initA();
    int b = 2;

    private int initA() {
        return b;
    }


    public static void main(String[] args) {
        InitExample a = new InitExample();
        System.out.println(a.a);
        System.out.println(a.b);
    }


}
