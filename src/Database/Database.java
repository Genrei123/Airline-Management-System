package Database;

import java.sql.*;

public class Database {
    // Variable declaration
    String db_user = "root";
    String db_password = "";

    Connection connector;
    Connector connectDB = new Connector();
    PreparedStatement prepare;
    ResultSet result;

    public void insertData (String table, String value) throws SQLException {

        connector = connectDB.connectDB();
        String query = "INSERT INTO " + table;
        // Iniisip ko pa yung logic kung paano maraming where clause or maraming data iinsert which is hindi possible pag string lang.
        // Idea is to magcreate ng isa pang function na nagttake naman ng array
    }

    public void pullData (String table, String value) throws SQLException {


    }

    public boolean checkAccount(String username, String password) throws SQLException {
        String query = "SELECT * FROM `signin_users` WHERE BINARY username = ? AND password = ?";
        connector = connectDB.connectDB();

        if (connector == null)
        {
            System.out.println("Cannot connect to the database.");
            return false;
        }

        else
        {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, username);
                prepare.setString(2, password);

                result = prepare.executeQuery();

                if (result.next())
                {
                    return true;
                }

                else
                {
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }


}
