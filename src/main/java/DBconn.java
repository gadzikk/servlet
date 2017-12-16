import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gadzik on 16.12.17.
 */
public class DBconn {
   static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
   static final String USER = "postgres";
   static final String PASS = "postgres";
    static final String DRIVER = "org.postgresql.Driver";

   public static Connection connection(Connection conn,Statement stmt) throws SQLException, ClassNotFoundException {
       Class.forName(DRIVER);
       return DriverManager.getConnection(DB_URL, USER, PASS);
   }
}
