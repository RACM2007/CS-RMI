
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportManager {
    
    public JasperPrint getReport(String reportname, Map<String, Object> parameters) {
        JasperReport report = null;
        JasperPrint print = null;
        try {
            if (parameters == null) {
                parameters = new HashMap<String, Object>();
            }
            
            parameters.put("SUBREPORT_DIR",this.getClass().getResource("/reportes/").toString());
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/" + reportname + ".jasper"));
            print = JasperFillManager.fillReport(report, parameters, new ConexionDB(Parametros.HOST_DB, Parametros.PORT_DB, Parametros.USER, Parametros.PASS, Parametros.BD, true).getConnection());
        } catch (JRException ex) {
            ex.printStackTrace();
        }
        
        return print;
    }
}
