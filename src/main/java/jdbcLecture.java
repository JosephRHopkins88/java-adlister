import com.mysql.jdbc.Driver;

import java.sql.*;

public class jdbcLecture {
    public static void main(String[] args) throws SQLException {
        Config config = new Config();
        // Instantiate the MySQL Driver to register to the built in Java Driver Manager.
        DriverManager.registerDriver(new Driver());

        // Connect to the database by providing the URL, user and the password of the user we want to connect as.

        Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());

        // Create a statemnt object to execute queries
        Statement statement = connection.createStatement();

        // We can use the Statement object to make our queries

        statement.execute("DELETE FROM albums WHERE id = 4");

//        statement.executeUpdate("INSERT INTO albums (artist, name, release_date, genre, sales) VALUES('Nelly Furtado', 'Loose', 2006, 'Dance-pop, hip hop, R&B', 12.5)");

        statement.executeQuery("SELECT * FROM albums");

        ResultSet rs = statement.executeQuery("SELECT * FROM albums");
// 'rs' is an instance of ResultSet
        while (rs.next()) {
            // do something with each row
            System.out.println("Here's an album:");
            System.out.println("  id: " + rs.getLong("id"));
            System.out.println("  artist: " + rs.getString("artist"));
            System.out.println("  name: " + rs.getString("name"));
        }

        String query = "INSERT INTO albums (artist, name, release_date, genre, sales) VALUES('Nelly Furtado', 'Loose', 2006, 'Pop, Urban, R&B', 12.5)";
        Statement stmt = connection.createStatement();
        try {
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }
        } catch(Exception e)  {

            System.out.println("There was an error attempting to add the record: " + e);
        }

    }
}
