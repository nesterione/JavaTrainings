package javaselast.examples.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestWriter {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        CsvWriter<Student> writer = new CsvWriter<>(new FileWriter("e:/phones.csv"), Student.class);
        writer.writeObject(new Student(1,"Igor",new Phone(23,2343533)));
        writer.writeObject(new Student(3,"Dmitry",new Phone(33,123333223)));
        writer.close();
    }
}

class S {
    int a = 213;
    String b = "sdf";
}

class Phone {
    private int code;
    private int number;
    private S inner = new S();

    public Phone() {
    }

    public Phone(int code, int number) {
        this.code = code;
        this.number = number;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class Student {
    private int id;
    private String name;
    private Phone phone;

    public Student() {
    }

    public Student(int id, String name, Phone phone) {
        this.id = id;
        this.name = name;

        this.phone = phone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}