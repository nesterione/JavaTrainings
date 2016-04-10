package javaselast.lessons.lesson07.serialization;

import lesson.enums.Ex;

import java.io.*;

public class Example implements Serializable{

    private final static long serialVersionUID = 121;

    //transient String sss = "asdfghjk";

    int a;
    String str;
    int b = 234234;

    Example(int a, String str) {
        this.a = a;
        this.str = str;
    }

    @Override
    public String toString() {
        return "Example{" +
                "a=" + a +
                ", str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Example example = new Example(123,"qwerr");
//
//        ObjectOutputStream stream
//                = new ObjectOutputStream(
//                        new BufferedOutputStream(
//                        new FileOutputStream("e:/obj.obj")));
//
//        stream.writeObject(example);
//
//        stream.close();



        ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream("e:/obj.obj"));

        Example example = (Example)stream.readObject();
        System.out.println(example);
        stream.close();


    }


}
