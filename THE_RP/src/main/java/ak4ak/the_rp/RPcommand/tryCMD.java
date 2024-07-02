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

import java.util.Random;

public class tryCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0){
                util.sendmesseg(sender, "&cНедостаточно аргуметов! &a/try <действие>" );
            }

            String text = String.join(" ", args);
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distanceSquared(target.getLocation()) <= 25*25) {
                    Random random = new Random();
                    boolean rnt = random.nextBoolean();
                    if (rnt == true){
                        target.sendMessage("*"+ RPnameDatabaseMenager.instance.getRPname(player.getName())+" "+text+"* "+ChatColor.DARK_GREEN +"<Удачно>");

                    }
                    else if(rnt == false){
                        target.sendMessage("*"+ RPnameDatabaseMenager.instance.getRPname(player.getName())+" "+text+"*"+ChatColor.RED+"<Неудачно>");
                    }

                }
            }
            return true;
        } else {
            sender.sendMessage("Команда доступна только игрокам!");
            return false;
        }
    }
}
