package ak4ak.the_rp;

import java.sql.*;

public class RPnameDatabaseMenager {
    public static final RPnameDatabaseMenager instance = new RPnameDatabaseMenager();


    private final Connection connection;
    private final Statement statement;


    public RPnameDatabaseMenager() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:plugins/TFEdate/players.db");

            connection.prepareStatement("CREATE TABLE IF NOT EXISTS players (username TEXT PRIMARY KEY, rpname TEXT)").execute();
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);

        }
    }

    public void addRPname(String username, String RPname) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT OR REPLACE INTO players (username, rpname) VALUES (?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, RPname);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRPname(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT rpname FROM players WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String playerRPname = resultSet.getString("rpname");
                return playerRPname;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }

    public String getName(String RPname) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT username FROM players WHERE rpname = ?");
            statement.setString(1, RPname);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String playername = resultSet.getString("username");
                return playername;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
    public void delplayer (String username){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM players WHERE username = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}