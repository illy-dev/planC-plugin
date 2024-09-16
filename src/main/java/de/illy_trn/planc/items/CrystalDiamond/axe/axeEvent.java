package de.illy_trn.planc.items.CrystalDiamond.axe;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

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
