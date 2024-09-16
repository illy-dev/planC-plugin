package de.illy_trn.planc.commands.homeSystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class tabcompleters implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String lable, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Du bist kein Spieler!!!");
            return new ArrayList<>();
        }

        if (args.length == 1) {
            return getFirstList();
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("set")) {
                return getHomes((Player) sender);
            } else if (args[0].equalsIgnoreCase("tp")) {
                return getHomes((Player) sender);
            }else if (args[0].equalsIgnoreCase("remove")) {
                return getHomes((Player) sender);
            }

        }


        return new ArrayList<>();
    }


    public ArrayList<String> getHomes(Player player) {
        return new  ArrayList<>(homeManeger.get(player).getHomes());
    }

    public ArrayList<String> getFirstList() {
        ArrayList<String> list = new ArrayList<>();

        list.add("help");
        list.add("set");
        list.add("remove");
        list.add("tp");

        return list;
    }
}
