package de.illy_trn.planc;

import de.illy_trn.planc.items.EmeraldArmor.EmeraldArmor;
import de.illy_trn.planc.items.EnderStaff.EnderStaff;
import de.illy_trn.planc.items.MultishotBow.MultishotBow;
import de.illy_trn.planc.items.CrystalDiamond.axe;
import de.illy_trn.planc.items.StormArmor.StormArmor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomCrafting {

    public static void register(JavaPlugin plugin) {
        // multishotbow
        NamespacedKey key1 = new NamespacedKey(plugin, "multishot_bow");

        ItemStack multishotBowItem = MultishotBow.get();

        ShapedRecipe multishotBowRecipe = new ShapedRecipe(key1, multishotBowItem);

        multishotBowRecipe.shape("AB*", "A*B", "AB*");
        multishotBowRecipe.setIngredient('A', Material.COBWEB);
        multishotBowRecipe.setIngredient('B', Material.BREEZE_ROD);

        Bukkit.addRecipe(multishotBowRecipe);
        // enderstaff
        NamespacedKey key2 = new NamespacedKey(plugin, "ender_staff");

        ItemStack enderStaffItem = EnderStaff.get();

        ShapedRecipe enderStaffItemRecipe = new ShapedRecipe(key2, enderStaffItem);

        enderStaffItemRecipe.shape("*BC", "*AB", "A**");
        enderStaffItemRecipe.setIngredient('A', Material.BREEZE_ROD);
        enderStaffItemRecipe.setIngredient('B', Material.SMALL_AMETHYST_BUD);
        enderStaffItemRecipe.setIngredient('C', Material.ENDER_EYE);

        Bukkit.addRecipe(enderStaffItemRecipe);
        // diamond crystal axe
        NamespacedKey key3 = new NamespacedKey(plugin, "diamond_crystal_axe");

        ItemStack diamondCrystalAxe = axe.get();

        ShapedRecipe diamondCrystalAxeRecipe = new ShapedRecipe(key3, diamondCrystalAxe);

        diamondCrystalAxeRecipe.shape("ABA", "BCB", "ABA");
        diamondCrystalAxeRecipe.setIngredient('A', Material.AMETHYST_SHARD);
        diamondCrystalAxeRecipe.setIngredient('B', Material.DIAMOND);
        diamondCrystalAxeRecipe.setIngredient('C', Material.NETHERITE_AXE);

        Bukkit.addRecipe(diamondCrystalAxeRecipe);
        // Emerald Armor
        ItemStack[] itemsEmeraldArray = new ItemStack[EmeraldArmor.get().size()];
        EmeraldArmor.get().toArray(itemsEmeraldArray);

        NamespacedKey key4 = new NamespacedKey(plugin, "emerald_helmet");

        ItemStack emeraldHelmet = itemsEmeraldArray[0];

        ShapedRecipe emeraldHelmetRecipe = new ShapedRecipe(key4, emeraldHelmet);

        emeraldHelmetRecipe.shape("ABA", "BCB", "ABA");
        emeraldHelmetRecipe.setIngredient('A', Material.SUGAR);
        emeraldHelmetRecipe.setIngredient('B', Material.EMERALD_BLOCK);
        emeraldHelmetRecipe.setIngredient('C', Material.NETHERITE_HELMET);

        Bukkit.addRecipe(emeraldHelmetRecipe);

        NamespacedKey key5 = new NamespacedKey(plugin, "emerald_chestplate");

        ItemStack emeraldChestplate = itemsEmeraldArray[1];

        ShapedRecipe emeraldChestplateRecipe = new ShapedRecipe(key5, emeraldChestplate);

        emeraldChestplateRecipe.shape("ABA", "BCB", "ABA");
        emeraldChestplateRecipe.setIngredient('A', Material.SUGAR);
        emeraldChestplateRecipe.setIngredient('B', Material.EMERALD_BLOCK);
        emeraldChestplateRecipe.setIngredient('C', Material.NETHERITE_CHESTPLATE);

        Bukkit.addRecipe(emeraldChestplateRecipe);

        NamespacedKey key6 = new NamespacedKey(plugin, "emerald_leggings");

        ItemStack emeraldLeggings = itemsEmeraldArray[2];

        ShapedRecipe emeraldLeggingsRecipe = new ShapedRecipe(key6, emeraldLeggings);

        emeraldLeggingsRecipe.shape("ABA", "BCB", "ABA");
        emeraldLeggingsRecipe.setIngredient('A', Material.SUGAR);
        emeraldLeggingsRecipe.setIngredient('B', Material.EMERALD_BLOCK);
        emeraldLeggingsRecipe.setIngredient('C', Material.NETHERITE_LEGGINGS);

        Bukkit.addRecipe(emeraldLeggingsRecipe);

        NamespacedKey key7 = new NamespacedKey(plugin, "emerald_boots");

        ItemStack emeraldBoots = itemsEmeraldArray[3];

        ShapedRecipe emeraldBootsRecipe = new ShapedRecipe(key7, emeraldBoots);

        emeraldBootsRecipe.shape("ABA", "BCB", "ABA");
        emeraldBootsRecipe.setIngredient('A', Material.SUGAR);
        emeraldBootsRecipe.setIngredient('B', Material.EMERALD_BLOCK);
        emeraldBootsRecipe.setIngredient('C', Material.NETHERITE_BOOTS);

        Bukkit.addRecipe(emeraldBootsRecipe);

        // Storm Armor
        ItemStack[] itemsStormArray = new ItemStack[StormArmor.get().size()];
        StormArmor.get().toArray(itemsStormArray);

        NamespacedKey key8 = new NamespacedKey(plugin, "storm_helmet");

        ItemStack stormHelmet = itemsStormArray[0];

        ShapedRecipe stormHelmetRecipe = new ShapedRecipe(key8, stormHelmet);

        stormHelmetRecipe.shape("ABA", "CDC", "CEC");
        stormHelmetRecipe.setIngredient('A', Material.COPPER_INGOT);
        stormHelmetRecipe.setIngredient('B', Material.CLOCK);
        stormHelmetRecipe.setIngredient('C', Material.DIAMOND);
        stormHelmetRecipe.setIngredient('D', Material.NETHERITE_HELMET);
        stormHelmetRecipe.setIngredient('E', Material.END_CRYSTAL);

        Bukkit.addRecipe(stormHelmetRecipe);

        NamespacedKey key9 = new NamespacedKey(plugin, "storm_chestplate");

        ItemStack stormChestplate = itemsStormArray[1];

        ShapedRecipe stormChestplateRecipe = new ShapedRecipe(key9, stormChestplate);

        stormChestplateRecipe.shape("ABA", "CDC", "CEC");
        stormChestplateRecipe.setIngredient('A', Material.COPPER_INGOT);
        stormChestplateRecipe.setIngredient('B', Material.CLOCK);
        stormChestplateRecipe.setIngredient('C', Material.DIAMOND);
        stormChestplateRecipe.setIngredient('D', Material.NETHERITE_CHESTPLATE);
        stormChestplateRecipe.setIngredient('E', Material.END_CRYSTAL);

        Bukkit.addRecipe(stormChestplateRecipe);

        NamespacedKey key10 = new NamespacedKey(plugin, "storm_leggings");

        ItemStack stormLeggings = itemsStormArray[2];

        ShapedRecipe stormLeggingsRecipe = new ShapedRecipe(key10, stormLeggings);

        stormLeggingsRecipe.shape("ABA", "CDC", "CEC");
        stormLeggingsRecipe.setIngredient('A', Material.COPPER_INGOT);
        stormLeggingsRecipe.setIngredient('B', Material.CLOCK);
        stormLeggingsRecipe.setIngredient('C', Material.DIAMOND);
        stormLeggingsRecipe.setIngredient('D', Material.NETHERITE_LEGGINGS);
        stormLeggingsRecipe.setIngredient('E', Material.END_CRYSTAL);

        Bukkit.addRecipe(stormLeggingsRecipe);

        NamespacedKey key11 = new NamespacedKey(plugin, "storm_boots");

        ItemStack stormBoots = itemsStormArray[3];

        ShapedRecipe stormBootsRecipe = new ShapedRecipe(key11, stormBoots);

        stormBootsRecipe.shape("ABA", "CDC", "CEC");
        stormBootsRecipe.setIngredient('A', Material.COPPER_INGOT);
        stormBootsRecipe.setIngredient('B', Material.CLOCK);
        stormBootsRecipe.setIngredient('C', Material.DIAMOND);
        stormBootsRecipe.setIngredient('D', Material.NETHERITE_BOOTS);
        stormBootsRecipe.setIngredient('E', Material.END_CRYSTAL);

        Bukkit.addRecipe(stormBootsRecipe);

    }
}
