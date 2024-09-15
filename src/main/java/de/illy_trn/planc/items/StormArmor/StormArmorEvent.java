package de.illy_trn.planc.items.StormArmor;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StormArmorEvent implements Listener {

    @EventHandler
    public void onEquip(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();
    }

    private boolean isWearingFullStormArmor(Player player) {
        ItemStack[] armorContents = player.getInventory().getArmorContents();

        if (armorContents.length != 4) {
            return false;
        }

        String stormHelmetName = "§6Storm Helmet";
        String stormChestplateName = "§6Storm Chestplate";
        String stormLeggingsName = "§6Storm Leggings";
        String stormBootsName = "§6Storm Boots";

        return isStormArmorPiece(armorContents[3], stormHelmetName) &&
               isStormArmorPiece(armorContents[2], stormChestplateName) &&
               isStormArmorPiece(armorContents[1], stormLeggingsName) &&
               isStormArmorPiece(armorContents[0], stormBootsName);
    }


    private boolean isStormArmorPiece(ItemStack item, String expectedName) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName() && meta.getDisplayName().equals(expectedName);
    }
}
