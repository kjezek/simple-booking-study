package cz.zcu.kiv.examples.booking.preferences;

import org.apache.commons.io.LineIterator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class RatingFileIterator extends LineIterator {

    public RatingFileIterator(InputStream stream) throws UnsupportedEncodingException {
        super(new InputStreamReader(stream, "UTF-8"));
    }

    @Override
    public String next() {

        String line = super.next();

        System.out.println("Log: " + line);

        return line;
    }
}
