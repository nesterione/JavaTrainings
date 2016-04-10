package javaselast.lessons.lesson07.constructors;

public class Example {

    private int id;
    private String name;

    public Example(int id, String name) {
        System.out.println("first");
        this.id = id;
        this.name = name;
    }

    public Example(String name) {
        this(0,name);
        System.out.println("second");
    }


    public static void main(String[] args) {
        Example e = new Example("name");
        System.out.println("=========");
        new Example(1,"sdf");
    }
}
