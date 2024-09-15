package de.illy_trn.planc.items.MultishotBow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.List;

public class MultishotBowEvent implements Listener {
    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
         if (!e.getBow().getItemMeta().getDisplayName().contains("Triple Bow")) {
            return;
        }

        ItemMeta meta = e.getBow().getItemMeta();
        List<String> lore = meta.getLore();

        if (lore == null || !lore.contains("§7Shoots §b3§7 arrows at once!")) {
            return;
        }
        if (!(e.getEntity() instanceof Player player)) {
            return;
        }


        e.getEntity().getWorld().spawnArrow(e.getEntity().getLocation().clone().add(0,1.5,0), rotateVector(e.getProjectile().getVelocity(), 0.1), e.getForce() * 1, 0f);

        e.getEntity().getWorld().spawnArrow(e.getEntity().getLocation().clone().add(0,1.5,0), rotateVector(e.getProjectile().getVelocity(), -0.1), e.getForce() * 1,0f);



    }

            public Vector rotateVector(Vector vector, double whatAngle) {
                    double sin = Math.sin(whatAngle);
                    double cos = Math.cos(whatAngle);
                    double x = vector.getX() * cos + vector.getZ() * sin;
                    double z = vector.getX() * -sin + vector.getZ() * cos;

                    return vector.setX(x).setZ(z);
                }
        }
