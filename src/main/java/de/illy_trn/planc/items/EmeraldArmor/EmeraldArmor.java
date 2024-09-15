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


        // Helmet
        List<String> itemLore_helmet = Arrays.asList("§6Full Set Bonus:",  "§7hero of the village effect", "", "§5§lEPIC HELMET");

        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta metaHelmet = helmet.getItemMeta();
        metaHelmet.setDisplayName("§5Emerald Helmet");
        metaHelmet.setLore(itemLore_helmet);
        helmet.setItemMeta(metaHelmet);
        armor.add(helmet);

        // Chestplate
        List<String> itemLore_chestplate = Arrays.asList("§6Full Set Bonus:", "§7hero of the village effect, speed", "", "§5§lEPIC CHESTPLATE");

        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta metaChestplate = chestplate.getItemMeta();
        metaChestplate.setDisplayName("§5Emerald Chestplate");
        metaChestplate.setLore(itemLore_chestplate);
        chestplate.setItemMeta(metaChestplate);
        armor.add(chestplate);

        // Leggings
        List<String> itemLore_leggings = Arrays.asList("§6Full Set Bonus:", "§7hero of the village effect", "", "§5§lEPIC LEGGINGS");

        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta metaLeggings = leggings.getItemMeta();
        metaLeggings.setDisplayName("§5Emerald Leggings");
        metaLeggings.setLore(itemLore_leggings);
        leggings.setItemMeta(metaLeggings);
        armor.add(leggings);

        // Boots
        List<String> itemLore_boots = Arrays.asList("§6Full Set Bonus:", "§7hero of the village effect", "", "§5§lEPIC BOOTS");

        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta metaBoots = boots.getItemMeta();
        metaBoots.setDisplayName("§5Emerald Boots");
        metaBoots.setLore(itemLore_boots);
        boots.setItemMeta(metaBoots);
        armor.add(boots);

        return armor;
    }
}
