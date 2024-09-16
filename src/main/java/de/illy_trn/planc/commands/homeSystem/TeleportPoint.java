package de.illy_trn.planc.commands.homeSystem;

import org.bukkit.Location;

public class TeleportPoint{


    private final Location location;

    public TeleportPoint(Location location) {
        this.location = location;
    }


    public Location getLocation() {
        return this.location;
    }
}
