package util;

public class Parametros {

  private String hostDB;
  private Integer portDB;
  private String nameDB;
  private String userDB;
  private String passDB;
  private Integer portRMI;

  public Parametros() {
  }

  public String getHostDB() {
    return this.hostDB;
  }

  public void setHostDB(String hostDB) {
    this.hostDB = hostDB;
  }

  public Integer getPortDB() {
    return this.portDB;
  }

  public void setPortDB(Integer portDB) {
    this.portDB = portDB;
  }

  public String getNameDB() {
    return this.nameDB;
  }

  public void setNameDB(String nameDB) {
    this.nameDB = nameDB;
  }

  public String getUserDB() {
    return this.userDB;
  }

  public void setUserDB(String userDB) {
    this.userDB = userDB;
  }

  public String getPassDB() {
    return this.passDB;
  }

  public void setPassDB(String passDB) {
    this.passDB = passDB;
  }

   public Integer getPortRMI() {
    return this.portRMI;
  }

  public void setPortRMI(Integer portRMI) {
    this.portRMI = portRMI;
  }

}