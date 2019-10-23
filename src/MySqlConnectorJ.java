import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class MySqlConnectorJ {
    static Connection getConnection() throws SQLException {
        Connection connectToDB = null;
        String fileName = "db.properties";

        try (FileInputStream file = new FileInputStream(fileName)) {

            // load the properties file
            Properties properties = new Properties();
            properties.load(file);

            // get url from db.properties
            String url = properties.getProperty("url");

            // create a connection to the database
            connectToDB = DriverManager.getConnection(url, properties);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return connectToDB;
    }
}
