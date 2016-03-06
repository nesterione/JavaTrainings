package javaselast.lessons.lesson03;


public class Run {

    public static void main(String[] args) {

        /*
        int[] array[] = {
                {1,2},
                {1,2,4}
        };

        int array1[][] = {
                {1,2},
                {1,2,4}
        };*/

        int[][] array2 = {
                {1,2},
                {1,2,4}
        };

        //int[][] arrayCopy = array2;
        //int[][] arrayCopy = array2.clone();
        int[][] arrayCopy = new int[array2.length][];
        for (int i = 0; i < array2.length; i++) {
            arrayCopy[i] = array2[i].clone();
        }

        arrayCopy[0][0] = 7777;

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("==========");

        for (int i = 0; i < arrayCopy.length; i++) {
            for (int j = 0; j < arrayCopy[i].length; j++) {
                System.out.print(arrayCopy[i][j]+" ");
            }
            System.out.println();
        }


    }

}
