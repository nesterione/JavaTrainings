package javaselast.lessons.lesson03.payer;

public class LegalPayer implements Payer{

    private final static String
            TMPL = "==============\n" +
            "LegalPayer:\n" +
            "%s %s\n"+
            "pay:\n" +
            "%d\n"+
            "==============\n";

    private int id;
    private String name;
    private String type;

    public LegalPayer(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LegalPayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String pay(int cost) {
        int val = (int)(cost*1.1);
        return String.format(TMPL,type, name,val);
    }
}
