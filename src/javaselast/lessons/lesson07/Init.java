package javaselast.lessons.lesson07;

public class Init implements Cloneable{

    public int value;

    public Init(int value) {
        this.value = value;
    }

    public Init(Init obj) {
        this.value = obj.value;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Init a = new Init(123);

        //
        //Init b = new Init(a);
        //b.value = 1111;

        Init b = (Init)a.clone();
        b.value = 1111;

        System.out.println(a.value);
        System.out.println(b.value);



    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
