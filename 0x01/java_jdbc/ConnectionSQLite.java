import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
    public static void main(String[] args) {
        initConnection();
    }

    static void initConnection(){
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:sqlite_database_2022.db");
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e+"");
        }
    }
}
