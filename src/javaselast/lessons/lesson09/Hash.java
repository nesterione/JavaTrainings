package javaselast.lessons.lesson09;

public class Hash {

    private int a;
    private String str;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hash hash = (Hash) o;

        if (a != hash.a) return false;
        return str != null ? str.equals(hash.str) : hash.str == null;

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + (str != null ? str.hashCode() : 0);
        return result;
    }
}













