package ak4ak.the_rp.RPname.Command;

import ak4ak.the_rp.RPnameDatabaseMenager;
import ak4ak.the_rp.RPname.util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class getplayerCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            util.sendmesseg(sender,"&c Недостаточно аргументов! &fИспользуйте: &a/getplayer <ник>");
            return true;}
        String name = null;
        for (int i = 0; i <args.length; i++) {
            if (name == null)
                name = args[i];
            else name = name + " " + args[i];}
        sender.sendMessage(name);
        if (RPnameDatabaseMenager.instance.getName(name) == null){
            util.sendmesseg(sender, "&cПользователя с таким ником не сушествует!");

        }else util.sendmesseg(sender,"&fНик игрока "+name+" - &a"+ RPnameDatabaseMenager.instance.getName(name));
        return true;
    }
}
