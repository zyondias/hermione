package zyon.herminone.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MapCounterTest {

	@Test
	public void inicializaChaveQuandoNaoExisteComUm(){
		// give
		Map<String, Integer> map = new HashMap<>();
		
		// when
		map = MapCounter.count(map, "zyon");
		
		// then
		Assert.assertEquals(1, map.get("zyon").intValue());
		
	}
	
	@Test
	public void somaMais1QuandoChaveJaExiste(){
		// give
		Map<String, Integer> map = new HashMap<>();
		map.put("zyon", 4);
		// when
		map = MapCounter.count(map, "zyon");
		
		// then
		Assert.assertEquals(5, map.get("zyon").intValue());
		
	}
}
