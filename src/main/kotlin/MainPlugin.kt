package josemancharo.mc_kotlin

import josemancharo.mc_kotlin.enchantments.DeathBarterEnchantment
import josemancharo.mc_kotlin.listeners.ArrowListeners
import josemancharo.mc_kotlin.listeners.SpawnListeners
import josemancharo.mc_kotlin.recipies.CustomRecipes
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.plugin.java.*;


class MainPlugin() : JavaPlugin() {
    public override fun onEnable(){
        registerEvents()
        registerRecipes()
    }

    private fun registerEvents(){
        server.pluginManager.registerEvents(SpawnListeners(), this)
        server.pluginManager.registerEvents(ArrowListeners(), this)
    }

    private fun registerEnchantments(){
        Enchantment.registerEnchantment(DeathBarterEnchantment(NamespacedKey.minecraft("death_barter")))
        TODO("This will not do anything yet. Must implement real functionality for enchantment")
    }

    private fun registerRecipes(){
        val recipes = CustomRecipes().getRecipes()
        for (r in recipes){
            server.addRecipe(r)
        }
    }

    public override fun onDisable(){

    }
}