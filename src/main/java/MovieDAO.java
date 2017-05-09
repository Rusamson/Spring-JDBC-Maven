
import java.util.List;
import javax.sql.DataSource;

public interface MovieDAO {
   /** 
      * This is the method to be used to initialize
      * database resources ie. connection.
   */
   public void setDataSource(DataSource ds);
   
   /** 
      * This is the method to be used to create
      * a record in the Movie table.
   */
   public void create(String title, Integer year);
   
   /** 
      * This is the method to be used to list down
      * a record from the Movie table corresponding
      * to a passed movie id.
   */
   public Movie getMovie(Integer id);
   
   /** 
      * This is the method to be used to list down
      * all the records from the Movie table.
   */
   public List<Movie> listMovies();
   
   /** 
      * This is the method to be used to delete
      * a record from the Movie table corresponding
      * to a passed movie id.
   */
   public void delete(Integer id);
   
   /** 
      * This is the method to be used to update
      * a record into the Movie table.
   */
   public void update(Integer id, Integer year);
}