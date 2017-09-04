package src.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import src.main.*;

public class TesteStringCamelCase {

	String stringInput;
	ArrayList<String> stringOutput;
	
	@Before
	public void limpaStrings() {
		stringInput = "";
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
	
	@Test
	public void umaPalavra() {
		stringInput = "nome";
		
		stringOutput = StringCamelCase.converter(stringInput);
		
		assertEquals(1, stringOutput.size());
		assertEquals("nome", stringOutput.get(0));
	}
	
	@Test
	public void umaPalavraMaiuscula() {
		stringInput = "Nome";
		
		stringOutput = StringCamelCase.converter(stringInput);
		
		assertEquals(1, stringOutput.size());
		assertEquals("nome", stringOutput.get(0));
	}
	
	@Test
	public void duasPalavras() {
		stringInput = "nomeComposto";
		
		stringOutput = StringCamelCase.converter(stringInput);
		
		assertEquals(2, stringOutput.size());
		assertEquals("nome", stringOutput.get(0));
		assertEquals("composto", stringOutput.get(1));
	}
	
	@Test
	public void siglaSozinha() {
	    stringInput = "CPF";
	    
	    stringOutput = StringCamelCase.converter(stringInput);
	    
	    assertEquals(1, stringOutput.size());
	    assertEquals("CPF", stringOutput.get(0));
	}
	
	@Test
	public void palavraComSigla() {
	    stringInput = "numeroCPFContribuinte";
	    
	    stringOutput = StringCamelCase.converter(stringInput);
	    
	    assertEquals(3, stringOutput.size());
	    assertEquals("numero", stringOutput.get(0));
	    assertEquals("CPF", stringOutput.get(1));
	    assertEquals("contribuinte", stringOutput.get(2));
	}

}
