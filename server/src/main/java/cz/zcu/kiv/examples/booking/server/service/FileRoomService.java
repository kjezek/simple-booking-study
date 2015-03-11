package cz.zcu.kiv.examples.booking.server.service;

import cz.zcu.kiv.examples.booking.server.dao.DbAccessService;
import cz.zcu.kiv.examples.booking.server.entity.Room;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class FileRoomService implements RoomService {

    @Inject
    private DbAccessService dbAccessService;

    @Override
    public List<Room> getRooms(Integer hotelId) {

        List<Room> rooms = new LinkedList<>();
        for (String[] data : dbAccessService.readData("/rooms.csv")) {
            Room room = new Room(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[2]),
                    Float.parseFloat(data[3]),
                    data[1]
            );

            if (room.getHotelId().equals(hotelId)) {
                rooms.add(room);
            }
        }

        return rooms;
    }
}
