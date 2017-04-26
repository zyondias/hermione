package zyon.herminone.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zyon.herminone.vo.LogLine;

/**
 * Class responsavel por ler o arquivo de log e retornar a lista de objeto de
 * cada registro
 * 
 * @author zyondias
 *
 */
public class ReadLog {

	public List<LogLine> execute(String path) {
		List<LogLine> logLines = new ArrayList<>();
		try {
			BufferedReader bfFile = new BufferedReader(new FileReader(path));
			
			bfFile.lines().forEach(line -> 
				logLines.add(parseLineToObject(line))
			);
			
			bfFile.close();
		} catch (FileNotFoundException e) {
			System.err.println("OPS alguma coisa deu errado na leitura do arquivo: "+ path);
		} catch (IOException e) {
			System.err.println("Ops algum problema na hora de fechar o arquivo, mas ele foi processado");
		}
		return logLines;
	}
	
	private LogLine parseLineToObject(String line){
		LogLine logLine = new LogLine();
		return logLine;
	}
}
