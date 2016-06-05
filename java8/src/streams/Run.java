package streams;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {


        int[] nums = {1,4,5,3,3,4,2,5,5,456,345,56,3,3,2};

        Arrays
                .stream(nums)
                .filter(x->x%2!=0)
                .sorted()
                .forEach(System.out::println);


    }

}
