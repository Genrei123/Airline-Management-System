package Database;

import java.sql.*;

public class Database {
    // Variable declaration
    String db_user = "root";
    String db_password = "";

    Connection connector;
    Connector connectDB = new Connector();

    public void insertData (String table, String value) throws SQLException {

        connector = connectDB.connectDB();
        String query = "INSERT INTO " + table;
        // Iniisip ko pa yung logic kung paano maraming where clause or maraming data iinsert which is hindi possible pag string lang.
        // Idea is to magcreate ng isa pang function na nagttake naman ng array
    }

    public void pullData (String table, String value) throws SQLException {


    }


}
