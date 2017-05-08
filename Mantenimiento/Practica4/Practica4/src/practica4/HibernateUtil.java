
package practica4;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FranBarbosa
 */

public class HibernateUtil {

    private static final SessionFactory Session_Factory;
    
    static {
         
         try {
            
            Session_Factory = new AnnotationConfiguration().configure().buildSessionFactory();
             
             } catch (Throwable ex) {
            
            System.err.println("¡¡QUE NO VA!! " + ex);
            throw new ExceptionInInitializerError(ex);
          }
     
      }
    
    public static SessionFactory getSessionFactory() {
        
        return Session_Factory;
    }
}
