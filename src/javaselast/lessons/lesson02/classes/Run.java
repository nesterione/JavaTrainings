package javaselast.lessons.lesson02.classes;

public class Run {
    public static void main(String[] args) {
        Man man1 = new Man(1, "user",15);
        Man man2 = new Man(2, "user2",55);

        man2.setAge(-234234);
        man1.getAge();

        System.out.println(man1);
        System.out.println(man2);
    }
}






//
//    Man man3 = new Man(1, "user",15);
//System.out.println( man1 == man3  );
//        System.out.println( man1.equals(man3)  );
