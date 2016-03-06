package javaselast.lessons.lesson03.payer;

public class PrivatePayer implements Payer {

    private final static String
            TMPL = "==============\n" +
                    "PrivatePayer:\n" +
                    "%s\n"+
                    "pay:\n" +
                    "%d\n"+
                    "==============\n";

    private int id;
    private String firstName;
    private String lastName;

    public PrivatePayer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String pay(int cost) {
        int val = (int)(cost*1.03);
        return String.format(TMPL,(firstName+" "+lastName),val);
    }

    @Override
    public String toString() {
        return "PrivatePayer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
