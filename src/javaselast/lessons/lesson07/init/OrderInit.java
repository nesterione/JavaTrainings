package javaselast.lessons.lesson07.init;

public class OrderInit {
    int a = -1;
    int a1 = -1;
    int a2 = -1;
    int a3 = -1;


    static int b = -1;

    {
        a = 1;
        b = 1;
    }

    static {
        System.out.println("init");
        b = 2;
    }

    public OrderInit() {
        a =4;
        b = 4;
    }
}
