package cz.zcu.kiv.examples.booking.server.dao;

import java.util.List;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public interface DbAccessService {

    List<String[]> readData(String table);
}
