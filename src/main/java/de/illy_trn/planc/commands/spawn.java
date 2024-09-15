package de.illy_trn.planc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class spawn implements CommandExecutor {
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        int cooldownTime = 60;
        if(cooldowns.containsKey(sender.getName())) {
            long secondsLeft = ((cooldowns.get(sender.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                sender.sendMessage("§c§lCommand cooldown for " + secondsLeft + " seconds!");
                return true;
            }
        }
        cooldowns.put(sender.getName(), System.currentTimeMillis());
        if (sender instanceof Player player) {
            World overworld = Bukkit.getWorld("world");
            Location spawn = new Location(overworld, -598.5, 114, -981.5);
            player.teleport(spawn);
        } else { Bukkit.getConsoleSender().sendMessage("You are not a Player");}
        return true;
    }
}
