package de.illy_trn.planc.items.MultishotBow;

import org.bukkit.ChatColor;
import org.bukkit.Material;


import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class MultishotBow {
    public static ItemStack get() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();

        List<String> itemLore = Arrays.asList("§7Shoots §b3§7 arrows at once!", "§7Only one arrow will be consumed per shot ", "", "§6§lLEGENDARY WEAPON");

        meta.setDisplayName(ChatColor.GOLD + "Triple Bow");
        meta.setLore(itemLore);

        item.setItemMeta(meta);
        return item;
    }

}
