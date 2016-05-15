package javaselast.lessons.lesson10.classes;

/**
 * Created by igor on 29.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        OuterClass o = new OuterClass();
        OuterClass.Inner inner = new OuterClass.Inner();
        OuterClass.InnerTwo innerTwo = o.new InnerTwo();

        Comparable<String > ob = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };

    }
}

class OuterClass {


    private static int f1;
    private int f2;

    public static class Inner {
        void d() {
            f1 = 234;

            class Met {

            }
        }
    }

    public class InnerTwo {
        void d() {
            f2 = 234;
        }
    }

}