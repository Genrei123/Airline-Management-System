package Database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    // Variable declaration
    String db_user = "root";
    String db_password = "";

    Connection connector;
    Connector connectDB = new Connector();
    PreparedStatement prepare;
    ResultSet result;

    public void insertData(String tableName, List<String> columnNames, List<Object> values) throws SQLException {

        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (" + String.join(",", columnNames) + ") VALUES (");
        for (int i = 0; i < columnNames.size(); i++) {
            query.append("?");
            if (i < columnNames.size() - 1) {
                query.append(", ");
            }
        }
        query.append(")");

        connector = connectDB.connectDB();
        if (connector == null) {
            System.out.println("Cannot connect to the database.");
        } else {
            prepare = connector.prepareStatement(query.toString());

            for (int i = 0; i < values.size(); i++) {
                prepare.setObject(i + 1, values.get(i));
            }

            prepare.executeUpdate();

            prepare.close();
            connector.close();
        }
    }

    public void updateData(String tableName, List<String> updateColumn, List<Object> values, List<String> condition, List<Object> conditionValue) throws SQLException {

        StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
        for (int i = 0; i < updateColumn.size(); i++) {
            query.append(updateColumn.get(i) + " = ?");
            if (i < updateColumn.size() - 1) {
                query.append(", ");
            }
        }

        if (!condition.isEmpty()) {
            query.append(" WHERE ");
            for (int i = 0; i < condition.size(); i++) {
                query.append(condition.get(i) + " = ?");
                if (i < condition.size() - 1) {
                    query.append(" AND ");
                }
            }
        }
        System.out.println("Generated SQL Query for updateData: " + query);

        connector = connectDB.connectDB();
        prepare = connector.prepareStatement(query.toString());

        // Set the update values
        for (int i = 0; i < values.size(); i++) {
            prepare.setObject(i + 1, values.get(i));
        }

        // Set the condition values
        for (int i = 0; i < conditionValue.size(); i++) {
            prepare.setObject(values.size() + i + 1, conditionValue.get(i));
        }

        prepare.executeUpdate();
        prepare.close();
        connector.close();
    }

    public ObservableList<String[]> pullData(String tableName, List<String> columnNames) {

        if (!doesTableExist(tableName)) {
            System.out.println("Table " + tableName + " does not exist.");
            return null;
        }

        StringBuilder query = new StringBuilder("SELECT ");
        for (int i = 0; i < columnNames.size(); i++) {
            query.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                query.append(", ");
            }
        }
        query.append(" FROM ").append(tableName);
        System.out.println("Generated SQL Query for pullData: " + query);


        connector = connectDB.connectDB();
        if (connector != null) {
            try {
                Statement statement = connector.createStatement();
                ResultSet resultSet = statement.executeQuery(query.toString());

                List<String[]> rows = new ArrayList<>();
                while (resultSet.next()) {
                    String[] row = new String[columnNames.size()];
                    for (int i = 0; i < columnNames.size(); i++) {
                        row[i] = resultSet.getString(columnNames.get(i));
                    }
                    rows.add(row);
                }
                return FXCollections.observableArrayList(rows);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot connect to the database");
        }
        return null;
    }

    public ObservableList<String[]> pullData(String tableName, List<String> columnNames, List<String> condition, List<String> conditionValue) {

        if (!doesTableExist(tableName)) {
            System.out.println("Table " + tableName + " does not exist.");
            return null;
        }

        StringBuilder query = new StringBuilder("SELECT ");
        for (int i = 0; i < columnNames.size(); i++) {
            query.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                query.append(", ");
            }
        }
        query.append(" FROM ").append(tableName);

        if (!condition.isEmpty()) {
            query.append(" WHERE ");
            for (int i = 0; i < condition.size(); i++) {
                query.append(condition.get(i));
                query.append(" = ?");
                if (i < condition.size() - 1) {
                    query.append(" AND ");
                }
            }
        }

        System.out.println("Generated SQL Query for pullData: " + query + " with condition values: " + conditionValue.get(0));

        connector = connectDB.connectDB();
        if (connector != null) {
            try {
                PreparedStatement prepare = connector.prepareStatement(query.toString());

                for (int i = 0; i < conditionValue.size(); i++) {
                    prepare.setObject(i + 1, conditionValue.get(i));
                }

                ResultSet resultSet = prepare.executeQuery();

                List<String[]> rows = new ArrayList<>();
                while (resultSet.next()) {
                    String[] row = new String[columnNames.size()];
                    for (int i = 0; i < columnNames.size(); i++) {
                        row[i] = resultSet.getString(columnNames.get(i));
                    }
                    rows.add(row);
                }

                return FXCollections.observableArrayList(rows);


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot connect to the database");
        }
        return null;
    }

    public void deleteData(String tableName, List<String> condition, List<Object> conditionValue) throws SQLException {
        StringBuilder query = new StringBuilder("DELETE FROM " + tableName);

        if (!condition.isEmpty()) {
            query.append(" WHERE ");
            for (int i = 0; i < condition.size(); i++) {
                query.append(condition.get(i) + " = ?");
                if (i < condition.size() - 1) {
                    query.append(" AND ");
                }
            }
        }
        System.out.println("Generated SQL Query for delete: " + query);

        for (int i = 0; i < conditionValue.size(); i++) {
            System.out.println("Condition values: " + conditionValue.get(i));
        }

        connector = connectDB.connectDB();
        prepare = connector.prepareStatement(query.toString());

        // Set the condition values
        for (int i = 0; i < conditionValue.size(); i++) {
            prepare.setObject(i + 1, conditionValue.get(i));
        }

        prepare.executeUpdate();
        prepare.close();
        connector.close();

    }

    public boolean checkAccount(String username, String password) throws SQLException {
        String query = "SELECT * FROM `signin_users` WHERE BINARY username = ? AND password = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, username);
                prepare.setString(2, password);

                result = prepare.executeQuery();

                if (result.next()) {
                    return true;
                } else {
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

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, username);

                result = prepare.executeQuery();

                if (result.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean checkAccount(String username, String question, String answer) throws SQLException {
        String query = "SELECT username, question, answer "
                + "FROM `signin_users` WHERE BINARY username = ? AND BINARY question = ? AND BINARY answer = ?";

        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, username); // Make sure this is case-sensitive
                prepare.setString(2, question);
                prepare.setString(3, answer);

                result = prepare.executeQuery();

                if (result.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean checkUsername(String username) throws SQLException {
        String query = "SELECT username FROM signin_users WHERE BINARY username = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, username);

                result = prepare.executeQuery();

                return result.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean checkPassword(String username, String password) throws SQLException {
        String query = "SELECT username FROM signin_users WHERE BINARY username = ? AND BINARY password = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, username);
                prepare.setString(2, password);

                result = prepare.executeQuery();

                return result.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private boolean doesTableExist(String tableName) {
        String query = "SELECT * FROM information_schema.tables WHERE table_schema = 'erminoairlines' AND table_name = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, tableName);

                result = prepare.executeQuery();

                return result.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public double monthlyEarnings() {
        String query = "SELECT SUM(price) FROM `sales` WHERE MONTH(payment_date) = MONTH(CURRENT_DATE()) AND YEAR(payment_date) = YEAR(CURRENT_DATE())";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return 0;
        } else {
            try {
                prepare = connector.prepareStatement(query);

                result = prepare.executeQuery();

                if (result.next()) {
                    return result.getDouble(1);
                } else {
                    return 0;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public int monthlyFlightCount() {
        String query = "SELECT COUNT(price) FROM `sales` WHERE MONTH(payment_date) = MONTH(CURRENT_DATE()) AND YEAR(payment_date) = YEAR(CURRENT_DATE())";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return 0;
        } else {
            try {
                prepare = connector.prepareStatement(query);

                result = prepare.executeQuery();

                if (result.next()) {
                    return result.getInt(1);
                } else {
                    return 0;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public boolean checkSeats(String seatNo, String origin, String destination) throws SQLException {
        String query = "SELECT seat  FROM `booked_flights` WHERE seat = ? AND origin = ? AND destination = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, seatNo);
                prepare.setString(2, origin);
                prepare.setString(3, destination);

                result = prepare.executeQuery();

                if (result.next()) {
                    //System.out.println("Seat is booked at: " + seatNo);
                    connector.close();
                    return true;
                } else {
                    //System.out.println("No Seat is booked at: " + seatNo);
                    connector.close();
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean checkSeats(String seatNo, String seatClass ) throws SQLException {
        String query = "SELECT seat  FROM `booked_flights` WHERE seat = ? AND class = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, seatNo);
                prepare.setString(2, seatClass);

                result = prepare.executeQuery();

                if (result.next()) {
                    //System.out.println("Seat is booked at: " + seatNo);
                    connector.close();
                    return true;
                } else {
                    //System.out.println("No Seat is booked at: " + seatNo);
                    connector.close();
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    // Check if flight exists
    public boolean checkFlight(String ticket_no, String last_name) throws SQLException {
        String query = "SELECT ticket_no FROM `booked_flights` WHERE ticket_no = ? AND last_name = ? AND status = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, ticket_no);
                prepare.setString(2, last_name);
                prepare.setString(3, "Booked");


                result = prepare.executeQuery();

                if (result.next()) {
                    //System.out.println("Flight exists: " + flight_no);
                    connector.close();
                    return true;
                } else {
                    //System.out.println("Flight does not exist: " + flight_no);
                    connector.close();
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    // This check if the flight was booked
    public int flightCount(String origin, String destination) {
        String query = "SELECT COUNT(flight_id) FROM `booked_flights` WHERE origin = ? AND destination = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return 0;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, origin);
                prepare.setString(2, destination);

                result = prepare.executeQuery();

                if (result.next()) {
                    return result.getInt(1);
                } else {
                    return 0;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public boolean isFlightUnique(String destination, String origin) throws SQLException {
        String query = "SELECT flight_id FROM `booked_flights` WHERE destination = ? AND origin = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return false;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, destination);
                prepare.setString(2, origin);

                result = prepare.executeQuery();

                if (result.next()) {
                    //System.out.println("Flight exists: " + flight_no);
                    connector.close();
                    return true;
                } else {
                    //System.out.println("Flight does not exist: " + flight_no);
                    connector.close();
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    public String getFlightID(String destination, String origin) {
        String query = "SELECT flight_id FROM `booked_flights` WHERE destination = ? AND origin = ?";
        connector = connectDB.connectDB();

        if (connector == null) {
            System.out.println("Cannot connect to the database.");
            return null;
        } else {
            try {
                prepare = connector.prepareStatement(query);
                prepare.setString(1, destination);
                prepare.setString(2, origin);

                result = prepare.executeQuery();

                if (result.next()) {
                    return result.getString(1);
                } else {
                    return null;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }


}
