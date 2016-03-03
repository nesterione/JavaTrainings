package javaselast.lessons.lesson02;

public class Loops {

    public static void main(String[] args) {

        for(int i = 0; i<3;i++) {
            System.out.println(i);
        }

        int j = 0;
        while (j<3) {

            System.out.println(j);
            j++;
        }

        int k = 0;
        do {
            System.out.println(k);
            k++;
        } while (k<3);


        int[] vals = {1,2,3};
        for(int v: vals) {
            System.out.println(v);
        }

    }
}
