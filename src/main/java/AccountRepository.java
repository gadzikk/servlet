import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by gadzik on 16.12.17.
 */
public interface AccountRepository {
    void create();
    void update();
    List<String> getAll(PreparedStatement stmt) throws SQLException;
    String getById(PreparedStatement stmt,Parameters params) throws SQLException;
}
