package javaselast.lessons.lesson12;

public class Run {

    public static void doSome() {
        try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread six");
    }

    public static void main(String[] args) throws InterruptedException {

//        Way 1
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("thread two");
//            }
//        });

//        way 2
//        Thread thread = new Thread(new MyThread());

//        Thread thread = new MyThreadClass();

// way 3
//        Thread thread = new Thread( () -> {
//            try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("thread five");
//        } );

        Thread thread = new Thread(Run::doSome);
        thread.start();

        System.out.println("thread one");


        thread.join();
    }

}

class MyThreadClass extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread four");
    }
}

class MyThread implements Runnable {



    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread three");
    }
}