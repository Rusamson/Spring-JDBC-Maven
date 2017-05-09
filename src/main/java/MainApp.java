import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
/*
 *  
 * Spring - JDBC by Samson  
 * 
 * 
 */
public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      MovieJDBCTemplate movieJDBCTemplate = 
         (MovieJDBCTemplate)context.getBean("movieJDBCTemplate");
      
      System.out.println("------Records Creation--------" );
      movieJDBCTemplate.create("Finding Dory", 2016);
      movieJDBCTemplate.create("Guardians of the Galaxy", 2017);
      movieJDBCTemplate.create("The Revenant", 2015);

      System.out.println("------Listing Multiple Records--------" );
      List<Movie> students = movieJDBCTemplate.listMovies();
      
      for (Movie record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Title : " + record.getTitle() );
         System.out.println(", Year : " + record.getYear());
      }

      System.out.println("----Updating Record with ID = 2 -----" );
      movieJDBCTemplate.update(2, 2014);

      System.out.println("----Listing Record with ID = 2 -----" );
      Movie movie = movieJDBCTemplate.getMovie(2);
      System.out.print("ID : " + movie.getId() );
      System.out.print(", Title : " + movie.getTitle() );
      System.out.println(", Year : " + movie.getYear());
   }
}