package cz.zcu.kiv.examples.booking.server.service;

import cz.zcu.kiv.examples.booking.server.entity.Hotels;

import java.util.List;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public interface HotelsService {


    List<Hotels> loadAll();
}
