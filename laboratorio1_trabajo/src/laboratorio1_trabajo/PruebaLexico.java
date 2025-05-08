package laboratorio1_trabajo;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaLexico{
	
	public static void main(String[] args) {
		
		String ficheroEntrada, ficheroSalida;
		
		String directorio = "C:\\Users\\f_alb\\eclipse-workspace\\laboratorio1_trabajo\\";
		
		if (args.length != 2) {
			System.out.println("ERROR EN EL NÚMERO DE PARÁMETROS DEL PROGRAMA");
			return;
		}
		
		ficheroEntrada = args[0];
		ficheroSalida = args[1];
		String resultado ="";
		
		try {
		      Reader lector = new BufferedReader(new FileReader(directorio + ficheroEntrada));
		      Scanner scanner = new Scanner(lector);                   
		     
		      while (true) {  
		    	  Tokens token = scanner.yylex();		
		    	  	  	    	  
		    	  if ((token == null) || (token == Tokens.TOK_ERROR)) {	  
		    		  break;
		    	  }
	                
		    	  resultado += token + "\t" + scanner.yytext() + "\n";
	            }
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			FileWriter writer = new FileWriter(directorio + ficheroSalida);
			writer.write(resultado);
			writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}