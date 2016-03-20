package javaselast.lessons.lesson03.payer;

public class InterfaceRun {

    public static void main(String[] args) {

        Payer p1 = new LegalPayer(1,"sdf","sdf");
        Payer p2 = new PrivatePayer(2,"pri","vate");


        System.out.println(p2 instanceof LegalPayer);
        //PrivatePayer p3 = (PrivatePayer) p1;


//        System.out.println(p1.pay(1000));
//        System.out.println(p2.pay(1000));
    }
}
