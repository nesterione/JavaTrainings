package javaselast.lessons.lesson05.addressbook.bll;

import javaselast.lessons.lesson05.addressbook.model.Record;

import java.util.List;

public interface Repository {
    List<Record> getAll();
    Record getById(int id);
    void sort(String criteria);
}