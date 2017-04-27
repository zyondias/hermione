package zyon.herminone;

import zyon.herminone.manager.ManagerReportLogs;
import zyon.herminone.service.ReadLog;
import zyon.herminone.service.ResponseCodeCalc;
import zyon.herminone.service.UrlRequestCalc;

/**
 * Inicializa as depedencias e inicia o processo
 * @author zyondias
 *
 */
public class App 
{
    public static void main( String[] args ){
        
    	new ManagerReportLogs(new ReadLog(), new ResponseCodeCalc(), new UrlRequestCalc()).run();;
    }
}
