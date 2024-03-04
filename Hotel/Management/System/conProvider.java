package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class conProvider {
    Connection connection;
    Statement statement;

    conProvider() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotelMS";
            String username = "root";
            String passward = "root";
            connection = DriverManager.getConnection(url, username, passward);
            statement=connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

