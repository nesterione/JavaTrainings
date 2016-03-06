package javaselast.lessons.lesson03.input;

import java.io.InputStream;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextLine());
//
//        System.out.println("finish");

        System.out.println(Input.nextInt("enter number","formant error"));
        System.out.println(Input.nextString("enter number","formant error"));
    }
}

class Input {

    private Input() {}

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }


    public static int nextInt(String message, String errorMsg) {
        System.out.println(message);

        while (!scanner.hasNextInt()) {
            System.out.println(errorMsg);
            scanner.nextLine();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static String nextString(String message, String errorMsg) {

        System.out.println(message);

        while (!scanner.hasNextLine()) {
            System.out.println(errorMsg);
            scanner.nextLine();
        }

        String value = scanner.nextLine();
        return value;
    }
}
