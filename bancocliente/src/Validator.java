import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validator {
  
  public static Boolean esEnteroPositivo(String numStr) {
    try {
      Integer number = Integer.parseInt(numStr);
      return number > 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  public static Boolean esEnteroPositivo(JTextField jtf) {
    return esEnteroPositivo(jtf.getText());
  }
  
  public static Boolean esDouble(String numStr) {
    try {
      Double number = Double.parseDouble(numStr);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  public static Boolean esDouble(JTextField jtf) {
    return esDouble(jtf.getText());
  }
  
  public static Boolean esDoubleEnRango(String numStr, Double min, Double max) {
    try {
      Double number = Double.parseDouble(numStr);
      return number >= min && number <= max;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  public static Boolean esDoubleEnRango(JTextField jtf, Double min, Double max) {
    return esDoubleEnRango(jtf.getText(), min, max);
  }
  
  public static Boolean isEmpty(String str) {
    return str.equals("");
  }
  
  public static Boolean isEmpty(JTextField jTextField) {
    return isEmpty(jTextField.getText());
  }
  
  public static Boolean isEmpty(JPasswordField jPasswordField) {
    return isEmpty(new String(jPasswordField.getPassword()));
  }
  
  public static Boolean areEquals(String str1, String str2) {
    return str1.equals(str2);
  }
  
  public static Boolean areEquals(JTextField j1, JTextField j2) {
    return areEquals(j1.getText(), j2.getText());
  }
  
  public static Boolean areEquals(JPasswordField jpf1, JPasswordField jpf2) {
    return areEquals(new String(jpf1.getPassword()), new String(jpf2.getPassword()));
  }
    
}
