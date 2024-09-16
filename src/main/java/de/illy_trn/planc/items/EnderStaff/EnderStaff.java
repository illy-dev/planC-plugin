package de.illy_trn.planc.items.EnderStaff;

import org.bukkit.ChatColor;
import org.bukkit.Material;


import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class EnderStaff {
    public static ItemStack get() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        //10 blöcke 8 sekunden
        List<String> itemLore = Arrays.asList("§7Teleport §b10§7 blocks ahead of you", "§8Cooldown: §a8s", "", "§d§lMYTHIC STAFF");

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Enderstaff");
        meta.setLore(itemLore);

        item.setItemMeta(meta);
        return item;
    }

}

