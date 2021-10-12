package josemancharo.mc_kotlin.listeners

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Creeper
import org.bukkit.entity.Drowned
import org.bukkit.entity.EntityType
import org.bukkit.entity.Skeleton
import org.bukkit.event.*
import org.bukkit.event.entity.*
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import java.util.*
import kotlin.random.Random

class PlayerListeners : Listener {
    @EventHandler fun makeFireworksInsane(event: FireworkExplodeEvent) {
        event.entity.world.createExplosion(event.entity.location, 2f)
    }

    @EventHandler fun summonLightningOnChargedCreeperExplodeEvent(event: EntityExplodeEvent){
        if (event.entity.type == EntityType.CREEPER){
            val entity = event.entity as Creeper
            if (entity.isPowered){
                entity.world.spawnEntity(entity.location, EntityType.LIGHTNING)
            }
        }
    }

    @EventHandler fun chargeSomeCreepers(event: EntitySpawnEvent){
        if (event.entity.type == EntityType.CREEPER){
            val entity = event.entity as Creeper
            val rand = Random(System.currentTimeMillis()).nextInt(0, 100)
            if (rand == 100){
                entity.isPowered = true
            }
        }
    }

    @EventHandler fun spawnDeathSkeletons(event: EntitySpawnEvent){
        if (event.entity.type == EntityType.SKELETON){
            val entity = event.entity as Skeleton
            val rand = Random(System.currentTimeMillis()).nextInt(0, 100)
            if (rand == 100){
                entity.equipment?.setItemInMainHand(ItemStack(Material.STONE_SWORD))
                entity.equipment?.helmet = ItemStack(Material.CHAINMAIL_HELMET)
            }
        }
    }



}