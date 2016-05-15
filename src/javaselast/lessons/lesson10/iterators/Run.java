package javaselast.lessons.lesson10.iterators;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Run {

    public static void main(String[] args) {


        MyList<Integer> list = new MyList<>(20);

        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);

        /*
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());

*/


//        for(Integer v : list) {
//            System.out.println(v);
//        }

        int i = 0;
        for(BigInteger v : new Infinite()) {
            System.out.println(v);
            i++;
            if(i>100) {
                break;
            }
        }


        }
}

class Infinite implements Iterable<BigInteger> {

    private class Generator implements Iterator<BigInteger> {

        private BigInteger v= BigInteger.ONE;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public BigInteger next() {
            BigInteger two = new BigInteger("2");
            v = v.multiply(two);
            return v;
        }
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return new Generator();
    }
}



class MyList<T> implements Iterable<T> {

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

    private class ListIterator implements Iterator<T> {

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current<size;
        }

        @Override
        public T next() {
            return data[current++];
        }
    }

    @Override
    public Iterator<T> iterator() {


        return new ListIterator();
    }
}