package de.illy_trn.planc.items.CrystalDiamond.axe;

import net.kyori.adventure.text.BlockNBTComponent;
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

        if (player.getItemInHand().getType() == Material.NETHERITE_AXE && player.getItemInHand().getItemMeta().getDisplayName()
                .equals(ChatColor.DARK_PURPLE + "Crystal Diamond Axe") && isLog(breakBlock.getType())) {
            Location PosBreakBlock = breakBlock.getLocation();


            for (int i = 1; i <= 6; i++) {
                // Hol die Position des Blocks i Blöcke über dem abgebauten Block
                Block aboveBlock = PosBreakBlock.clone().add(0, i, 0).getBlock();

                // Wenn der obere Block auch ein Holzstamm ist, baue ihn ab
                if (isLog(aboveBlock.getType())) {
                    aboveBlock.breakNaturally();  // Baut den Block auf natürliche Weise ab
                } else {
                    // Wenn der Block kein Holzstamm mehr ist, beende die Schleife
                    break;
                }
            }






        }

    }

    private boolean isLog(Material material) {
        // Liste der unterstützten Baumstämme
        return material == Material.OAK_LOG || material == Material.BIRCH_LOG ||
                material == Material.SPRUCE_LOG || material == Material.JUNGLE_LOG ||
                material == Material.ACACIA_LOG || material == Material.DARK_OAK_LOG ||
                material == Material.MANGROVE_LOG || material == Material.CHERRY_LOG ||
                material == Material.WARPED_STEM || material == Material.CRIMSON_STEM;
    }

}
