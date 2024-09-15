package de.illy_trn.planc.items.EmeraldArmor;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EmeraldArmorEvent implements Listener {

    @EventHandler
    public void onEquip(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();
        // Check if the player is wearing the full Emerald armor set
        if (isWearingFullEmeraldArmor(player)) {
            // Increase max health and give potion effect
            if (player.getMaxHealth() != 30) {  // Avoid repeatedly setting max health if it's already set
                player.setMaxHealth(30);
            }
            if (!player.hasPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, Integer.MAX_VALUE, 0, false, false, true));
            }
        } else {
            // Reset max health and remove potion effect if not fully equipped with Emerald armor
            if (player.getMaxHealth() != 20) {
                player.setMaxHealth(20);  // Reset to default health
            }
            player.removePotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE);
        }
    }

    // Check if the player is wearing the full Emerald armor set
    private boolean isWearingFullEmeraldArmor(Player player) {
        ItemStack[] armorContents = player.getInventory().getArmorContents();

        if (armorContents.length != 4) {
            return false;
        }

        // Define armor piece names with their proper color codes
        String emeraldHelmetName = "§5Emerald Helmet";
        String emeraldChestplateName = "§5Emerald Chestplate";
        String emeraldLeggingsName = "§5Emerald Leggings";
        String emeraldBootsName = "§5Emerald Boots";

        // Check if the player is wearing each piece of Emerald armor
        return isEmeraldArmorPiece(armorContents[3], emeraldHelmetName) &&  // Helmet is at index 3
               isEmeraldArmorPiece(armorContents[2], emeraldChestplateName) &&  // Chestplate is at index 2
               isEmeraldArmorPiece(armorContents[1], emeraldLeggingsName) &&  // Leggings are at index 1
               isEmeraldArmorPiece(armorContents[0], emeraldBootsName);  // Boots are at index 0
    }

    // Check if the armor piece has the expected name
    private boolean isEmeraldArmorPiece(ItemStack item, String expectedName) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName() && meta.getDisplayName().equals(expectedName);
    }
}
