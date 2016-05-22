package javaselast.lessons.lesson12;

public class Problems {

    static volatile long value = 0;

//    public synchronized static void inc() {
//        value++;
//    }

    final static Object lock = new Object();

    public static void inc() {
        synchronized (lock) {
            value++;
        }
    }

    public static void thread() {
        for(int i = 0; i< 1000;i++) {
            inc();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(Problems::thread);
        Thread t2 = new Thread(Problems::thread);
        Thread t3 = new Thread(Problems::thread);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(value);
    }

}
