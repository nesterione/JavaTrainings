package javaselast.lessons.lesson05.addressbook.bll;

import javaselast.lessons.lesson05.addressbook.model.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 25.03.2016.
 */
class MemRepository extends AbstractRepository {

    private List<Record> records = new ArrayList<>();

    public MemRepository() {
        records.add(new Record(1,"f","rwer"));
        records.add(new Record(2,"fwer","rwer"));
        records.add(new Record(3,"f34","r45r"));
    }

    @Override
    protected List<Record> read() {
        return records;
    }

    @Override
    protected void save(List<Record> records) {
        this.records = records;
    }
}
