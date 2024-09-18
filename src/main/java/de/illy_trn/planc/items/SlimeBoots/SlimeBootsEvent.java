package de.illy_trn.planc.items.SlimeBoots;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlimeBootsEvent implements Listener {

    public void onEquip(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();
        if (SlimeBootsisEquip(player)) {
            if (!player.hasPotionEffect(PotionEffectType.JUMP_BOOST)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, Integer.MAX_VALUE, 4, false, false, true));
                player.setFallDistance(30);
            }
        } else {
            player.removePotionEffect(PotionEffectType.JUMP_BOOST);
            player.setFallDistance(0);
        }
    }




    private boolean SlimeBootsisEquip(Player player) {
        ItemStack[] armorContents = player.getInventory().getArmorContents();

        if (armorContents.length != 4) {
            return false;
        }

        // Define armor piece names with their proper color codes
        String slimeBootsName = ChatColor.DARK_PURPLE + "Slime Boots";

        // Check if the player is wearing each piece of Emerald armor
        return isSlimeBoots(armorContents[0], slimeBootsName);  // Boots are at index 0
    }

    private boolean isSlimeBoots(ItemStack item, String expectedName) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName() && meta.getDisplayName().equals(expectedName);
    }

}
