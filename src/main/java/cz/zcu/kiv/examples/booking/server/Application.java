package cz.zcu.kiv.examples.booking.server;

import com.google.inject.AbstractModule;
import cz.zcu.kiv.examples.booking.server.dao.DbAccessService;
import cz.zcu.kiv.examples.booking.server.dao.FileDbAccessService;
import cz.zcu.kiv.examples.booking.server.service.HotelsService;
import cz.zcu.kiv.examples.booking.server.service.FileHotelsService;
import cz.zcu.kiv.examples.booking.server.service.FileRoomService;
import cz.zcu.kiv.examples.booking.server.service.RoomService;

/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class Application extends AbstractModule {

    @Override
    protected void configure() {
        bind(HotelsService.class).to(FileHotelsService.class);
        bind(DbAccessService.class).to(FileDbAccessService.class);
        bind(RoomService.class).to(FileRoomService.class);
    }
}
