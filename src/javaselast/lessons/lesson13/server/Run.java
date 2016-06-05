package javaselast.lessons.lesson13.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newCachedThreadPool();
        System.out.println("server run");

        ServerSocket serverSocket = new ServerSocket(8080);
        Set<Client> clients = new HashSet<>();

        while (!serverSocket.isClosed()) {

            Socket clientSocket = serverSocket.accept();
            Client client = new Client(clientSocket,clients);
            synchronized (clients) {
                clients.add(client);
            }

            pool.submit(client);
        }

        pool.shutdown();

    }

}
