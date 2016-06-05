package javaselast.lessons.lesson13.val;

public class Run {

    public static volatile long lock = 0;

    public static void main(String[] args) throws InterruptedException {
        T1 t = new T1();
        t.start();

        Thread.sleep(1000);
        lock = 1;
        System.out.println("lock set to 1");

        t.join();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        while (Run.lock!=1);

        System.out.println("T1 Unlocked");
    }
}
