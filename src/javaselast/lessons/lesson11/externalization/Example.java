package javaselast.lessons.lesson11.externalization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Example {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        ObjectOutputStream a = new ObjectOutputStream(
//                new FileOutputStream("e:/obj.obj")
//        );
//
//        a.writeObject(new User(234,"sfsdf"));
//
//        a.close();

        ObjectInputStream a = new ObjectInputStream(
                new FileInputStream("e:/obj.obj")
        );

        User user = (User)a.readObject();
        System.out.println(user);
        a.close();
    }
}

class User implements Externalizable {

    final private long serialVersionUID = -5996657770864696700L;

    private  int id;
    private String name;

    public User() {

    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject("sdfsdfsdf");
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        in.readObject();
        name = (String)in.readObject();
    }
}