package ak4ak.the_rp.RPcommand;

import ak4ak.the_rp.RPnameDatabaseMenager;
import ak4ak.the_rp.RPname.util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class doCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0){
                util.sendmesseg(sender, "&cНедостаточно аргуметов! &a/do <действие>" );
            }

            String text = String.join(" ", args);
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distanceSquared(target.getLocation()) <= 25*25) {
                    target.sendMessage(ChatColor.YELLOW +"*"+ text+"* "+"<"+ RPnameDatabaseMenager.instance.getRPname(player.getName())+">");
                }
            }
            return true;
        } else {
            sender.sendMessage("Команда доступна только игрокам!");
            return false;
        }
    }
}
