package ak4ak.the_rp.RPname.Command;

import ak4ak.the_rp.RPnameDatabaseMenager;
import ak4ak.the_rp.RPname.util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class getrpnameCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            util.sendmesseg(sender,"&c Недостаточно аргументов! &fИспользуйте: &a/getplayer <ник>");
            return true;}
        String name = args[0];
        if (RPnameDatabaseMenager.instance.getRPname(name) != null){
            util.sendmesseg(sender,"&fРп имя игрока "+name+" - &a"+ RPnameDatabaseMenager.instance.getRPname(name));
        }else util.sendmesseg(sender, "&cПользователя с таким ником не сушествует!");


        return true;
    }
}
