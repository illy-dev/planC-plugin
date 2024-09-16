package de.illy_trn.planc.items.CrystalDiamond;

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

        List<String> itemLore_axe = Arrays.asList("§7Mine §b6§7 Wood Blocks above the mined block ", "", "§5§lEPIC AXE");

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Crystal Diamond Axe");
        meta.setLore(itemLore_axe);

        item.setItemMeta(meta);
        return item;
    }

}
