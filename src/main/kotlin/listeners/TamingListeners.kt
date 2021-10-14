package josemancharo.mc_kotlin.listeners

import org.bukkit.Material
import org.bukkit.entity.*
import org.bukkit.entity.memory.MemoryKey
import org.bukkit.event.*
import org.bukkit.event.entity.EntityTargetEvent
import org.bukkit.event.entity.EntityTargetLivingEntityEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemStack
import org.bukkit.metadata.*
import org.bukkit.plugin.java.JavaPlugin
import java.lang.Exception

class TamingListeners(private val plugin: JavaPlugin) : Listener {
    private val _isNamedMetaTag = "TAME_OWNER"

    private val _untargetableMobs = listOf(
        EntityType.AXOLOTL,
        EntityType.BEE,
        EntityType.COW,
        EntityType.PIG,
        EntityType.CHICKEN,
        EntityType.DONKEY)

    @EventHandler fun tameGuardian(event: PlayerInteractEntityEvent){
        if (event.rightClicked.type == EntityType.GUARDIAN
            && event.player.equipment?.itemInMainHand?.type == Material.COOKIE){
            val entity = event.rightClicked as Guardian
            var item = event.player.equipment?.itemInMainHand ?: ItemStack(Material.AIR)
            item.amount -= 1
            entity.setMetadata(_isNamedMetaTag, FixedMetadataValue(plugin, event.player.name))
            plugin.server.dispatchCommand(plugin.server.consoleSender, "achievement grant ${event.player.name} only husbandry/tame_an_animal")
        }
    }

    @EventHandler fun keepGuardianTame(event: EntityTargetEvent){
        if (event.target?.type == EntityType.PLAYER
            && event.entity.type == EntityType.GUARDIAN
            && event.entity.hasMetadata(_isNamedMetaTag)){
            val guardian = event.entity as Guardian
            val tameOwner = guardian.getMetadata(_isNamedMetaTag)[0].asString()
            val targetableBaddies = guardian.getNearbyEntities(10.0, 10.0, 10.0).filter {
                it.name != tameOwner && !_untargetableMobs.contains(it.type) && !it.isDead
            }
            try {
                guardian.target = targetableBaddies.random() as LivingEntity
            }
            catch (e: Exception) {
                guardian.target = null
            }
        }
    }
}