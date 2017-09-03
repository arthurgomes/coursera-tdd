package src.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.main.StringCamelCase;

public class TesteStringCamelCase {

	String stringInput;
	String stringOutput;
	
	@Before
	public void limpaStrings() {
		stringInput = "";
		stringOutput = "";
	}
	
	@Test
	public void stringSimplesValida() {
		stringInput = "SimplesString";
		
		stringOutput = StringCamelCase.converter(stringInput);
		
		assertFalse(stringOutput.isEmpty());
	}

}
