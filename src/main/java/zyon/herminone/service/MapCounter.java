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
		
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
			return map;
		}
		
		map.put(key, 1);
		return map;
	}
}
