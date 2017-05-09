import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MovieJDBCTemplate implements MovieDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   public void create(String title, Integer year) {
      String SQL = "insert into Movie (title, year) values (?, ?)";
      jdbcTemplateObject.update( SQL, title, year);
      System.out.println("Created Record Title = " + title + " Year = " + year);
     // return;
   }
   public Movie getMovie(Integer id) {
      String SQL = "select * from Movie where id = ?";
      Movie movie = jdbcTemplateObject.queryForObject(SQL, 
         new Object[]{id}, new MovieMapper());
      
      return movie;
   }
   public List<Movie> listMovies() {
      String SQL = "select * from Movie";
      List <Movie> movies = jdbcTemplateObject.query(SQL, new MovieMapper());
      return movies;
   }
   public void delete(Integer id) {
      String SQL = "delete from Movie where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }
   public void update(Integer id, Integer year){
      String SQL = "update Movie set year = ? where id = ?";
      jdbcTemplateObject.update(SQL, year, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }
}