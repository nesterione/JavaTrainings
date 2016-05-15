package javaselast.lessons.lesson11.vars;

public class User implements Cloneable {

    private int id;
    private String name;

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
    protected User clone()  {

        User newuser = null;
        try {
            newuser = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            new RuntimeException("clone except", e);
        }

        return newuser;
    }
}
