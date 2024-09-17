package de.illy_trn.planc.commands.backpack;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class backpack implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(sender instanceof Player player) {
            if (player.isOp()) {
                if (args[0].equalsIgnoreCase("open")) {
                    if (args[1].isEmpty()) {
                            sender.sendMessage(ChatColor.RED + "You need to specify a player");
                        }
                }


                }
            }

        return true;
    }
    }

