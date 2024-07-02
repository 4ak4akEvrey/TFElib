package ak4ak.the_rp.RPname.Command;

import ak4ak.the_rp.RPnameDatabaseMenager;
import ak4ak.the_rp.RPname.util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class deleteplayerCMD implements CommandExecutor {
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

        util.sendmesseg(sender,"&aВы успешно удалили игрока с ником &f"+name+"/"+ RPnameDatabaseMenager.instance.getRPname(name));
        RPnameDatabaseMenager.instance.delplayer(name);
        return true;
    }
}
