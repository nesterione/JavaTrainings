import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        try(PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            pw.println(a+b);
        }
    }

}
