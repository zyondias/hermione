package zyon.herminone.manager;

import java.util.List;
import java.util.Map;

import zyon.herminone.service.ReadLog;
import zyon.herminone.service.ResponseCodeCalc;
import zyon.herminone.service.UrlRequestCalc;
import zyon.herminone.vo.LogLine;

/**
 * Class principal onde irá orquestrar a chamadas dos serviços
 * 
 * @author zyondias
 *
 */
public class ManagerReportLogs {
	
	
	
	private static final String PATH_FILE_LOG = "src/main/resources/log.txt";
	private ReadLog readLog;
	private ResponseCodeCalc responseCodeCalc;
	private UrlRequestCalc urlRequestCalc;

	public ManagerReportLogs(ReadLog readLog, ResponseCodeCalc responseCodeCalc, UrlRequestCalc urlRequestCalc){
		 this.readLog = readLog;
		 this.responseCodeCalc = responseCodeCalc;
		 this.urlRequestCalc = urlRequestCalc;
	}

	public void run() {

		// parse do arquivo
		List<LogLine> logs = readLog.execute(PATH_FILE_LOG);
		
		// mapa com os status code
		Map<String, Integer> mapResponseCode = responseCodeCalc.total(logs);
		
		// mapa com as urls
		Map<String, Integer> mapTopThreeUrl = urlRequestCalc.topThreeUrl(logs);

		// exibe urls
		
		// exibe status

	}
}
