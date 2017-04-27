package zyon.herminone.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import zyon.herminone.vo.LogLine;

public class UrlRequestCalcTest {

	@Test
	public void retorna3ItemNoMapaMesmoTendoMaisChaves() {
		// give
		List<LogLine> logs = generateLogs();

		// when
		UrlRequestCalc urlRequestCalc = new UrlRequestCalc();
		Map<String, Integer> resultMap = urlRequestCalc.topThreeUrl(logs);

		// then
		Assert.assertEquals(3, resultMap.size());
	}

	@Test
	public void os3ComMaisAcessos() {
		// give
		List<LogLine> logs = generateLogs();

		// when
		UrlRequestCalc urlRequestCalc = new UrlRequestCalc();
		Map<String, Integer> resultMap = urlRequestCalc.topThreeUrl(logs);

		// then
		Assert.assertEquals(4, resultMap.get("pagina5").intValue());
		Assert.assertEquals(3, resultMap.get("pagina2").intValue());
		Assert.assertEquals(2, resultMap.get("pagina1").intValue());
	}

	private List<LogLine> generateLogs() {
		LogLine log9 = new LogLine();
		log9.setUrlRequest("pagina2");

		LogLine log10 = new LogLine();
		log10.setUrlRequest("pagina2");

		LogLine log11 = new LogLine();
		log11.setUrlRequest("pagina1");
		
		LogLine log5 = new LogLine();
		log5.setUrlRequest("pagina5");

		LogLine log6 = new LogLine();
		log6.setUrlRequest("pagina5");

		LogLine log7 = new LogLine();
		log7.setUrlRequest("pagina5");

		LogLine log8 = new LogLine();
		log8.setUrlRequest("pagina5");

		
		LogLine log1 = new LogLine();
		log1.setUrlRequest("pagina1");

		LogLine log2 = new LogLine();
		log2.setUrlRequest("pagina2");

		LogLine log3 = new LogLine();
		log3.setUrlRequest("pagina3");

		LogLine log4 = new LogLine();
		log4.setUrlRequest("pagina4");
		

		return Arrays.asList(log1, log2, log3, log4, log5, log6, log7, log8, log9, log10, log11);
	}
}
