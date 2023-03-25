package hotel.management.system;

import java.sql.*;

public class Conn {

    Connection conn=null;
    Statement s=null;

    Conn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "root");
            s = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
