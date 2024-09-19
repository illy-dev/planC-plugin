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
    private final int combatLogTime = 15; // Dauer des Kampfes in Sekunden

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            Bukkit.getConsoleSender().sendMessage("You are not a Player");
            return true;
        }

        // Überprüfen, ob der Spieler sich im Kampf befindet
        if (isInCombat(player)) {
            long secondsLeft = combatLogTime - ((System.currentTimeMillis() / 1000) - (combatLog.get(player.getName()) / 1000));
            if (secondsLeft > 0) {
                player.sendMessage("§c§lYou cannot teleport while in combat! Wait " + secondsLeft + " seconds.");
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
            updateCombatLog(damaged);
            Bukkit.getLogger().info(damaged.getName() + " was damaged!");
        }
        if (event.getDamager() instanceof Player damager) {
            updateCombatLog(damager);
            Bukkit.getLogger().info(damager.getName() + " dealt damage!");
        }
    }

    private void updateCombatLog(Player player) {
        combatLog.put(player.getName(), System.currentTimeMillis());
        player.sendMessage("§c§lYou are now in combat for " + combatLogTime + " seconds!");
    }

    private boolean isInCombat(Player player) {
        if (!combatLog.containsKey(player.getName())) {
            return false;
        }
        long secondsSinceLastCombat = (System.currentTimeMillis() / 1000) - (combatLog.get(player.getName()) / 1000);
        return secondsSinceLastCombat < combatLogTime;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (isInCombat(player)) {
            // Hier kannst du Maßnahmen ergreifen, wenn ein Spieler im Kampf ausloggt (z.B. Bestrafung)
            Bukkit.broadcastMessage("§c§l" + player.getName() + " logged out during combat!");
            // Optional: Schaden hinzufügen oder eine Strafe festlegen
        }
        combatLog.remove(player.getName()); // Entferne den Spieler aus dem Combat-Log
    }
}
