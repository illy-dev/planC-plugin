package de.illy_trn.planc.commands.tpaSystem;

import de.illy_trn.planc.PlanC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tpaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            try {
                Player p2 = Bukkit.getPlayer(args[0]);
                PlanC.tpa.put(p2, p);
                p2.sendMessage("§9[TPA] " + "§7| §a" + p.getName() + " §7 hat dir eine Tpa Anfrage gesendet!");
                p2.sendMessage("§9[TPA] " + "§7|" +  " Nehme die Anfrage mit /tpaccept an.");

                p.sendMessage("§9[TPA] " + "§7| " + "Tpa Anfrage an §a" + p2.getName() + " §7wurde gesendet!");

            }
            catch (Exception e) {
                p.sendMessage("§9[TPA] " + "§7| " + "Spieler nicht Online!");
            }
        } else {
            p.sendMessage("§9[TPA] " + "§7| " + "§cBenutze Tpa <Spieler>");
        }


        return false;
    }
}
