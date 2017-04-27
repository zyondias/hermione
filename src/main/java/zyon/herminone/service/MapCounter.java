package zyon.herminone.service;

import java.util.Map;

/**
 * Class responsavel por criar um contador dentro de um mapa
 * 
 * @author zyondias
 *
 */
public class MapCounter {

	public static Map<String, Integer> count(Map<String, Integer> map, String key) {
		
		map.put(key, map.getOrDefault(key, 0 ) +1);
		
		return map;
	}
}
