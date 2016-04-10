package javaselast.lessons.lesson08.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Run {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();

        System.out.println(date);

        System.out.println(date.getTime());

        System.out.println(new Date(1460286726444L));

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

        System.out.println(sdf.format(new Date()));

        System.out.println(sdf.parse("10 апр 2015 14:18:49"));
    }

}
