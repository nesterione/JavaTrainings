package interfaces;


public class Demo {

    public static void main(String[] args) {



    }

}

interface A1 {

    void methodOne();

    default void methodTwo() {
        System.out.println("two: A1");
    }
}

interface A2 {

    void methodThree();

    default void methodTwo() {
        System.out.println("two: A2");
    }
}

class D implements A1,A2 {

    @Override
    public void methodOne() {

    }

    @Override
    public void methodThree() {

    }

    @Override
    public void methodTwo() {
        System.out.println("two: implements");
    }
}

class B implements A1 {

    @Override
    public void methodOne() {
        System.out.println("A");
    }
}

class C implements A1 {

    @Override
    public void methodOne() {

    }

    @Override
    public void methodTwo() {

    }
}