package zyon.herminone.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Util para fazer os match das regex
 * @author zyondias
 *
 */
public class RegexUtil {
	
	/**
	 * 
	 * @param text
	 * @param pattern
	 * @return Primeiro group encontrado do matcher
	 */
	public static String getMatcherGroupOne(String text, String regex){
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		if(matcher.find()){
			return matcher.group(1);
		}
		
		return null;
	}

}
