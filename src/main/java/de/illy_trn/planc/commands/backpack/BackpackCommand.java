package de.illy_trn.planc.commands.backpack;

import de.illy_trn.planc.PlanC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getServer;

public class BackpackCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player player)) { return true; }
        if (!(args[0].isEmpty())) {
            if (player.isOp()) {
                Player playerTarget = getServer().getPlayer(args[0]);
                Backpack backpack = PlanC.getInstance().getBackpackManager().getBackpack(playerTarget.getUniqueId());

                player.openInventory(backpack.getInventory());
                    }
        }

        Backpack backpack = PlanC.getInstance().getBackpackManager().getBackpack(player.getUniqueId());

        player.openInventory(backpack.getInventory());


        return true;
    }
    }

