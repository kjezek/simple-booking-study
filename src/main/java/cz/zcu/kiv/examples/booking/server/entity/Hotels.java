package cz.zcu.kiv.examples.booking.server.entity;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class Hotels {

    private Integer id;
    private String name;
    private Integer ratingId;
    private String url;


    public Hotels(Integer id, String name, Integer ratingId, String url) {
        this.id = id;
        this.name = name;
        this.ratingId = ratingId;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public String getUrl() {
        return url;
    }
}
