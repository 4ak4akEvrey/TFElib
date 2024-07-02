package ak4ak.the_rp.RPname.Command;

import ak4ak.the_rp.RPnameDatabaseMenager;
import ak4ak.the_rp.RPname.util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class regplayerCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 2) {
            util.sendmesseg(sender,"&c Недостаточно аргументов! &fИспользуйте: &a/regplayer <ник> <РП имя>");
            return true;}
        String RPname = null;
        for (int i = 1; i <args.length; i++) {
            if (RPname == null)
                RPname = args[i];
            else RPname = RPname + " " + args[i];

        }
        String name = args[0];

        RPnameDatabaseMenager.instance.addRPname(name,RPname);
        util.sendmesseg(sender,"&a Пользователь успешно добавлен! Ник: &f"+ name+ " &aРПимя &f"+ RPname);
        Bukkit.getOfflinePlayer(args[0]).getPlayer().setDisplayName(RPnameDatabaseMenager.instance.getRPname(args[0]));
        return false;
    }
}
