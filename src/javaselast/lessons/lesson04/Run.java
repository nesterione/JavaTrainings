package javaselast.lessons.lesson04;

public class Run {

    public static void main(String[] args) {


        mark:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i+" "+j);
                if(i==1) {
                     break mark;
                }

            }
        }

    }
}
