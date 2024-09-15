package de.illy_trn.planc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            World overworld = Bukkit.getWorld("world");
            Location spawn = new Location(overworld, -598, 114, -981);
            player.teleport(spawn);
        } else { Bukkit.getConsoleSender().sendMessage("You are not a Player");
        }
        return true;
    }
}
