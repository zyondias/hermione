package zyon.herminone.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zyon.herminone.vo.LogLine;

/**
 * Class responsavel por fazer a soma do total de resposta com cada tipo de status
 * @author zyondias
 *
 */
public class ResponseCodeCalc {
	
	/**
	 * Soma o total de cada tipo de status
	 * @param log
	 * @return Mapa com o Status e o total de chamada para ele
	 */
	public Map<String, Integer> total(List<LogLine> logs){
		Map<String, Integer> map = new HashMap<>();
		
		logs.forEach(log -> MapCounter.count(map, log.getResponseCode()));
		
		return map;
	}

}
