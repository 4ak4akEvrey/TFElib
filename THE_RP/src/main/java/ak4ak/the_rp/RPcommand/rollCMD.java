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

public class rollCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0){
                util.sendmesseg(sender, "&cНедостаточно аргуметов! &a/roll <действие>" );
            }

            String text = String.join(" ", args);
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distanceSquared(target.getLocation()) <= 25*25) {
                    Random random = new Random();
                    int rnt = random.nextInt(0,12);
                    if (rnt>=1 & rnt<=4){
                        target.sendMessage("*"+ RPnameDatabaseMenager.instance.getRPname(player.getName())+" "+text+"*"+ ChatColor.DARK_RED + "<"+rnt+"/"+12+">");}
                    if (rnt>=5 & rnt<=8){
                        target.sendMessage("*"+ RPnameDatabaseMenager.instance.getRPname(player.getName())+" "+text+"*"+ ChatColor.GOLD + "<"+rnt+"/"+12+">");}
                    if (rnt>=9 & rnt<=12){
                        target.sendMessage("*"+ RPnameDatabaseMenager.instance.getRPname(player.getName())+" "+text+"*"+ChatColor.DARK_GREEN+ "<"+rnt+"/"+12+">");}


                }
            }
            return true;
        } else {
            sender.sendMessage("Команда доступна только игрокам!");
            return false;
        }

    }
}
