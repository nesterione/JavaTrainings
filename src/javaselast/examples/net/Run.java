package javaselast.examples.net;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Run {

    public static void main(String[] args) throws IOException {


        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress("127.0.0.1",8888);
        socket.connect(address);

        //ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        //out.writeObject(new Message());

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        in.readLine();


    }

}

enum Type {
    A,B
}

class Message implements Serializable {

    private Type type;
    private Object message;

}