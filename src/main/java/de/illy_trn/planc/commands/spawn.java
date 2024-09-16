package de.illy_trn.planc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class spawn implements CommandExecutor, Listener {
    private final HashMap<String, Long> cooldowns = new HashMap<>();
    private final HashMap<String, Long> combatLog = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            Bukkit.getConsoleSender().sendMessage("You are not a Player");
            return true;
        }

        if (combatLog.containsKey(player.getName())) {
            long secondsSinceCombat = (System.currentTimeMillis() / 1000) - (combatLog.get(player.getName()) / 1000);
            int combatLogTime = 10;
            if (secondsSinceCombat < combatLogTime) {
                player.sendMessage("§c§lYou cannot teleport while in combat! Wait " + (combatLogTime - secondsSinceCombat) + " seconds.");
                return true;
            }
        }

        if (cooldowns.containsKey(player.getName())) {
            int cooldownTime = 60;
            long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                player.sendMessage("§c§lCommand cooldown for " + secondsLeft + " seconds!");
                return true;
            }
        }

        cooldowns.put(player.getName(), System.currentTimeMillis());

        World overworld = Bukkit.getWorld("world");
        Location spawn = new Location(overworld, -598.5, 114, -981.5);
        player.teleport(spawn);
        return true;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player damaged) {
            combatLog.put(damaged.getName(), System.currentTimeMillis());
        }
        if (event.getDamager() instanceof Player damager) {
            combatLog.put(damager.getName(), System.currentTimeMillis());
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        combatLog.remove(event.getPlayer().getName());
    }
}
