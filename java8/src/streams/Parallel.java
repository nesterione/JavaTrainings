package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parallel {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Random r = new Random(43);
        for (int i = 0; i < 20000000; i++) {
            list.add(r.nextInt(50));
        }


//        long start = System.nanoTime();
//
//        List<Integer> result = list.stream()
//                .filter(x->x%2!=0)
//                .sorted()
//                .collect(Collectors.toList());
//
//        long end = System.nanoTime();
//
//        System.out.println(end-start);

        long start = System.nanoTime();

        int result = list.stream()
                .filter(x -> x % 2 != 0)
                .reduce(0, (x, y) -> x + y);

        long end = System.nanoTime();

        System.out.println(end-start);
        System.out.println(result);
    }

}
