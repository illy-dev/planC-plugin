package de.illy_trn.planc.commands;

import de.illy_trn.planc.items.MultishotBow.MultishotBow;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class kit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(player.isOp()) { player.getInventory().addItem(MultishotBow.get()); }
        } else {commandSender.sendMessage("Du bist kein Spieler");}
        return true;
    }
}
