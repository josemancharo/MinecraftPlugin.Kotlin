package josemancharo.mc_kotlin.enchantments

import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentTarget
import org.bukkit.inventory.ItemStack

//TODO: Make this actually do something. Right now, all it does is get registered.

class DeathBarterEnchantment(key: NamespacedKey): Enchantment(key) {
    override fun getName(): String {
        return "Death Barter"
    }

    override fun getMaxLevel(): Int {
        return 3
    }

    override fun getStartLevel(): Int {
        return 1
    }

    override fun getItemTarget(): EnchantmentTarget {
        return EnchantmentTarget.ARMOR_TORSO
    }

    override fun isTreasure(): Boolean {
        return true
    }

    override fun isCursed(): Boolean {
        return false
    }

    override fun conflictsWith(p0: Enchantment): Boolean {
        return false
    }

    override fun canEnchantItem(p0: ItemStack): Boolean {
        return p0.type.name.contains("CHESTPLATE")
    }

}