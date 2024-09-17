package de.illy_trn.planc.items.MultishotShortBow;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MultishotShortBowEvent implements Listener {

    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_AIR)) {
            if (player.getItemInHand().getType() == Material.BOW
                && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "multishotshort bow")) {


                if (player.getCooldown(Material.BOW) == 0 && player.getInventory().containsAtLeast(ItemStack.of(Material.ARROW), 1)) {
                    Location loc = player.getLocation();

                    loc.add(0, 1.5, 0);
                    if (player.getItemInHand().getEnchantmentLevel(Enchantment.POWER) == 0) {Arrow arrow = player.getWorld().spawnArrow(loc, loc.getDirection(), 2, 1);arrow.setShooter(player);}
                    if (player.getItemInHand().getEnchantmentLevel(Enchantment.POWER) == 1) {Arrow arrow = player.getWorld().spawnArrow(loc, loc.getDirection(), 2, 1); arrow.setDamage(9);arrow.setShooter(player);}
                    if (player.getItemInHand().getEnchantmentLevel(Enchantment.POWER) == 2) {Arrow arrow = player.getWorld().spawnArrow(loc, loc.getDirection(), 2, 1); arrow.setDamage(11);arrow.setShooter(player);}
                    if (player.getItemInHand().getEnchantmentLevel(Enchantment.POWER) == 3) {Arrow arrow = player.getWorld().spawnArrow(loc, loc.getDirection(), 2, 1); arrow.setDamage(12);arrow.setShooter(player);}
                    if (player.getItemInHand().getEnchantmentLevel(Enchantment.POWER) == 4) {Arrow arrow = player.getWorld().spawnArrow(loc, loc.getDirection(), 2, 1); arrow.setDamage(14);arrow.setShooter(player);}
                    if (player.getItemInHand().getEnchantmentLevel(Enchantment.POWER) == 5) {Arrow arrow = player.getWorld().spawnArrow(loc, loc.getDirection(), 2, 1); arrow.setDamage(15);arrow.setShooter(player);}

                    player.setCooldown(Material.BOW, 10);
                    if (!player.getItemInHand().containsEnchantment(Enchantment.INFINITY)) {player.getInventory().removeItem(ItemStack.of(Material.ARROW));}

                }
            }
        }
    }
}
