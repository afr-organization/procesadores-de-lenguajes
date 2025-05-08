package calculadora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

public class PruebaCalculadora {

	public static void main(String[] args) {

		String directorioProyecto = System.getProperty("user.dir");
		String paquete = PruebaCalculadora.class.getPackageName();
		String nombreFicheroEntrada = "prueba.cal";
		String separador = System.getProperty("file.separator");
		String pathFicheroEntrada = directorioProyecto + separador + "src" + separador + paquete + separador
				+ nombreFicheroEntrada;

		Symbol salidaParser;

		try {
			Reader lector = new BufferedReader(new FileReader(pathFicheroEntrada));

			Scanner analizadorLexico = new Yylex(lector);
			parser analizadorSintactico = new parser(analizadorLexico);

			salidaParser = analizadorSintactico.parse();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
