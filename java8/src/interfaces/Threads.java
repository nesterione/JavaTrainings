package interfaces;

public class Threads {

    public static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(Threads::print);
        thread.start();

        System.out.println("print");

    }

}
