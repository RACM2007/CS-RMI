
import java.io.Serializable;
import java.sql.Date;


public class movimientos implements Serializable{
    Integer id;
    double monto;
    Integer usuario;
    String tipo;
    Integer origenc;
    String origene;
    Integer destinoc;
    Date fecha;

    public movimientos() {
    }

    public movimientos(int id, double monto, int usuario, String tipo, int origenc, String origene, int destinoc, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.usuario = usuario;
        this.tipo = tipo;
        this.origenc = origenc;
        this.origene = origene;
        this.destinoc = destinoc;
        this.fecha= fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getOrigenc() {
        return origenc;
    }

    public void setOrigenc(Integer origenc) {
        this.origenc = origenc;
    }

    public String getOrigene() {
        return origene;
    }

    public void setOrigene(String origene) {
        this.origene = origene;
    }

    public Integer getDestinoc() {
        return destinoc;
    }

    public void setDestinoc(Integer destinoc) {
        this.destinoc = destinoc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
