package javaselast.lessons.lesson13.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Client extends Thread {

    private Set<Client> clients;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private static int idBase = 1;
    private int id;


    public Client(Socket socket, Set<Client> clients) throws IOException {
        this.clients = clients;
        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        id = idBase++;
    }

    public void sendTo(String message) {
        writer.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public void run() {


        while (true) {

            try {

                String msg = reader.readLine();

                clients.forEach(x-> {
                    if(x!=this) {
                        x.sendTo(msg);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();

                synchronized (clients) {
                    clients.remove(this);
                }

                break;
            }

        }



    }
}