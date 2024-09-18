package de.illy_trn.planc.items.SlimeBoots;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class SlimeBoots {

    public static ItemStack get() {
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();



        List<String> itemLore_slimeBoots = Arrays.asList("§7Jump Higher and your Safe fall distance is 30 ", "", "§5§lEPIC AXE");

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Slime Boots");
        meta.setLore(itemLore_slimeBoots);

        item.setItemMeta(meta);
        return item;
    }

}
