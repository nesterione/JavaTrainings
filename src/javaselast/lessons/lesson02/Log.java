package javaselast.lessons.lesson02;

public class Log {

    public static void main(String[] args) {

        int a = 0b10101011;
        int b = 0b10111111;

        a = -5;

        System.out.println(  Integer.toBinaryString(a&b)    );
        System.out.println(  Integer.toBinaryString(a|b)    );
        System.out.println(  Integer.toBinaryString(a^b)    );
        System.out.println(  Integer.toBinaryString(~a)    );
        System.out.println("======");
        System.out.println(  Integer.toBinaryString(a>>1)    );
        System.out.println(  Integer.toBinaryString(a<<1)    );
        System.out.println(  Integer.toBinaryString(a>>>1)    );

        System.out.println(8>>1);
        System.out.println(8<<3);





    }

}
