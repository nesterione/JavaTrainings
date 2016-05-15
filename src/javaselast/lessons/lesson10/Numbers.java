package javaselast.lessons.lesson10;

import java.math.BigDecimal;


/**
 * Created by igor on 29.04.2016.
 */
public class Numbers {
    public static void main(String[] args) {

        BigDecimal d = new BigDecimal("0.3");
        BigDecimal d1 = new BigDecimal("0.1");
        BigDecimal d2 = new BigDecimal("0.1");
        BigDecimal d3 = new BigDecimal("0.1");

        System.out.println(0.3==(0.1+0.1+0.1));

        System.out.println(d.equals(  d1.add(d2).add(d3)  ));
    }
}
