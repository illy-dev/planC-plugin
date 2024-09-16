package de.illy_trn.planc.commands.homeSystem;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.io.File;

public class HomePoint {

    private File()

    private final Location location;
    public HomePoint(Location location){
        this.location = location;
    }

    public void teleport(Entity entity) {
        if (!entity.getVehicle().isEmpty()) {
            entity.getVehicle().teleport(this.location);
        } else {
            entity.teleport(this.location);
        }

    }

    public Location getLocation() {
        return this.location;
    }

}
