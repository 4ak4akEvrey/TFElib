package ak4ak.the_rp.RPname;

import ak4ak.the_rp.RPnameDatabaseMenager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {
    @EventHandler
    public static void JoinPlayer(PlayerJoinEvent event){
        if (RPnameDatabaseMenager.instance.getRPname(event.getPlayer().getName()) == null){
            event.getPlayer().kickPlayer("Вы не прошли регистрацию, либо наша команда не успела вас добавить!");
        }else event.getPlayer().setDisplayName(RPnameDatabaseMenager.instance.getRPname(event.getPlayer().getName()));
    }
}
