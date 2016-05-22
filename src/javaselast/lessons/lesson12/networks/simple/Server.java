package javaselast.lessons.lesson12.networks.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);

        System.out.println("wait connection ...");
        while (true) {
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer =
                    new PrintWriter(socket.getOutputStream(),true);
            String s = reader.readLine();
            System.out.println("recv:" +s);
            writer.println("server: "+s);
            socket.close();
        }

    }

}
