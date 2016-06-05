package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Run {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("AAAA");
        list.add("ZZZZ");
        list.add("BBBB");

        // java 8
        list.sort( (o1, o2) -> -o1.compareTo(o2));

        // java <8
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println(list);


        //list.forEach( x -> System.out.println(x) );
        list.forEach( System.out::println );
    }
}
