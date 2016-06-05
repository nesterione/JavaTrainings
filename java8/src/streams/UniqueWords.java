package streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UniqueWords {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(
                new FileReader("e:/rm/text.txt")
        );

        StringBuilder stringBuilder = new StringBuilder();

        reader
                .lines()
                .forEach(x-> stringBuilder
                        .append(x)
                        .append("\n")
                );

        String text = stringBuilder.toString();

        // split
        // filter < 4
        // to lower
        // unique
        // sort
        // to list

//        String[] words = text.split("[\\s.,!?:;\"\\(\\)]+");
//
//        List<String> selectedWords = new ArrayList<>();
//
//        for(String word: words) {
//            if(word.length()<4) {
//                continue;
//            }
//
//            selectedWords.add(word.toLowerCase());
//        }
//
//        System.out.println(selectedWords.size());
//        Set<String> unique = new TreeSet<>();
//        unique.addAll(selectedWords);
//
//        List result = new ArrayList<>();
//        result.addAll(unique);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(result.get(i));
//        }


        // split
        // filter < 4
        // to lower
        // unique
        // sort
        // to list
        Arrays.stream(text.split("[\\s.,!?:;\"\\(\\)]+"))
                .filter(x->x.length()>3)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

}
