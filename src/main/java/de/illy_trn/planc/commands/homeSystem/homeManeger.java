package de.illy_trn.planc.commands.homeSystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class homeManeger implements Listener {

    private static final HashMap<Player, HomePoint> homes = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        load(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        save(event.getPlayer());
    }

    public homeManeger() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            load(player);
        }
    }

    public void onDisable(){
        for (Player player : homes.keySet()) {
            save(player);
        }
    }

    private static void load(Player player) {
        homes.put(player, new HomePoint(player));
    }

    private static void save(Player player) {
        homes.get(player).save();
        homes.remove(player);
    }

    public static HomePoint get(Player player){
        return homes.get(player);
    }

}
