package javaselast.lessons.lesson09;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Run {

    public static void main(String[] args) {

        Map<MyClass, String> map = new HashMap<>();

        map.put(new MyClass(1), "aaaaa");
        map.put(new MyClass(5), "bbbbb");
        map.put(new MyClass(5), "ccccc");
        map.put(new MyClass(7), "zzzzz");

        System.out.println(map.get(new MyClass(5)));

        System.out.println(map.values());
        System.out.println(map.keySet());


    }
}

class MyClass {
    private int a;

    public MyClass(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        return a == myClass.a;

    }

    @Override
    public int hashCode() {
        return a;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                '}';
    }
}
