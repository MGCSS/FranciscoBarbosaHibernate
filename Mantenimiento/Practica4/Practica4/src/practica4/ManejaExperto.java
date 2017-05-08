
package practica4;

/**
 *
 * @author FranBarbosa
 */
import modelo.*;
import org.hibernate.*; //Con esta línea me ahorro las siguientes
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class ManejaExperto {
    
    private Transaction tx;
    private Session sesion;
    
    
    public ManejaExperto() {}
    
    
    public void inicioOperacion() throws HibernateException
    {
        System.out.println(" *Comienza Hibernate* ");
        sesion=HibernateUtil.getSessionFactory().openSession(); //Iniciamos una sesión hibernate
        tx=sesion.beginTransaction(); //comienza la transacción
        
    }
    public void guardaExperto(Experto experto){
        try {
            inicioOperacion();
            sesion.save(experto);
            System.out.println("Experto insertado correctamente");
        } catch (HibernateException he) {
            throw he;
        } finally 
        {
            finalizaOperacion();
        }
    }
    
     public void actualizaExperto(Experto experto){
        try {
            inicioOperacion();
            sesion.update(experto);
            System.out.println("Experto actualizado correctamente");
        } catch (HibernateException he) {
            throw he;
        } finally 
        {
            finalizaOperacion();
        }
    }
    public void eliminaExperto(Experto experto) {
        try {
            inicioOperacion();
            sesion.delete(experto);
            System.out.println("Experto borrado correctamente");
        } catch (HibernateException he) {
            throw he;
        } finally 
        {
            finalizaOperacion();
        }
    }
   
    public Experto obtenExperto(String idExperto){
        try {
            inicioOperacion();
            return (Experto) sesion.get(Experto.class, idExperto);
        } catch (HibernateException he) {
            throw he;
        } finally {
            finalizaOperacion();
        }
    }
    
   
    
    public void listaConParametro(String keyword){
        try {
            inicioOperacion();
            
            String hql = "FROM Experto e WHERE e.especialidad =: es";
            Query query = sesion.createQuery(hql);
            query.setParameter("es", keyword);
            
            List<Experto> expertos = query.list();
        
        for(Experto exp: expertos)
            System.out.println("Nombre: " + exp.getNombre());
            
        } catch (HibernateException he) {
            throw he;
        } finally {
            finalizaOperacion();
        }
    }
    
   
    public void obtenCasos(){
        try {
            inicioOperacion();
                String queryString = "SELECT DISTINCT e.nombre, cp.nombre FROM caso_policial cp"
                        +" INNER JOIN colabora c INNER JOIN experto e";
                Query query = sesion.createSQLQuery(queryString);
                List<Object[]> listaCasos = query.list();
                
                for(int i = 0 ; i < listaCasos.size() ; i++){
                    
            System.out.println("Nombre: "+listaCasos.get(i)[0] + " -> Caso: " + listaCasos.get(i)[1]);
            
                }
            
        } catch (HibernateException he) {
            throw he;
        } finally {
            finalizaOperacion();
        }
    }
    
   
      public void obtenNombresyEspecialidad() {
        try {
            inicioOperacion();
            Query query = sesion.createQuery("SELECT e.nombre, e.especialidad FROM Experto as e");
            
            List<Experto> expertos = query.list();
        
        for(Experto e: expertos)
            System.out.println("Nombre: "+e.getNombre()+" -> Especialidad: "+e.getEspecialidad());
            }
         catch (HibernateException he) {
            throw he;
        } finally {
            finalizaOperacion();
          }
      }
        
     
    public void finalizaOperacion(){
        
        System.out.println(" *Finaliza Hibernate* ");
        tx.commit();
        sesion.close();
        
    }
    
    public void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        System.out.println(" Ocurrió un error en la capa de acceso a datos "+ he.getMessage());
        System.exit(0);
    }
    
}
