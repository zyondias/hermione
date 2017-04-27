package zyon.herminone.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import zyon.herminone.vo.LogLine;

/**
 * Class responsavel por fazer os calculos para as chamadas em determinadas urls
 * 
 * @author zyondias
 *
 */
public class UrlRequestCalc {

	/**
	 * 
	 * @param logs
	 * @return Mapa com as 3 urls mais chamadas e o numero de requisição que
	 *         elas tiveram
	 */
	public Map<String, Integer> topThreeUrl(List<LogLine> logs) {

		Map<String, Integer> map = new HashMap<>();
		
		
		logs.forEach(log -> MapCounter.count(map, log.getUrlRequest()));
		
		// fazendo stream para gerar o map final
		return map.entrySet().stream()
					// ordenando pelo valor do mapa de modo que o maior valor se mantenha 
			       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			       // limitando para que o mapa so tenha 3 itens
			       .limit(3)
			       // fechando o stream criando um mapa
			       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

}
