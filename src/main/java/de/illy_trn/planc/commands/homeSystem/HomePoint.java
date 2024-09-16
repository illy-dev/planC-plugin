package de.illy_trn.planc.commands.homeSystem;

import de.illy_trn.planc.PlanC;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.File;

public class HomePoint {

    private File file;


    private final Location location;

    public HomePoint(Location location, Player player){
        this.location = location;
        this.file = new File(PlanC.getPluginFolder().getAbsolutePath() + "/HomePoint", player.getUniqueId().toString());
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
