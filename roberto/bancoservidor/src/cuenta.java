
import java.io.Serializable;
import java.sql.Date;


public class cuenta implements Serializable{
    int id;
    double saldo;
    String tipo;
    Date fechaa;
    int propietario;

    public cuenta() {
    }
    
    

    public cuenta(int id, double saldo, String tipo, Date fechaa, int propietario) {
        this.id = id;
        this.saldo = saldo;
        this.tipo = tipo;
        this.fechaa = fechaa;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaa() {
        return fechaa;
    }

    public void setFechaa(Date fechaa) {
        this.fechaa = fechaa;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }
    
    
}
