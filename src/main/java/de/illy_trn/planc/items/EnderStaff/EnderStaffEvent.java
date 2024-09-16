package de.illy_trn.planc.items.EnderStaff;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnderStaffEvent implements Listener {

    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().getType() == Material.WOODEN_SWORD
                && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Enderstaff")) {

                if (player.getCooldown(Material.WOODEN_SWORD) == 0) {
                    Block b = player.getTargetBlock(null, 30);
                    Location loc = new Location(b.getWorld(), b.getX(), b.getY(), b.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());


                    player.teleport(loc);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                    player.setCooldown(Material.WOODEN_SWORD, 160);
                }
            }
        }
    }
}
