package de.illy_trn.planc.commands.homeSystem;

import de.illy_trn.planc.PlanC;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.ChatColor;
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

public class home implements CommandExecutor, Listener {
    private final HashMap<String, Long> combatLog = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Du bist kein Spieler!!!");
            return true;
        }

        if (help(commandSender, args))
            return true;
        if (set(commandSender, args))
            return true;
        if (teleport(commandSender, args))
            return true;
        if (teleportCustom(commandSender, args))
            return true;
        if (remove(commandSender, args))
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

        if (combatLog.containsKey(player.getName())) {
            long secondsSinceCombat = (System.currentTimeMillis() / 1000) - (combatLog.get(player.getName()) / 1000);
            int combatLogTime = 10;
            if (secondsSinceCombat < combatLogTime) {
                player.sendMessage("§c§lYou cannot teleport while in combat! Wait " + (combatLogTime - secondsSinceCombat) + " seconds.");
                return true;
            }
        }

        HomePoint homePoint = homeManeger.get(player);
        if (!homePoint.exist(args[1])){
            sender.sendMessage(ChatColor.RED + "Dein home " + args[1] + " wurde noch nicht gesetzt!");
            return true;
        }


        homePoint.get(args[1]).teleport(player);
        player.sendMessage(ChatColor.GREEN + "Du wurdest nach Hause teleportiert!");


        return true;
    }




    public boolean teleport(CommandSender sender, String[] args) {
        if (args.length != 0)
            return false;

        Player player = (Player) sender;
        if (player == null)
            return false;

        if (combatLog.containsKey(player.getName())) {
            long secondsSinceCombat = (System.currentTimeMillis() / 1000) - (combatLog.get(player.getName()) / 1000);
            int combatLogTime = 10;
            if (secondsSinceCombat < combatLogTime) {
                player.sendMessage("§c§lYou cannot teleport while in combat! Wait " + (combatLogTime - secondsSinceCombat) + " seconds.");
                return true;
            }
        }

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

        String homeName ;
        if (args.length == 1) {
            homeName = "home";
        } else {
            homeName = args[1];
        }

        if (homeManeger.get(player).getHomes().size() >= PlanC.getConfiguration().getInt("home.max")) {
            if (!homeManeger.get(player).exist(homeName)) {
                sender.sendMessage(ChatColor.RED + "Deine maximale anzahl an Homes ist erreicht!");
                return true;
            }
        }

        homeManeger.get(player).set(homeName, player.getLocation());
        player.sendMessage(ChatColor.GREEN + "Dein Home wurde erfolgreich gesetzt!");


        return true;
    }


    public boolean remove(CommandSender sender, String[] args) {
        if (args.length != 2)
            return false;
        if (!args[0].equalsIgnoreCase("remove"))
            return false;
        if (!(sender instanceof Player))
            return false;
        Player player = (Player) sender;

        if (!homeManeger.get(player).exist(args[1])) {
            sender.sendMessage(ChatColor.YELLOW + "Das Home " + args[1] + " kann nicht gelöscht werden, da es nicht existiert!");
            return true;
        }

        homeManeger.get(player).remove(args[1]);
        sender.sendMessage( ChatColor.GREEN + "Du hast das Home " + args[1] + " wurde erfologreich gelöscht!");
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
