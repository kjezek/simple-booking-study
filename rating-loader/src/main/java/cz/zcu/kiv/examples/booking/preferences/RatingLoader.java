package cz.zcu.kiv.examples.booking.preferences;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * This class loads preferences
 *
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class RatingLoader {


    public Map<Integer, Float> load() throws IOException {

        Map<Integer, Float> map = new HashMap<>();

        String fileName = "/rating.csv";
        InputStream stream  = getClass().getResourceAsStream(fileName);

        LineIterator it = IOUtils.lineIterator(stream, "UTF-8");

        while (it.hasNext()) {
            String[] data = it.next().split(",");

            map.put(Integer.parseInt(data[0]), Float.parseFloat(data[1]));
        }

        return map;
    }
}
