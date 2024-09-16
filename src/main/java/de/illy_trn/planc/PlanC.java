package de.illy_trn.planc;

import de.illy_trn.planc.commands.kit;
import de.illy_trn.planc.commands.spawn;
import de.illy_trn.planc.items.CrystalDiamond.axe.axeEvent;
import de.illy_trn.planc.items.EmeraldArmor.EmeraldArmorEvent;
import de.illy_trn.planc.items.EnderStaff.EnderStaffEvent;
import de.illy_trn.planc.items.MultishotBow.MultishotBowEvent;
import de.illy_trn.planc.items.StormArmor.StormArmorEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlanC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup
        getLogger().info("Plan C plugin Loaded");
        getCommand("spawn").setExecutor(new spawn());
        getCommand("kit").setExecutor(new kit());
        getServer().getPluginManager().registerEvents(new MultishotBowEvent(), this);
        getServer().getPluginManager().registerEvents(new EmeraldArmorEvent(), this);
        getServer().getPluginManager().registerEvents(new StormArmorEvent(), this);
        getServer().getPluginManager().registerEvents(new EnderStaffEvent(), this);
        getServer().getPluginManager().registerEvents(new axeEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
