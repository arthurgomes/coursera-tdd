package src.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.main.*;

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
	
	@Test(expected=StringInvalidaException.class)
	public void stringComNumeroInvalida() {
		stringInput = "10StringComNumero";
		
		stringOutput = StringCamelCase.converter(stringInput);
	}
	
	@Test(expected=StringInvalidaException.class)
	public void stringComEspecialInvalida() {
		stringInput = "String_Com#caracter!?Especial";
		
		stringOutput = StringCamelCase.converter(stringInput);
	}

}
