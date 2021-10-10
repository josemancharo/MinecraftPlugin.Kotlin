package josemancharo.mc_plugin_2

import josemancharo.mc_plugin_2.listeners.PlayerListeners
import org.bukkit.event.*;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.*;


class MainPlugin() : JavaPlugin() {
    public override fun onEnable(){
        server.pluginManager.registerEvents(PlayerListeners(), this)
    }

    public override fun onDisable(){

    }
}