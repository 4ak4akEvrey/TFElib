package ak4ak.the_rp.RPname;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class util {
    public static void sendmesseg(CommandSender commandSender,String text){
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',text));

    }
}
