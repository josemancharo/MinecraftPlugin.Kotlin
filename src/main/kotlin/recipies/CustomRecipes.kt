package josemancharo.mc_kotlin.recipies

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

internal class CustomRecipes {
    fun getRecipes(): Iterable<ShapedRecipe>{
        val list = ArrayList<ShapedRecipe>()
        list.add(getTridentRecipe())
        list.add(getIronHorseRecipe())
        list.add(makeCopperUseful())
        return list
    }

    private fun getTridentRecipe(): ShapedRecipe {
        val items = ItemStack(Material.TRIDENT, 1)
        val recipe = ShapedRecipe(NamespacedKey.minecraft("trident"), items)
        recipe.shape("dhd", " c ", " i ")
        recipe.setIngredient('h', Material.HEART_OF_THE_SEA)
        recipe.setIngredient('d', Material.DIAMOND)
        recipe.setIngredient('c', Material.COPPER_INGOT)
        recipe.setIngredient('i', Material.IRON_INGOT)
        return recipe
    }

    private fun getIronHorseRecipe(): ShapedRecipe {
        val items = ItemStack(Material.LEATHER_HORSE_ARMOR, 1)
        val recipe = ShapedRecipe(NamespacedKey.minecraft("iron_horse_armor"), items)
        recipe.shape("il ", "iii", "i i")
        recipe.setIngredient('l', Material.LEATHER)
        recipe.setIngredient('i', Material.IRON_INGOT)
        return recipe
    }

    private fun makeCopperUseful(): ShapedRecipe {
        val items = ItemStack(Material.MULE_SPAWN_EGG)
        val recipe = ShapedRecipe(NamespacedKey.minecraft("mule_spawn_egg"), items)
        recipe.shape("cpc", "brb", "php")
        recipe.setIngredient('c', Material.COPPER_BLOCK)
        recipe.setIngredient('p', Material.END_ROD)
        recipe.setIngredient('r', Material.CUT_COPPER_STAIRS)
        recipe.setIngredient('b', Material.DIAMOND_HOE)
        recipe.setIngredient('h', Material.FIREWORK_ROCKET)
        return recipe
    }
}