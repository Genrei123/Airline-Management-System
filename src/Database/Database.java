package Database;

import java.sql.*;
import java.util.List;

public class Database {
    // Variable declaration
    String db_user = "root";
    String db_password = "";

    Connection connector;
    Connector connectDB = new Connector();
    PreparedStatement prepare;
    ResultSet result;

    public void insertData (String tableName, List<String> columnNames, List<Object> values) throws SQLException {


        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (" + String.join(",", columnNames) + ") VALUES (");
        for (int i = 0; i < columnNames.size(); i++)
        {
            query.append("?");
            if (i < columnNames.size() - 1) {
                query.append(", ");
            }
        }
        query.append(")");


        connector = connectDB.connectDB();
        if (connector == null)
        {
            System.out.println("Cannot connect to the database.");
        }

        else
        {
            prepare = connector.prepareStatement(query.toString());

            for (int i = 0; i < values.size() ; i++)
            {
                prepare.setObject(i + 1, values.get(i));
            }

            prepare.executeUpdate();

            prepare.close();
            connector.close();
        }
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

    public boolean checkAccount(String username) throws SQLException {
        String query = "SELECT * FROM `signin_users` WHERE BINARY username = ?";
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
