package javaselast.lessons.lesson11;

public class overload {

    public static void m(int i) {
        System.out.println("int");
    }

    public static void m(Integer i) {
        System.out.println("Integer");
    }

    public static void m(Double i) {
        System.out.println("double");
    }

    public static void m(Object i) {
        System.out.println("Object");
    }

    public static void m(int ... a) {
        System.out.println("varargs");
    }


    public static void main(String[] args) {
        Integer num = 1;
        m();
    }
}
