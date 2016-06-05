package javaselast.lessons.lesson13.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Chat {

    private final String host;
    private final int port;
    private PrintWriter writer;
    private BufferedReader reader;
    private OnReceive onReceive;

    public Chat(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void addOnReceiveListener(OnReceive event) {
        this.onReceive = event;
    }

    public void connect() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host,port));

        writer = new PrintWriter(socket.getOutputStream(),true);
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        Thread thread = new Thread(()-> {

            while (true) {

                try {

                    String msg = reader.readLine();

                    if(onReceive!=null) {
                        onReceive.receive(msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }

    public void send( String message ) {
        writer.println(message);
    }

    public void close() {
        //
    }
}
