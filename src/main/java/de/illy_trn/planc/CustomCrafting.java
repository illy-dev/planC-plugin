package de.illy_trn.planc;

import de.illy_trn.planc.items.EmeraldArmor.EmeraldArmor;
import de.illy_trn.planc.items.EnderStaff.EnderStaff;
import de.illy_trn.planc.items.MultishotBow.MultishotBow;
import de.illy_trn.planc.items.CrystalDiamond.axe;
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


    }
}
