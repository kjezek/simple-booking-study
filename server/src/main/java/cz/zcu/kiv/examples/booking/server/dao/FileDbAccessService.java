package cz.zcu.kiv.examples.booking.server.dao;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.FileInputStream;
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
        InputStream stream = null;

        try {
//        stream  = getClass().getResourceAsStream(table);
            stream = new FileInputStream("/home/kamilos/projects/simple-booking-study/server/src/main/resources/" + table);
            LineIterator it = new ServerFileIterator(stream);
//            it = IOUtils.lineIterator(stream, "UTF-8");

            while (it.hasNext()) {
                String[] data = String.valueOf(it.next()).split(",");
                list.add(data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }


        return list;
    }
}
