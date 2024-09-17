package de.illy_trn.planc.commands.backpack;

import de.illy_trn.planc.PlanC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackpackCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player player)) { return true; }

        Backpack backpack = PlanC.getInstance().getBackpackManager().getBackpack(player.getUniqueId());

        player.openInventory(backpack.getInventory());


        return true;
    }
    }

