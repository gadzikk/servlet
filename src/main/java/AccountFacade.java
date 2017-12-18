import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 16.12.17.
 */
public class AccountFacade implements AccountRepository {
    public void create() {

    }

    public void update() {

    }

    public String getById(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setLong(1, params.getId());
        String email = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            email = rs.getString("email");
            System.out.println(email);
        }
        rs.close();


        return email;
    }

    public List<String> getAll(PreparedStatement stmt) throws SQLException {
        List<String> list = new ArrayList<String>();

//         sql = "SELECT email FROM  ACCOUNT ";
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String email = rs.getString("email");
            list.add(email);
            System.out.println(email);
        }
        rs.close();
        return list;
    }
}
