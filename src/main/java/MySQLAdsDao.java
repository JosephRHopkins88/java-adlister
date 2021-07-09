import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private final Connection connection;

    public MySQLAdsDao(Config config) {
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        }
        catch (SQLException error) {
            throw new RuntimeException("Error connecting to the database.");
        }
    }


    @Override
    public List<Ad> all() {
        List<Ad> allAds = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String showAds = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(showAds);

            while(rs.next()) {
                allAds.add(new Ad (
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return allAds;

        } catch (SQLException error) {
            throw new RuntimeException("Error retrieving all ads.");
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            String insertAdQuery = "INSERT INTO ads (user_id, title, description) VALUES ("
                    + "" + ad.getUserId() + ", "
                    + "'" + ad.getTitle() + "', "
                    + "'" + ad.getDescription() + "')";
            stmt.executeUpdate(insertAdQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException error) {
            throw new RuntimeException("Could not insert ad successfully.");
        }

    }



}
