import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper<Movie> {
   public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
      Movie movie = new Movie();
      movie.setId(rs.getInt("id"));
      movie.setTitle(rs.getString("title"));
      movie.setYear(rs.getInt("year"));
      
      return movie;
   }
}