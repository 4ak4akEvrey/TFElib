package ak4ak.the_rp;

import ak4ak.the_rp.RPcommand.*;
import ak4ak.the_rp.RPname.Command.getplayerCMD;
import ak4ak.the_rp.RPname.Command.deleteplayerCMD;
import ak4ak.the_rp.RPname.Command.getrpnameCMD;
import ak4ak.the_rp.RPname.Command.regplayerCMD;
import ak4ak.the_rp.RPname.Event;
import ak4ak.the_rp.RPname.LocalChatEvent;
import ak4ak.the_rp.RPname.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class THE_RP extends JavaPlugin {
    public static THE_RP instance;
    @Override
    public void onEnable() {
        instance = this;
        RPnameDatabaseMenager dbManager = new RPnameDatabaseMenager();
        getCommand("regplayer").setExecutor(new regplayerCMD());
        getCommand("getplayer").setExecutor(new getplayerCMD());
        getCommand("deleteplayer").setExecutor(new deleteplayerCMD());
        getCommand("getrpname").setExecutor(new getrpnameCMD());
        getCommand("me").setExecutor(new meCMD());
        getCommand("do").setExecutor(new doCMD());
        getCommand("ooc").setExecutor(new oocCMD());
        getCommand("roll").setExecutor(new rollCMD());
        getCommand("try").setExecutor(new tryCMD());
        Bukkit.getPluginManager().registerEvents(new Event(),this);
        Bukkit.getPluginManager().registerEvents(new LocalChatEvent(),this);
        new Placeholder().register();



        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
