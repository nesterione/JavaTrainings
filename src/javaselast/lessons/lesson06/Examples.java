package javaselast.lessons.lesson06;

public class Examples {

    public static void main(String[] args) {

        String s1 = "фыва";
        byte[] sbytes = s1.getBytes();
        String s2 = new String(sbytes).intern();

        System.out.println(s1==s2);

        //System.out.println(sbytes.length);
        //System.out.println(new String(sbytes));

        /*
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s3==s4);
*/

        /*
        String s = "abc";
        s = s.toUpperCase() + "123";

        System.out.println(s);

        String s2 = "f";
        String s3 = "safsfas asd swerwer";

        System.out.println();
*/
        /*

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            sb.append(i);
        }

        s = sb.toString();

        System.out.println(s);*/
    }

}
