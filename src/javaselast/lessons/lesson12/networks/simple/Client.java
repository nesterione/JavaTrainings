package javaselast.lessons.lesson12.networks.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket();
        client.connect(
                new InetSocketAddress("127.0.0.1", 8080)
        );

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        PrintWriter writer =
                new PrintWriter(client.getOutputStream(),true);

        writer.println(s);
        String ans = reader.readLine();

        System.out.println(ans);
        client.close();
    }
}
