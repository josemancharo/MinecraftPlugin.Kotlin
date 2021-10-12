package josemancharo.mc_kotlin

import josemancharo.mc_kotlin.listeners.PlayerListeners
import josemancharo.mc_kotlin.recipies.CustomRecipes
import org.bukkit.plugin.java.*;


class MainPlugin() : JavaPlugin() {
    public override fun onEnable(){
        server.pluginManager.registerEvents(PlayerListeners(), this)
        val recipes = CustomRecipes().getRecipes()
        for (r in recipes){
            server.addRecipe(r)
        }
    }

    public override fun onDisable(){

    }
}