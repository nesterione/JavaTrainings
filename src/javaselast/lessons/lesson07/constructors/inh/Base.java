package javaselast.lessons.lesson07.constructors.inh;

public class Base {

    public static void main(String[] args) {
        Impl b = new Impl(123);

        //System.out.println("=========");
        //b.print();

        //b.print();

        System.out.println(b.value);
    }


    public int value = 123;

    private int a;

    public Base(int a) {
        this.a = a;
    }

    Base(int a, int b) {
        //System.out.println("1");
        this.a = a;
    }
    public void print() {
        System.out.println("base");
    }

    //private int q=23;

}

class Impl extends Base {

    public int value = 789;

    public Impl(int a) {
        super(a,234);
        //super.print();
        //System.out.println("2");
    }

    @Override
    public void print() {
        //super.print();
        System.out.println("impl");
    }
}