package de.illy_trn.planc.items.StormArmor;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class StormArmorEvent implements Listener {

    private HashMap<Player, Integer> hitCounter = new HashMap<>();

    @EventHandler
    public void onEquip(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();

        if(isWearingFullStormArmor(player)) {hitCounter.putIfAbsent(player, 0);} else {hitCounter.remove(player);}
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
         if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();

            if (isWearingFullStormArmor(player)) {
                int hits = hitCounter.getOrDefault(player, 0) + 1;
                hitCounter.put(player, hits);

                if (hits % 3 == 0) {
                    Entity hitEntity = e.getEntity();

                    Location hitLocation = ((Entity) hitEntity).getLocation();
                    hitLocation.getWorld().strikeLightning(hitLocation);

                    //Must be Fixed
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false, true));
                }
            }
        }
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
