package josemancharo.mc_kotlin

import josemancharo.mc_kotlin.listeners.PlayerListeners
import org.bukkit.plugin.java.*;


class MainPlugin() : JavaPlugin() {
    public override fun onEnable(){
        server.pluginManager.registerEvents(PlayerListeners(), this)
    }

    public override fun onDisable(){

    }
}