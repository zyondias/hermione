package zyon.herminone.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import zyon.herminone.service.ReadLog;
import zyon.herminone.service.ResponseCodeCalc;
import zyon.herminone.service.UrlRequestCalc;
import zyon.herminone.vo.LogLine;

@RunWith(MockitoJUnitRunner.class)
public class ManagerReportLogsTest {

	@InjectMocks
	private ManagerReportLogs managerReportLogs;

	@Mock
	private ReadLog readLogMock;
	@Mock
	private ResponseCodeCalc responseCodeCalcMock;
	@Mock
	private UrlRequestCalc urlRequestCalcMock;

	@Test
	public void deveChamarOsMetodosDasClassesDeServico() {

		// when
		managerReportLogs.run();

		// then
		Mockito.verify(readLogMock, Mockito.times(1)).execute(Mockito.anyString());
		Mockito.verify(responseCodeCalcMock, Mockito.times(1)).total(Mockito.anyListOf(LogLine.class));
		Mockito.verify(urlRequestCalcMock, Mockito.times(1)).topThreeUrl(Mockito.anyListOf(LogLine.class));
		
		// valida que somente as execuçoes acima podem ser chamadas
		Mockito.verifyNoMoreInteractions(readLogMock, responseCodeCalcMock, urlRequestCalcMock);

	}

	@Test
	public void garanteAOrdemDeChamada() {
		// when
		managerReportLogs.run();
		
		// then
		InOrder inOrder = Mockito.inOrder(readLogMock, responseCodeCalcMock, urlRequestCalcMock);
		
		inOrder.verify(readLogMock).execute(Mockito.anyString());
		inOrder.verify(responseCodeCalcMock).total(Mockito.anyListOf(LogLine.class));
		inOrder.verify(urlRequestCalcMock).topThreeUrl(Mockito.anyListOf(LogLine.class));
		
		inOrder.verifyNoMoreInteractions();
	}

}
