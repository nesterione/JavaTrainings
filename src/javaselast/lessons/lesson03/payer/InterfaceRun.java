package javaselast.lessons.lesson03.payer;

public class InterfaceRun {

    public static void main(String[] args) {

        Payer payer = new PrivatePayer(2, "sdfsdf", "rwrew");

        PrivatePayer p = new PrivatePayer(1, "user", "last name user");

        Payer payer1 = p;

        System.out.println(payer1.getClass());


    }
}
