package javaselast.lessons.lesson14;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import lesson.networks.streams.game.Operation;

public class Enums {

    public static void method(Units unit) {

        System.out.println(unit.name());
    }

    public static void main(String[] args) {
        //method(UnitsOld.HOURS);
        //method(null);
//        Units unit = Units.HOURS;
//        System.out.println(unit.name());
//        System.out.println(unit.ordinal());

//        for(Units un : Units.values()) {
//            System.out.println(un);
//        }

//        Units un = Units.valueOf("SECONDS");
//        System.out.println(un);
//
//
//        switch (un) {
//
//            case SECONDS:
//                System.out.println("1");
//                break;
//            case MINUTES:
//                System.out.println("2");
//                break;
//            case HOURS:
//                System.out.println("3");
//                break;
//        }
//


//        System.out.println(Units.HOURS == Units.HOURS);

        //Units v = Units.HOURS;
        //System.out.println(v.value);

        Units unit = Units.parseInt(2);


        // - 2 3
        // + 4 5



        Operations op = Operations.PLUS;
        op.apply(234,345);

        System.out.println(unit);

    }
}

enum Operations {
    // anonymous class
    PLUS(new BinaryOperator<Double>() {
        @Override
        public Double apply(Double aDouble, Double aDouble2) {
            return aDouble+aDouble2;
        }
    }),

    // using lambda expression
    MINUS ( (x,y) -> x-y);

    private BinaryOperator<Double> f;

    Operations(BinaryOperator<Double> operator) {
        f = operator;
    }

    public double apply(double a, double b) {
        return f.apply(a,b);
    }
}

//interface Operator<T> {
//    T apply(T one, T two);
//}

enum Units {
    SECONDS(1),
    MINUTES(2),
    HOURS(3);

    final int value;

    Units(int value) {
        this.value = value;
    }


    public static Units parseInt(int value) {
        for(Units u : Units.values()) {
            if(u.value == 2) {
                return u;
            }
        }

        throw new IllegalArgumentException();
    }

}

//enum Units {
//    SECONDS,
//    MINUTES,
//    HOURS
//}

interface UnitsOld {
    int SECONDS = 1;
    int MINUTES = 2;
    int HOURS = 3;
}