package javaselast.lessons.lesson13.client;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleClient {

    public static void main(String[] args) throws IOException {


        Chat chat = new Chat("127.0.0.1",8080);
        chat.connect();
        chat.addOnReceiveListener(System.out::println);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String msg = scanner.nextLine();
            chat.send(msg);
        }

    }
}
