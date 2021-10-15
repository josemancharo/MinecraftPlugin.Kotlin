package josemancharo.mc_kotlin.listeners

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.*
import org.bukkit.event.*
import org.bukkit.event.entity.*
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import java.util.*
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import kotlin.random.Random

class ArrowListeners: Listener {
    @EventHandler fun onFlamingArrowHitCreeper(event: EntityDamageByEntityEvent){
        if ((event.damager.type == EntityType.ARROW || event.damager.type == EntityType.SPECTRAL_ARROW)
            && event.entity.type == EntityType.CREEPER){
            if (event.damager.isVisualFire){
                val creeper = event.entity as Creeper
                creeper.ignite()
            }
        }
    }

    @EventHandler fun makeFireworksInsane(event: FireworkExplodeEvent) {
        event.entity.world.createExplosion(event.entity.location, 2f)
    }

    @EventHandler fun playerPlaceFireball(event: PlayerInteractEvent){
        if (event.player.equipment?.itemInMainHand?.type == Material.FIRE_CHARGE){
            val location = event.clickedBlock?.location ?: event.player.location
            val fireball = event.player.world.spawnEntity(location, EntityType.FIREBALL) as Fireball
            fireball.direction = event.player.facing.direction
            fireball.velocity = event.player.location.direction.multiply(2)
            val playerHasGunpowder = event.player.inventory.contains(Material.GUNPOWDER)
            fireball.setIsIncendiary(playerHasGunpowder)
            if (playerHasGunpowder){
                val index = event.player.inventory.first(Material.GUNPOWDER)
                event.player.inventory.contents[index].amount -= 1
            }
        }
    }

    @EventHandler fun snowballDoFreeze(event: EntityDamageByEntityEvent){
        if (event.damager.type == EntityType.SNOWBALL && event.entity is LivingEntity){
            val entity = event.entity as LivingEntity
            entity.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 1, 1))
        }
    }
}