package de.illy_trn.planc.commands.tpaSystem;

import de.illy_trn.planc.PlanC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tpaDecline implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            PlanC.tpa.remove(p);
            p.sendMessage("§9[TPA] " + "§7|" +  " Du hast die Tpa Anfrage abgelehnt.");
            Player p2 = PlanC.tpa.get(p);
            p2.sendMessage("§9[TPA] " + "§7|" +  " Deine Anfrage wurde abgelehnt!.");
            return true;

        }



        return false;
    }
}
