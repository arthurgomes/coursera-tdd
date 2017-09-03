package src.main;

public class StringCamelCase {

	public static String converter(String string)
	{
		if(!Character.isAlphabetic(string.charAt(0))) {
			throw new StringInvalidaException("String de entrada invalida!");
		}
		else if(!string.matches("[a-zA-Z0-9 ]*")) {
			throw new StringInvalidaException("String de entrada invalida!");
		}
		
		return string;
	}

}
