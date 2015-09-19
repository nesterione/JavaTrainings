package lesson.networks.streams.echo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by igor on 17.09.2015.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // ��������� �����������
        Socket server = new Socket();
        InetAddress ip = InetAddress.getLocalHost();
        InetSocketAddress address = new InetSocketAddress(ip,9000 );
        server.connect(address);

        // �������� �� ������������ ������
        System.out.println("Please, enter something:");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        // ���������� �� ������
        OutputStream output = server.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(msg);

        // �������� ����� �� �������
        InputStream input = server.getInputStream();
        InputStreamReader stream = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(stream);

        // ������� �� ������� �����
        String serverMsg = reader.readLine();
        System.out.println(serverMsg);
    }
}
