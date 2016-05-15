package javaselast.lessons.lesson10.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Run {

    public static Tuple<Integer,Integer> get() {
        return new Tuple<>(234,5);
    }

    public static void main(String[] args) {





        MyList<Integer> list = new MyList<>(10);
        list.add(234);
        list.add(234);
        list.add(234);

        MyList m = list;
        //list.add("sdf");
        System.out.println(list.get(2));

        MyList<String> stringMyList = new MyList<>(10);
        stringMyList.add("sdf");
        stringMyList.add("ertert");
        stringMyList.add("hfh");

        System.out.println(stringMyList.get(2));
    }
}

class Tuple<T1,T2> {
    private final T1 t1;
    private final T2 t2;

    public Tuple(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getT1() {
        return t1;
    }

    public T2 getT2() {
        return t2;
    }
}

class MyList<T extends Comparable<T> > {

    private T[] data;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyList(int capacity) {


        data = (T[]) new Object[capacity];
    }

    public void add(T v) {
        data[size++]=v;
    }

    public T get(int i) {
        return data[i];
    }

}