package zyon.herminone.service;

import org.junit.Assert;
import org.junit.Test;

public class ReadLogTest {

	@Test
	public void deveLerTodasLinhasDeLog(){
		// give
		String path = "classpath:log-teste.txt";
		// when
		ReadLog readLog = new ReadLog();
		int result = readLog.execute(path).size();
		// then
		Assert.assertEquals(2, result);
		
	}
}
