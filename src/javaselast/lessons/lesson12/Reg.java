package javaselast.lessons.lesson12;

public class Reg {

    final private static Object LOCK = new Object();

    public void reg() {

        synchronized (LOCK) {
            System.out.println("in");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("finish");
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Reg r1 = new Reg();
        Reg r2 = new Reg();

        Thread t1 = new Thread(r1::reg);
        Thread t2 = new Thread(r2::reg);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
