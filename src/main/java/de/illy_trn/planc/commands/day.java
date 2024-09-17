package de.illy_trn.planc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class day implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("time.day")){
            if (sender instanceof Player){
                Player player = (Player) sender;


                // Set the time to day (1000 ticks is morning in Minecraft)
                player.getWorld().setTime(0);
                player.sendMessage("Time has been set to day.");
                return true;

            }
        }
        return true;
    }
}
