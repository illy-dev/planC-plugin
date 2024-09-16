package de.illy_trn.planc.commands.homeSystem;

import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class home implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (help(commandSender, args))
            return true;
        if (set(commandSender, args))
            return true;
        if (teleport(commandSender, args))
            return true;
        if (teleportCustom(commandSender, args))
            return true;

        commandSender.sendMessage(ChatColor.RED + "Fehler: Benutze /home help für eine Hilfestellung");
        return true;
    }


    public boolean teleportCustom(CommandSender sender, String[] args){

        if (args.length != 2)
            return false;

        if (!args[0].equalsIgnoreCase("tp"))
            return false;

        Player player = (Player) sender;
        if (player == null)
            return false;

        HomePoint homePoint = homeManeger.get(player);
        if (!homePoint.exist(args[1])){
            sender.sendMessage(ChatColor.RED + "Dein home " + args[1] + " wurde noch nicht gesetzt!");
            return true;
        }


        homePoint.get(args[1]).teleport(player);
        player.sendMessage(ChatColor.GREEN + "Du wurdest nach Hause telepotiert!");


        return true;
    }




    public boolean teleport(CommandSender sender, String[] args) {
        if (args.length != 0)
            return false;

        Player player = (Player) sender;
        if (player == null)
            return false;

        HomePoint homePoint = homeManeger.get(player);
        if (!homePoint.exist("home")){
            sender.sendMessage(ChatColor.RED + "Dein home wurde noch nicht gesetzt!");
            return true;
        }


        homePoint.get("home").teleport(player);
        player.sendMessage(ChatColor.GREEN + "Du wurdest nach Hause telepotiert!");
        return true;
    }


    public boolean set(CommandSender sender, String[] args) {
        if (args.length != 1 && args.length != 2)
            return false;

        if (!args[0].equalsIgnoreCase("set"))
            return false;
        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;

        if (args.length == 1) {
            homeManeger.get(player).set("home", player.getLocation());
            player.sendMessage(ChatColor.GREEN + "Dein Home wurde erfolgreich gesetzt!");
            return true;
        }
        homeManeger.get(player).set(args[1], player.getLocation());
        player.sendMessage(ChatColor.GREEN + "Dein Home wurde erfolgreich gesetzt!");


        return true;
    }

    public boolean help(CommandSender sender, String[] args) {
        if (args.length != 1)
            return false;

        if (!args[0].equalsIgnoreCase("help"))
            return false;

        String color = ChatColor.BLUE.toString();
        String commandColor = ChatColor.GRAY.toString();
        String arrow = ChatColor.WHITE.toString() + "→";

        sender.sendMessage(color + ChatColor.BOLD + "-------------- Help: Home --------------");
        sender.sendMessage(commandColor + "/home " +  arrow + color +" Teleportiert dich zu deinem home.");
        sender.sendMessage(commandColor + "/home help " + arrow + color + " Gibt dir eine Hilfestellung zu dem Befehl.");
        sender.sendMessage(commandColor + "/home set " + arrow + color + " Setzt ein Home mit dem Namen home.");
        sender.sendMessage(commandColor + "/home set <name> " + arrow + color + " Setzt ein Home mit dem Angegebenen Namen.");
        sender.sendMessage(commandColor + "/home remove <name> " + arrow + color + " Löscht ein Home mit dem Angegebenen Namen.");
        sender.sendMessage(commandColor + "/home tp <name> " + arrow + color + " Telepotiert dich zu dem Home mit dem Angegebenen Namen.");

        return true;
    }

}
