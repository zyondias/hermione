package zyon.herminone.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import zyon.herminone.vo.LogLine;

public class ReadLogTest {

	private ReadLog readLog;

	@Before
	public void init() {
		this.readLog = new ReadLog();
	}

	@Test
	public void deveLerTodasLinhasDeLog() {
		// give
		String path = "src/test/resources/log-teste.txt";

		// when
		int result = readLog.execute(path).size();

		// then
		Assert.assertEquals(2, result);

	}

	@Test
	public void devePegarOsValoresDeResponseCodeCorretamente() {
		// give
		String path = "src/test/resources/log-teste.txt";

		// when
		List<LogLine> result = readLog.execute(path);
		
		// then 
		Assert.assertEquals("200", result.get(0).getResponseCode());
		Assert.assertEquals("500", result.get(1).getResponseCode());
	}
}
