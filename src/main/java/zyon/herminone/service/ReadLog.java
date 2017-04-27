package zyon.herminone.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zyon.herminone.util.RegexUtil;
import zyon.herminone.vo.LogLine;

/**
 * Class responsavel por ler o arquivo de log e retornar a lista de objeto de
 * cada registro
 * 
 * @author zyondias
 *
 */
public class ReadLog {

	private static final String RESPONSE_STATUS_REGEX = ".*response_status=\"(.*)\"";
	private static final String REQUEST_TO_REGEX = ".*request_to=\"(.*)\" ";

	/**
	 * 
	 * @param path
	 * @return List com todas as linhas de log no objeto {@link LogLine}
	 */
	public List<LogLine> execute(String path) {
		List<LogLine> logLines = new ArrayList<>();
		
		try(BufferedReader bfFile = new BufferedReader(new FileReader(path))){
			// interando as linhas do arquivo de log
			bfFile.lines().forEach(line -> 
				// fazendo o parse da linha do log para objeto e jogando em um array
				logLines.add(parseLineToObject(line))
			);
		} catch (FileNotFoundException e) {
			System.err.println("OPS alguma coisa deu errado na leitura do arquivo: "+ path);
		} catch (IOException e) {
			System.err.println("Ops algum problema na hora de fechar o arquivo, mas ele foi processado");
		}
		
		return logLines;
	}
	
	private LogLine parseLineToObject(String line){
		LogLine logLine = new LogLine();
		
		logLine.setResponseCode(RegexUtil.getMatcherGroupOne(line, RESPONSE_STATUS_REGEX));
		
		logLine.setUrlRequest(RegexUtil.getMatcherGroupOne(line, REQUEST_TO_REGEX));
		
		return logLine;
	}
}
