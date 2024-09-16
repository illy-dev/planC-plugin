package de.illy_trn.planc;

import com.sun.source.tree.BreakTree;
import de.illy_trn.planc.commands.homeSystem.home;
import de.illy_trn.planc.commands.homeSystem.tabcompleters;
import de.illy_trn.planc.commands.kit;
import de.illy_trn.planc.commands.spawn;
import de.illy_trn.planc.items.CrystalDiamond.axeEvent;
import de.illy_trn.planc.items.EmeraldArmor.EmeraldArmorEvent;
import de.illy_trn.planc.items.EnderStaff.EnderStaffEvent;
import de.illy_trn.planc.items.MultishotBow.MultishotBowEvent;
import de.illy_trn.planc.items.StormArmor.StormArmorEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import de.illy_trn.planc.commands.homeSystem.homeManeger;

import java.io.File;

public final class PlanC extends JavaPlugin {

    private static PlanC plugin;
    private static homeManeger homeManeger;

    private static FileConfiguration configuration;

    @Override
    public void onEnable() {
        // Plugin startup
        plugin = this;
        homeManeger = new homeManeger();
        getServer().getPluginManager().registerEvents(homeManeger, this);
        saveDefaultConfig();
        configuration = getConfig();

        getLogger().info("Plan C plugin Loaded");
        getCommand("spawn").setExecutor(new spawn());
        getCommand("kit").setExecutor(new kit());
        getCommand("home").setExecutor(new home());
        getCommand("home").setTabCompleter(new tabcompleters());
        getServer().getPluginManager().registerEvents(new MultishotBowEvent(), this);
        getServer().getPluginManager().registerEvents(new EmeraldArmorEvent(), this);
        getServer().getPluginManager().registerEvents(new StormArmorEvent(), this);
        getServer().getPluginManager().registerEvents(new EnderStaffEvent(), this);
        getServer().getPluginManager().registerEvents(new axeEvent(), this);
        getServer().getPluginManager().registerEvents(new spawn(), this);
        getServer().getPluginManager().registerEvents(new home(), this);

        CustomCrafting.register(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        homeManeger.onDisable();
    }

    public static File getPluginFolder() {
        return  plugin.getDataFolder();
    }

    public static FileConfiguration getConfiguration() {
        return configuration;
    }
}
