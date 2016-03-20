package javaselast.lessons.lesson04.expections;



public class Temperature {

    private int value;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value<0)
            throw new IllegalArgumentException("< 0");

        this.value = value;
    }


}
