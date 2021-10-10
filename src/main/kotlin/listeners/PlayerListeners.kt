package josemancharo.mc_plugin_2.listeners

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Drowned
import org.bukkit.entity.EntityType
import org.bukkit.entity.*
import org.bukkit.event.*
import org.bukkit.event.entity.*
import org.bukkit.inventory.ItemStack

class PlayerListeners : Listener {
    @EventHandler
    fun onPlayerTakesDamage(event: EntityDeathEvent){
        if (event.entity.type == EntityType.PLAYER){
            event.entity.world.playSound(event.entity.location, Sound.ENTITY_GOAT_DEATH, 10f, 10f)
        }
    }

    @EventHandler
    fun onPlayerTakesStep(event: EntitySpawnEvent){
        if (event.entity.type == EntityType.DROWNED){
            val entity = event.entity as Drowned
            entity.equipment?.setItemInMainHand(ItemStack(Material.COOKIE))
        }
    }
}