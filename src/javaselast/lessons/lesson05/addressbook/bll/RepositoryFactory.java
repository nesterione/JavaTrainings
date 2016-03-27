package javaselast.lessons.lesson05.addressbook.bll;

public class RepositoryFactory {

    public static Repository memRepository() {
        return new MemRepository();
    }

    public static Repository txtRepository(String path) {
        return new TxtRepository(path);
    }

}
