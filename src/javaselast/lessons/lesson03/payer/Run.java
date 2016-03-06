package javaselast.lessons.lesson03.payer;

public class Run {

    public static void main(String[] args) {

        PrivatePayer[] payers = new PrivatePayer[5];

        for (int i = 0; i < payers.length; i++) {
            payers[i] = new PrivatePayer(1,"name"+i,"last"+i);
        }

        System.out.println(payers[1].pay(100));
        System.out.println(payers[3].pay(1000));
        System.out.println(payers[3].pay(10));
    }
}
