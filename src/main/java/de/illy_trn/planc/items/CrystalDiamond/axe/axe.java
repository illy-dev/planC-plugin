package de.illy_trn.planc.items.CrystalDiamond.axe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class axe {

    public static ItemStack get() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        //10 blöcke 8 sekunden
        List<String> itemLore_axe = Arrays.asList("§7Mine 6 WoodBlocks above the mined block ", "", "§5§lEPIC AXE");

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Crystal Diamond Axe");
        meta.setLore(itemLore_axe);

        item.setItemMeta(meta);
        return item;
    }

}