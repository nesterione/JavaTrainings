package javaselast.lessons.lesson06;

import java.io.File;
import java.io.*;

public class FileRead {

    public static void main(String[] args)  {

        File file = new File("e:/s.csv");
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(file)) ) {

//            int c = 0;
//            while ( (c=reader.read())!=-1) {
//                System.out.print((char) c);
//            }

            String s = null;
            while ( (s=bufferedReader.readLine())!=null) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
