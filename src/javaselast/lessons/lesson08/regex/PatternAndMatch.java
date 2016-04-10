package javaselast.lessons.lesson08.regex;

import lesson.types.strings.Str;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatch {

    public static void main(String[] args) throws URISyntaxException, IOException {


        Pattern pattern = Pattern.compile("[\\w.]+@[\\w]+\\.[\\w]+");

        String text = "nesterione@gmail.com "; //"asdf nesterione@gmail.com 234f sdf as43345";
        Matcher matcher
                = pattern.matcher(text);

        while ( matcher.find() ) {
            System.out.println(matcher.group());
        }

        System.out.println(matcher.matches());

    }

}
