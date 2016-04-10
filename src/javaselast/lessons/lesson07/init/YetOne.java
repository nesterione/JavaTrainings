package javaselast.lessons.lesson07.init;

public class YetOne {
    private int one(int ind) {
        System.out.println("invoke "+ind);
        return ind;
    }
    int a = one(1);

    {
        a = one(2);
    }
    YetOne() {
        a = one(3);
    }
    public static void main(String[] args) {
        YetOne obj = new YetOne();
        System.out.println("created");
    }
}
