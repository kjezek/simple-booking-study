package cz.zcu.kiv.examples.booking.server.entity;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class Room {

    private Integer id;
    private Integer hotelId;
    private Float price;
    private String room;

    public Room(Integer id, Integer hotelId, Float price, String room) {
        this.id = id;
        this.hotelId = hotelId;
        this.price = price;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public Float getPrice() {
        return price;
    }

    public String getRoom() {
        return room;
    }
}
