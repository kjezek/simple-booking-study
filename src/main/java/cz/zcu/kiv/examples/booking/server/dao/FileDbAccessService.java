package cz.zcu.kiv.examples.booking.server.dao;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class FileDbAccessService implements DbAccessService {


    @Override
    public List<String[]> readData(String table) {

        List<String[]> list = new LinkedList<>();

        InputStream stream  = getClass().getResourceAsStream(table);

        LineIterator it;
        try {
            it = IOUtils.lineIterator(stream, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (it.hasNext()) {
            String[] data = String.valueOf(it.next()).split(",");
            list.add(data);
        }

        return list;
    }
}
