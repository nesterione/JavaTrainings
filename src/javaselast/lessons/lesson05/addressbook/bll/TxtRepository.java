package javaselast.lessons.lesson05.addressbook.bll;

import javaselast.lessons.lesson05.addressbook.model.Record;

import java.util.List;

class TxtRepository extends AbstractRepository {


    private String path;

    public TxtRepository(String path) {
        this.path = path;
    }

    @Override
    protected List<Record> read() {
        return null;
    }

    @Override
    protected void save(List<Record> records) {

    }
}
