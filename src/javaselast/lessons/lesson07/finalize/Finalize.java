package javaselast.lessons.lesson07.finalize;

import lesson.gc.Finalization;

public class Finalize {

    public static void main(String[] args) throws InterruptedException {
        Finalize f = new Finalize();
        f = null;
        System.gc();
        //Thread.sleep(1000);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}
