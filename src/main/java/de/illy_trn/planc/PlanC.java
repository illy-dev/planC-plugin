package de.illy_trn.planc;

import com.sun.source.tree.BreakTree;
import de.illy_trn.planc.commands.day;
import de.illy_trn.planc.commands.homeSystem.home;
import de.illy_trn.planc.commands.homeSystem.tabcompleters;
import de.illy_trn.planc.commands.kit;
import de.illy_trn.planc.commands.spawn;
import de.illy_trn.planc.commands.tpaSystem.tpaCommand;
import de.illy_trn.planc.commands.tpaSystem.tpaDecline;
import de.illy_trn.planc.commands.tpaSystem.tpacceptCommand;
import de.illy_trn.planc.items.CrystalDiamond.axeEvent;
import de.illy_trn.planc.items.EmeraldArmor.EmeraldArmorEvent;
import de.illy_trn.planc.items.EnderStaff.EnderStaffEvent;
import de.illy_trn.planc.items.MultishotBow.MultishotBowEvent;
import de.illy_trn.planc.items.Shortbow.ShortbowEvent;
import de.illy_trn.planc.items.StormArmor.StormArmorEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import de.illy_trn.planc.commands.homeSystem.homeManeger;

import java.io.File;
import java.util.HashMap;

public final class PlanC extends JavaPlugin {

    private static PlanC plugin;
    private static homeManeger homeManeger;

    public static HashMap<Player, Player> tpa = new HashMap<>();

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

        // commands
        getCommand("spawn").setExecutor(new spawn());
        getCommand("day").setExecutor(new day());
        getCommand("kit").setExecutor(new kit());
        getCommand("tpa").setExecutor(new tpaCommand());
        getCommand("tpaccept").setExecutor(new tpacceptCommand());
        getCommand("tpadeclinet").setExecutor(new tpaDecline());
        getCommand("home").setExecutor(new home());
        getCommand("home").setTabCompleter(new tabcompleters());

        // events
        getServer().getPluginManager().registerEvents(new MultishotBowEvent(), this);
        getServer().getPluginManager().registerEvents(new EmeraldArmorEvent(), this);
        getServer().getPluginManager().registerEvents(new StormArmorEvent(), this);
        getServer().getPluginManager().registerEvents(new EnderStaffEvent(), this);
        getServer().getPluginManager().registerEvents(new axeEvent(), this);
        getServer().getPluginManager().registerEvents(new spawn(), this);
        getServer().getPluginManager().registerEvents(new home(), this);
        getServer().getPluginManager().registerEvents(new ShortbowEvent(), this);

        // custom crafting
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
