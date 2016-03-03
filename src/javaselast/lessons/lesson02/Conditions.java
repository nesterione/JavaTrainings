package javaselast.lessons.lesson02;

public class Conditions {

    public static void main(String[] args) {
//
//        if(true) {
//
//        } else if(true){
//
//        } else {
//
//        }

//String a = "a";
//        switch (a) {
//            case "a":
//                System.out.println("1");
//                break;
//            case "2":
//                System.out.println("2");
//                break;
//            default:
//                System.out.println("def");
//                break;
//        }

//
//        String name = "234";
//        System.out.println( (name==null)?"":name  );
//
//
//        int i = 0;
//        int j = 1;
//        if(i==0  | j!=1) {
//            System.out.println("True");
//        }

        int a=0;

        System.out.println(a);
        a = a+1;

        a= a+1;

        a+=4;
        a = a + 4;

        System.out.println(a);

        if(a() || b() && c() || d()  ) {
            System.out.println("True");
        }
    }

    static boolean a() {
        System.out.println("a");
        return false;
    }

    static boolean b() {
        System.out.println("b");
        return true;
    }

    static boolean c() {
        System.out.println("c");
        return false;
    }

    static boolean d() {
        System.out.println("d");
        return false;
    }
}

