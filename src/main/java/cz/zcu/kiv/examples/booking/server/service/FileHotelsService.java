package cz.zcu.kiv.examples.booking.server.service;

import cz.zcu.kiv.examples.booking.server.dao.DbAccessService;
import cz.zcu.kiv.examples.booking.server.entity.Hotels;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class FileHotelsService implements HotelsService {

    @Inject
    private DbAccessService dbAccessService;

    @Override
    public List<Hotels> loadAll() {

        List<Hotels> list = new LinkedList<>();

        for (String[] data : dbAccessService.readData("/hotels.csv")) {
            Hotels hotels = new Hotels(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3]);

            list.add(hotels);
        }

        return list;
    }
}
