import java.io.Serializable;

public class cuenta implements Serializable{
    public int id;
    public double saldo;
    public String tipo;
    public String fecha;
    public int propietario;

    public cuenta(int id, double saldo, String tipo, String fecha, int propietario) {
        this.id = id;
        this.saldo = saldo;
        this.tipo = tipo;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }
    
    
    
    
}
