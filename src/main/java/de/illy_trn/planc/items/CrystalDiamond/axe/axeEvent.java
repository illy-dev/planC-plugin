package de.illy_trn.planc.items.CrystalDiamond.axe;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class axeEvent implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block breakBlock = event.getBlock();

        if (player.getItemInHand().getType() == Material.NETHERITE_AXE && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Crystal Diamond Axe")) {
            Location PosBreakBlock = breakBlock.getLocation();







        }

    }

}
