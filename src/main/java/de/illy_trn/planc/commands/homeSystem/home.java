package de.illy_trn.planc.commands.homeSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class home implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {




        return false;
    }

    public boolean set(CommandSender sender, String[] args) {
        if (args.length != 1 || args.length != 2)
            return false;

        if (args[0].equalsIgnoreCase("set"))
            return false;

        if (args.length == 1) {
            return true;
        }

        return true;
    }

    public boolean help(CommandSender sender, String[] args) {
        if (args.length != 1)
            return false;

        if (args[0].equalsIgnoreCase("help"))
            return false;

        sender.sendMessage(ChatColor.BOLD + "/home " + "->" + "" + "Teleportiert dich zu deinem Home.");
        sender.sendMessage(ChatColor.BOLD + "/home set <name> " + "->" + "" + "Setzt ein Home mit dem Angegebenen Namen.");
        sender.sendMessage(ChatColor.BOLD + "/home set " + "->" + "" + "Setzt ein Home mit dem Namen Home.");

        return true;
    }

}
