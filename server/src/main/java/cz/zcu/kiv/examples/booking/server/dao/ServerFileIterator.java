package cz.zcu.kiv.examples.booking.server.dao;

import org.apache.commons.io.LineIterator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class ServerFileIterator extends LineIterator {

    public ServerFileIterator(InputStream stream) throws UnsupportedEncodingException {
        super(new InputStreamReader(stream, "UTF-8"));
    }

    @Override
    public Object next() {

        Object line = super.next();

        System.out.println("Log: " + line);

        return line;
    }
}
