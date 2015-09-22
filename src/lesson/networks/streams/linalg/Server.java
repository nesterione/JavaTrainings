package lesson.networks.streams.linalg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;

public class Server {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        double[] b = {1, 5, 3, 4};

        double[][] A = {
                {1, 2, 7, 1},
                {5, 3, 3, 2},
                {2, 1, 2, 3},
                {7, 2, 9, 4}
        };

        Matrix m = new Matrix(A);

        int N = 3;

        ServerSocket serverSocket = new ServerSocket(9000);
        ObjectOutputStream[] outputs = new ObjectOutputStream[N];
        ObjectInputStream[] inputs = new ObjectInputStream[N];


        for (int i = 0; i < N; i++) {
            Socket socket = serverSocket.accept();
            outputs[i] = new ObjectOutputStream(socket.getOutputStream());
            inputs[i] = new ObjectInputStream(socket.getInputStream());
            System.out.println("User connected: " + i);
        }


        int activeNode = 0;

        for (int i = 0; i < A[0].length; i++) {
            outputs[activeNode].writeObject(new Pack(Message.Send, new Column(i, m.getColumn(i))));
            activeNode++;
            activeNode %= N;
        }

        outputs[activeNode].writeObject(new Pack(Message.Send, new Column(A[0].length, b)));

        System.out.println("start solution");

        // �������� �� ���� ��������
        for (int active = 0; active < A[0].length; active++) {

            // ����� �������������� ������� � pull ������� ���������� ������
            // ������ ����� ������������ ������� � i ������

            Pack moveOperation = null;
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(new Pack(Message.FindMaxRow, new Integer(active)));
                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() == Message.Move) {
                    // ����� �������� ���, ��������, �� � ������ ���� ����� ����� ����
                    moveOperation = p;
                }
            }

            System.out.println(moveOperation.getData());
            // ���� ���� ������� ����������� ������
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(moveOperation);

                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() != Message.Ok) {
                    throw new RuntimeException("Error, one or more clients, cannot retake rows");
                }
            }


            // �������� ��������� i-� �������
            // ������ ������� �������� ������� �������������
            Pack diffRows = null;
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(new Pack(Message.SolveColumn, new Integer(active)));
                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() == Message.DiffRows) {
                    // ����� �������� ���, ��������, �� � ������ ���� ����� ����� ����
                    diffRows = p;
                }
            }

            // ��������� ���� �������� ������� �������������
            for (int node = 0; node < outputs.length; node++) {
                outputs[node].writeObject(diffRows);

                Pack p = (Pack) inputs[node].readObject();
                if (p.getMessage() != Message.Ok) {
                    throw new RuntimeException("Error, one or more clients, cannot diff rows");
                }
            }

            // ��������� ���� ��� �������� ���� �������
        }


        // �������� ���
        // ������� �� ���� �������� ����������� �������, ��������� ���������� ���������������
        // TODO ������� ��� �����������

        for (int node = 0; node < outputs.length; node++) {
            outputs[node].writeObject(new Pack(Message.GetColumns));

            Pack p = (Pack) inputs[node].readObject();

            if (p.getMessage() == Message.Result) {

                // TODO ����� ��������� ���������� ��������
                Map<Integer, Column> result = (Map<Integer, Column>) p.getData();

                // ��������� ������� � �����������
                for(Integer key: result.keySet()) {

                    Column c = result.get(key);
                    if(c.getIndex()==A[0].length) {
                        b = c.getElements();

                    } else {
                        for(int row =0; row< A.length;row++) {
                            A[row][c.getIndex()] = c.getElements()[row];
                        }
                    }
                }

            }
        }

        System.out.println("===================");
        //����� ������� �� �����
        for (int i = 0; i <A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        System.out.println("===================");
        System.out.println(Arrays.toString(b));
        System.out.println("===================");

        // TODO �������� �������� �� ��, ����� �� ������� �������
        double[] X = new double[b.length]; //������������� ������� �������

        for (int i = b.length - 1; i >= 0; i--)
        {
            double h = b[i];// h ����������� ����� �� ������� ���
            for (int j = 0; j < b.length; j++)
                h = h - X[j] * A[i][ j]; //��������� ��������� ������ �������
            X[i] = h / A[i][ i];//h  ����� �� ����������� ��� ����
        }

        // ������� �� ����� ��������� ����������
        System.out.println(Arrays.toString(X));

        // ���� ������ �� ���������� ������ ���� ��������
        for (ObjectOutputStream o : outputs) {
            o.writeObject(new Pack(Message.End, null));
        }

        System.out.println("Correct end");

    }
}
