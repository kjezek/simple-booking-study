package cz.zcu.kiv.examples.booking.preferences;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kamil Jezek [kamil.jezek@verifalabs.com]
 */
public interface RatingLoader {


    Map<Integer, Float> load() throws IOException;
}
