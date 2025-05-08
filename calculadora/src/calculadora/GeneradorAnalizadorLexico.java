package calculadora;

public class GeneradorAnalizadorLexico {

	public static void main(String[] args) {

		String directorioProyecto = System.getProperty("user.dir");
		String paquete = GeneradorAnalizadorLexico.class.getPackageName();
		String nombreFicheroEspecificacionJFlex = "calculadora.flex";
		String separador = System.getProperty("file.separator");
		String pathFicheroEspecificacionJFlex = directorioProyecto + separador + "src" + separador + paquete + separador
				+ nombreFicheroEspecificacionJFlex;

		String[] ruta = { pathFicheroEspecificacionJFlex };
		try {
			jflex.Main.generate(ruta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
