package Database;

import java.sql.*;

public class Connector {
    public Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect
                    = DriverManager.getConnection("jdbc:mysql://localhost/erminoairlines", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
