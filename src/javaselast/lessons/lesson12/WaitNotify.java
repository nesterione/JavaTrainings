package javaselast.lessons.lesson12;

public class WaitNotify {

    public static void main(String[] args) {

    }
}

class Th extends Thread {

    @Override
    public void run() {

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}