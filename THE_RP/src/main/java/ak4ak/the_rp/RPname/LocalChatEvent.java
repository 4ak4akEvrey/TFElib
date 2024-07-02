package ak4ak.the_rp.RPname;


import ak4ak.the_rp.RPnameDatabaseMenager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
public class LocalChatEvent implements Listener {
    @EventHandler
    public void onLocalChat(AsyncPlayerChatEvent event) {
        String message = String.format("%s",event.getMessage().replace("%", "%%"));
        event.setFormat(ChatColor.GREEN + RPnameDatabaseMenager.instance.getRPname(event.getPlayer().getName()) +": "+
                ChatColor.WHITE + message);

        }

    }

