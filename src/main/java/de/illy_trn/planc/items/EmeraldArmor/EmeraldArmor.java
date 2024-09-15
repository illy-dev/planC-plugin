package de.illy_trn.planc.items.EmeraldArmor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmeraldArmor {
    public static List<ItemStack> get() {
        List<ItemStack> armor = new ArrayList<>();
        List<String> itemLore = Arrays.asList("§6Full set Bonus:", "§7", "§7Only one arrow will be consumed per shot ", "", "§5§lEPIC HELMET");
        // Helmet
        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta metaHelmet = helmet.getItemMeta();
        metaHelmet.setDisplayName("Emerald Helmet");
        metaHelmet.setLore(itemLore);
        helmet.setItemMeta(metaHelmet);
        armor.add(helmet);

        // Chestplate
        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta metaChestplate = chestplate.getItemMeta();
        metaChestplate.setDisplayName("Emerald Chestplate");
        chestplate.setItemMeta(metaChestplate);
        armor.add(chestplate);

        // Leggings
        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta metaLeggings = leggings.getItemMeta();
        metaLeggings.setDisplayName("Emerald Leggings");
        leggings.setItemMeta(metaLeggings);
        armor.add(leggings);

        // Boots
        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta metaBoots = boots.getItemMeta();
        metaBoots.setDisplayName("Emerald Boots");
        boots.setItemMeta(metaBoots);
        armor.add(boots);

        return armor;
    }
}
