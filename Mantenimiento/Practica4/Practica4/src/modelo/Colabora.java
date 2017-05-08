package modelo;
// Generated 02-may-2017 19:14:40 by Hibernate Tools 3.6.0



/**
 * Colabora generated by hbm2java
 */
public class Colabora  implements java.io.Serializable {


     private ColaboraId id;
     private Experto experto;
     private CasoPolicial casoPolicial;
     private String descripcionColaboracion;

    public Colabora() {
    }

	
    public Colabora(ColaboraId id, Experto experto, CasoPolicial casoPolicial) {
        this.id = id;
        this.experto = experto;
        this.casoPolicial = casoPolicial;
    }
    public Colabora(ColaboraId id, Experto experto, CasoPolicial casoPolicial, String descripcionColaboracion) {
       this.id = id;
       this.experto = experto;
       this.casoPolicial = casoPolicial;
       this.descripcionColaboracion = descripcionColaboracion;
    }
   
    public ColaboraId getId() {
        return this.id;
    }
    
    public void setId(ColaboraId id) {
        this.id = id;
    }
    public Experto getExperto() {
        return this.experto;
    }
    
    public void setExperto(Experto experto) {
        this.experto = experto;
    }
    public CasoPolicial getCasoPolicial() {
        return this.casoPolicial;
    }
    
    public void setCasoPolicial(CasoPolicial casoPolicial) {
        this.casoPolicial = casoPolicial;
    }
    public String getDescripcionColaboracion() {
        return this.descripcionColaboracion;
    }
    
    public void setDescripcionColaboracion(String descripcionColaboracion) {
        this.descripcionColaboracion = descripcionColaboracion;
    }




}


