package calculadora;

public class GeneradorAnalizadorSintactico {

	public static void main(String[] args) {

		String directorioProyecto = System.getProperty("user.dir");
		String paquete = GeneradorAnalizadorSintactico.class.getPackageName();
		String nombreFicheroEspecificacionCUP = "calculadora.cup";
		String separador = System.getProperty("file.separator");
		String pathFicheroEspecificacionCUP = directorioProyecto + separador + "src" + separador + paquete + separador
				+ nombreFicheroEspecificacionCUP;

		String[] opciones = { "-progress", "-dump", pathFicheroEspecificacionCUP };
		try {
			java_cup.Main.main(opciones);

			// MOVER FICHEROS AL PAQUETE
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
