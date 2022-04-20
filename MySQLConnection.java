package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.util.Properties;

public class MySQLConnection
{
    public static void main(final String[] args) throws Exception {
        dbConnection();
    }
    
    public static void dbConnection() throws Exception {
        String DB_USER = null;
        String DB_PASSWORD = null;
        String DB_URL = null;
        final Properties prop = new Properties();
        final FileInputStream file = new FileInputStream("./config.properties");
        prop.load(file);
        file.close();
        DB_URL = prop.getProperty("db.url");
        DB_USER = prop.getProperty("db.user");
        DB_PASSWORD = prop.getProperty("db.password");
        System.out.println(DB_USER);
        System.out.println(DB_PASSWORD);
        System.out.println(DB_URL);
        final Properties properties = new Properties();
        properties.put("user", DB_USER);
        properties.put("password", DB_PASSWORD);
        Connection connection = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, properties);
            System.out.println("Connected!");
            final String q1 = "SHOW SCHEMAS";
            String query = "SHOW STATUS LIKE 'Ssl_cipher'";
            final PreparedStatement pre = connection.prepareStatement(q1);
            final PreparedStatement pre1 = connection.prepareStatement(query);
            ResultSet rs1=pre1.executeQuery();
            
            while (rs1.next()) {
                String Variable_name = rs1.getString("Variable_name");
                String Value = rs1.getString("Value");
                //System.out.println("Variable_name: " + Variable_name + "\t  Value: " + Value);
                System.out.println("Variable_name: " + Variable_name + "\nValue: " + Value);
            }
            rs = pre.executeQuery();
            while (rs.next()) {
                final String Schema = rs.getString(1);
                System.out.println(Schema);
                final String q2 = "SELECT table_name FROM information_schema.tables WHERE table_schema = (?)";
                final PreparedStatement p = connection.prepareStatement(q2);
                p.setString(1, Schema);
                final ResultSet rs2 = p.executeQuery();
                while (rs2.next()) {
                    System.out.println("table--" + rs2.getString(1));
                }
            }
        }
        catch (SQLException ex) {
            System.out.print(ex.getMessage());
            throw new Error("Error ", ex);
        }
    }
}
