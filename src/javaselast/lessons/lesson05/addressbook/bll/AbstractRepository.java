package javaselast.lessons.lesson05.addressbook.bll;

import javaselast.lessons.lesson05.addressbook.model.Record;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class AbstractRepository implements Repository {

    protected abstract List<Record> read();
    protected abstract void save(List<Record> records);

    @Override
    public List<Record> getAll() {
        return read();
    }

    @Override
    public Record getById(int id) {

        List<Record> records = read();
        for (Record record: records) {
            if(record.getId()==id) {
                return record;
            }
        }

        return null;
    }

    private static class SortByName implements Comparator<Record> {
        @Override
        public int compare(Record o1, Record o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    @Override
    public void sort(String criteria) {
        List<Record> records = read();
        if("byName".equals(criteria)) {
            Collections.sort(records, new SortByName() );
        }
        save(records);
    }
}
