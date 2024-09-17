package de.illy_trn.planc.commands.tpaSystem;

import de.illy_trn.planc.PlanC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tpacceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            Player p2 = PlanC.tpa.get(p);

            p2.teleport(p.getLocation());

            p.sendMessage("§9[TPA] " + "§7| " + "Spieler §a" + p2.getName() + " §7wurde zu dir Teleportiert!");
            p2.sendMessage("§9[TPA] " + "§7| " + " Du wurdest zu §a" + p.getName() + " §7Teleportiert!");
        }




        return false;
    }
}
