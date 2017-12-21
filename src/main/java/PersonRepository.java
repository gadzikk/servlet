import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public interface PersonRepository {

    List<Person> getAll(PreparedStatement stmt) throws SQLException;
    Person getById(PreparedStatement stmt, Parameters params) throws SQLException;
}
