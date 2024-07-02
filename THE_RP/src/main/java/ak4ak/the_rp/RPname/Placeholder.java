package ak4ak.the_rp.RPname;

import ak4ak.the_rp.RPnameDatabaseMenager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Placeholder extends PlaceholderExpansion {

    public @Override String getIdentifier() {
        return "TFE";
    }

    public @Override String getAuthor() {
        return "4ak4ak_";
    }

    public @Override String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return "";
        }

        if (identifier.equals("rpname")) {
            String RPname = RPnameDatabaseMenager.instance.getRPname(player.getName());
            if (RPname != null) {
                return RPname;
            }
        }

        return null;
    }

}