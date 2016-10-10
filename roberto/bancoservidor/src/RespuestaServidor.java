import java.io.Serializable;

public class RespuestaServidor implements Serializable{
  
  public static final String SUCCESS = "success";
  public static final String ERROR = "error";
  
  private String status;
  private String msg;

  public RespuestaServidor() {
  }

  public RespuestaServidor(String status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  public Boolean esExito() {
    return this.status.equals(SUCCESS);
  }
  
  public static RespuestaServidor getExito(String msg) {
    return new RespuestaServidor(SUCCESS, msg);
  }
  
  public static RespuestaServidor getError(String msg) {
    return new RespuestaServidor(ERROR, msg);
  }
  
}