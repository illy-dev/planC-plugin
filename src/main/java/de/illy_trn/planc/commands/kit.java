package de.illy_trn.planc.commands;

import de.illy_trn.planc.items.CrystalDiamond.axe;
import de.illy_trn.planc.items.EmeraldArmor.EmeraldArmor;
import de.illy_trn.planc.items.EnderStaff.EnderStaff;
import de.illy_trn.planc.items.MultishotBow.MultishotBow;
import de.illy_trn.planc.items.StormArmor.StormArmor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class kit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(player.isOp()) {
                player.getInventory().addItem(MultishotBow.get());
                player.getInventory().addItem(EnderStaff.get());
                player.getInventory().addItem(axe.get());

                ItemStack[] itemsEmeraldArray = new ItemStack[EmeraldArmor.get().size()];
                EmeraldArmor.get().toArray(itemsEmeraldArray);

                ItemStack[] itemsStormArray = new ItemStack[StormArmor.get().size()];
                StormArmor.get().toArray(itemsStormArray);

                player.getInventory().addItem(itemsEmeraldArray);
                player.getInventory().addItem(itemsStormArray);

            } else {commandSender.sendMessage("You don't have Permissions!");}
        } else {commandSender.sendMessage("Du bist kein Spieler");}
        return true;
    }
}
