package de.illy_trn.planc.items.StormArmor;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StormArmorEvent implements Listener {

    @EventHandler
    public void onEquip(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();
        if (isWearingFullEmeraldArmor(player)) {
            if (!player.hasPotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE) && !player.hasPotionEffect(PotionEffectType.SPEED)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, Integer.MAX_VALUE, 0, false, false, true));
                player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, Integer.MAX_VALUE, 0, false, false, true));
            }
        } else {
            player.removePotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE);
            player.removePotionEffect(PotionEffectType.SPEED);
        }
    }

    private boolean isWearingFullEmeraldArmor(Player player) {
        ItemStack[] armorContents = player.getInventory().getArmorContents();

        if (armorContents.length != 4) {
            return false;
        }

        String stormHelmetName = "§6Storm Helmet";
        String stormChestplateName = "§6Storm Chestplate";
        String stormLeggingsName = "§6Storm Leggings";
        String stormBootsName = "§6Storm Boots";

        return isEmeraldArmorPiece(armorContents[3], stormHelmetName) &&
               isEmeraldArmorPiece(armorContents[2], stormChestplateName) &&
               isEmeraldArmorPiece(armorContents[1], stormLeggingsName) &&
               isEmeraldArmorPiece(armorContents[0], stormBootsName);
    }


    private boolean isEmeraldArmorPiece(ItemStack item, String expectedName) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName() && meta.getDisplayName().equals(expectedName);
    }
}
