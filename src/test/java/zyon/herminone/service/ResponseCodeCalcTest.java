package zyon.herminone.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import zyon.herminone.vo.LogLine;

public class ResponseCodeCalcTest {

	@Test
	public void dveFazerOsCountsCorretamente(){
		// give
		List<LogLine> logs = generateLogs();
		
		// when
		ResponseCodeCalc responseCodeCalc = new ResponseCodeCalc();
		Map<String, Integer> resultMap = responseCodeCalc.total(logs);
		
		// then 
		Assert.assertEquals(3, resultMap.get("200").intValue());
	}

	private List<LogLine> generateLogs() {
		LogLine log1 = new LogLine();
		log1.setResponseCode("200");
		
		LogLine log2 = new LogLine();
		log2.setResponseCode("300");
		
		LogLine log3 = new LogLine();
		log3.setResponseCode("200");
		
		LogLine log4 = new LogLine();
		log4.setResponseCode("300");
		
		LogLine log5 = new LogLine();
		log5.setResponseCode("200");
		
		return Arrays.asList(log1, log2, log3, log4, log5);
	}
	
}
