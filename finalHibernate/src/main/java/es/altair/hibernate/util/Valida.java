package es.altair.hibernate.util;

public class Valida {

	public static boolean validaPassword(String pass) {

		String contrasena;
		do {

			System.out.println("Repetir contraseña");
			contrasena = Leer.dato();

			if (contrasena.equals(pass)) {
				System.out.println("La contraseña coincide");
				return true;
			} else {
				System.out.println("La contraseña no coincide");
				return false;
			}
		} while (!contrasena.equals(pass));
	}

	public static String passGenerator(int numChar) {

		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String pass = "";
		int num;
		
		for (int i = 0; i < numChar; i++) {
			num = (int)(Math.random() * 35) + 1;
			pass += (caracteres.charAt(num));
		}
		return pass;
	}

}
