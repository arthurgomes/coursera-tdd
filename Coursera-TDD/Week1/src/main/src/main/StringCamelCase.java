package src.main;

import java.util.ArrayList;

public class StringCamelCase {

	public static ArrayList<String> converter(String original)
	{		
		verificarInput(original);
		
		return separaPalavras(original);
	}
	
	private static boolean verificarInput(final String original) {
		if(!Character.isAlphabetic(original.charAt(0))) {
			throw new StringInvalidaException("String de entrada invalida!");
		}
		else if(!original.matches("[a-zA-Z0-9 ]*")) {
			throw new StringInvalidaException("String de entrada invalida!");
		}
		
		return true;
	}
	
	private static ArrayList<String> separaPalavras(String original){
		ArrayList<String> palavrasSeparadas = new ArrayList<String>();
		
		for (String palavra : original.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])")) {
		    if (palavra.matches("[A-Z]+")) {
		        palavrasSeparadas.add(palavra);
		    }
		    else {
		        palavrasSeparadas.add(palavra.toLowerCase());
		    }
	    }

		return palavrasSeparadas;
	}

}
