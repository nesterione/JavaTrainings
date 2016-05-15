package javaselast.lessons.lesson11;

import java.io.DataOutputStream;
import java.util.Date;
import java.util.PrimitiveIterator;

class MyDate extends Date {

    MyDate(long d ) {
        super(d);
    }
}

public class Period {

    public static void main(String[] args) {

        MyDate date = new MyDate(213213);
        Period p = new Period(date,new Date(568454645));
        date.setTime(568454646);
        System.out.println(p);
    }

    final private Date start;
    final private Date end;

    public Period(Date start, Date end) {

        if(start.getTime()>=end.getTime())
            throw new IllegalArgumentException("d1 < d2");

        this.start = new Date(start.getTime());
        this.end = end;
    }

    @Override
    public String toString() {
        return "Period{" +
                "end=" + end.getTime() +
                ", start=" + start.getTime() +
                '}';
    }
}
