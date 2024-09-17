package de.illy_trn.planc.items.Shortbow;

import org.bukkit.ChatColor;
import org.bukkit.Material;


import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class Shortbow {
    public static ItemStack get() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();

        List<String> itemLore = Arrays.asList("§7Shoots arrows instantly", "§8Cooldown: §a1s", "", "§5§lEPIC WEAPON");

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Short bow");
        meta.setLore(itemLore);

        item.setItemMeta(meta);
        return item;
    }

}