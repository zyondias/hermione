package zyon.herminone.view;

import java.util.Map;

/**
 * Class para exibir o mapa 
 * @author zyondias
 *
 */
public class ShowMap {

	public static void print(String label, Map<String, Integer> map){
		
		System.out.println(label);
		
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
	}
}
