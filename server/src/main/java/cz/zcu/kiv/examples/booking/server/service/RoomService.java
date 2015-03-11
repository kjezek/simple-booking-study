package cz.zcu.kiv.examples.booking.server.service;

import cz.zcu.kiv.examples.booking.server.entity.Room;

import java.util.List;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public interface RoomService {

    List<Room> getRooms(Integer hotelId);
}
