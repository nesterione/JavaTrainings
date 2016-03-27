package javaselast.lessons.lesson05.addressbook.bll;

import javaselast.lessons.lesson05.addressbook.model.Record;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TxtRepository extends AbstractRepository {

    private String path;

    TxtRepository(String path) {
        this.path = path;
    }

    @Override
    protected List<Record> read() {

        List<Record> records = new ArrayList<>();

        try(BufferedReader reader
                    = new BufferedReader(new FileReader(path))) {
            // skip header
            reader.readLine();

            String s;
            while ((s=reader.readLine())!=null) {

                String[] col = s.split(";");

                int id = Integer.parseInt(col[0].trim());
                String name = col[1].trim();
                String phone = col[2].trim();

                Record record = new Record(id,name,phone);
                records.add(record);
            }

        } catch (IOException e) {
            throw new RuntimeException("file reading error", e);
        }

        return records;
    }

    @Override
    protected void save(List<Record> records) {

    }
}
