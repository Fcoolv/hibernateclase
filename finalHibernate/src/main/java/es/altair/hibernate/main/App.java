package es.altair.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import es.altair.hibernate.bean.Acceso;
import es.altair.hibernate.bean.Ordenador;
import es.altair.hibernate.bean.Sala;
import es.altair.hibernate.bean.Usuario;
import es.altair.hibernate.dao.AccesoDAO;
import es.altair.hibernate.dao.AccesoDAOImplHibernate;
import es.altair.hibernate.dao.OrdenadorDAO;
import es.altair.hibernate.dao.OrdenadorDAOImplHibernate;
import es.altair.hibernate.dao.SalaDAO;
import es.altair.hibernate.dao.SalaDAOImplHibernate;
import es.altair.hibernate.dao.UsuarioDAO;
import es.altair.hibernate.dao.UsuarioDAOImplHibernate;
import es.altair.hibernate.util.Leer;
import es.altair.hibernate.util.Valida;

public class App {

	private static AccesoDAO aDAO = new AccesoDAOImplHibernate();
	private static UsuarioDAO uDAO = new UsuarioDAOImplHibernate();
	private static OrdenadorDAO oDAO = new OrdenadorDAOImplHibernate();
	private static SalaDAO sDAO = new SalaDAOImplHibernate();

	public static void main(String[] args) {

		int opcion = 0;
		int opcionDos = 0;
		int opcionTres = 0;
		

		do {
			opcion = menu();

			switch (opcion) {
			case 1:
				// LISTAR USUARIOS ORDENADORES ACCESOS
				do {

					System.out.println(" ____________________________________________");
					System.out.println("|                                            |");
					System.out.println("|- 1 LISTAR USUARIOS                         |");
					System.out.println("|- 2 LISTAR ORDENADORES                      |");
					System.out.println("|- 3 LISTAR ACCESOS                          |");
					System.out.println("|- 0 MENU                                    |");
					System.out.println("|____________________________________________|");
					System.out.println("Opcion numero: ");
					opcionDos = Leer.datoInt();

				} while (opcionDos < 0 || opcionDos > 3);

				if (opcionDos == 1) {

					// LISTADO DE USUARIOS
					mostrarUsuarios();

				} else if (opcionDos == 2) {

					// LISTADO DE ORDENADORES
					do {
						System.out.println(" ____________________________________________");
						System.out.println("|                                            |");
						System.out.println("|- 1 LISTAR TODOS LOS ORDENADORES            |");
						System.out.println("|- 2 LISTAR ORDENADORES POR SALA             |");
						System.out.println("|- 3 LISTAR ORDENADORES ACTIVOS O INACTIVOS  |");
						System.out.println("|- 0 MENU                                    |");
						System.out.println("|____________________________________________|");
						System.out.println("Opcion numero: ");
						opcionTres = Leer.datoInt();

					} while (opcionTres < 0 || opcionTres > 3);

					if (opcionTres == 1) {

						mostrarOrdenadores();

					} else if (opcionTres == 2) {

						System.out.println("LISTAR ORDENADORES POR SALA");
						System.out.println("Introducir numero de sala o pulse 0 para volver al menu: ");
						int num = Leer.datoInt();
						System.out.println();

						if (num != 0) {

							List<Ordenador> pcs = oDAO.listadoPorSala(num);
							for (Ordenador item : pcs) {
								System.out.println(item);
							}
						} else {

							break;
						}

					} else if (opcionTres == 3) {

						int num;

						do {
							System.out.println("LISTAR ORDENADORES ACTIVOS O INACTIVOS");
							System.out.println("Para ver los ordenadores inactivos pulse -> (0)");
							System.out.println("Para ver los ordenadores activos pulse   -> (1)");
							num = Leer.datoInt();
						} while (num < 0 || num > 1);

						if (num != 0) {
							System.out.println("ORDENADORES ACTIVOS");
							List<Ordenador> pcs = oDAO.listadoActivos(true);
							for (Ordenador item : pcs) {
								System.out.println(item);
							}
						} else {
							List<Ordenador> pcs = oDAO.listadoActivos(false);
							for (Ordenador item : pcs) {
								System.out.println(item);
							}
						}
					} else {

						break;
					}

				} else if (opcionDos == 3) {

					// LISTADO DE ACCESOS
					mostrarAccesos();

				}

				break;

			case 2:
				// NUEVO USUARIO ORDENADOR, ACCESO
				do {
					System.out.println(" ____________________________________________");
					System.out.println("|                                            |");
					System.out.println("|- 1 NUEVO USUARIO                           |");
					System.out.println("|- 2 NUEVO ORDENADOR                         |");
					System.out.println("|- 3 NUEVO ACCESO                            |");
					System.out.println("|- 0 MENU                                    |");
					System.out.println("|____________________________________________|");
					System.out.println("Opcion numero: ");

					opcionDos = Leer.datoInt();

				} while (opcionDos < 0 || opcionDos > 3);

				if (opcionDos == 1) {
					// Guardar nuevo Usuario
					uDAO.guardar(nuevoUsuario());

				} else if (opcionDos == 2) {
					// Guardar nuevo Ordenador
					oDAO.guardar(nuevoOrdenador());

				} else if (opcionDos == 3) {
					// Guardar nuevo Acceso
					Acceso acs = nuevoAcceso();
					Ordenador pc = oDAO.obtener(acs.getOrdenador().getIdOrdenador());

					if (aDAO.guardar(acs)) {
						pc.setActivo(true);
						oDAO.editar(pc);
					}
				} 
				
				break;

			case 3:
				// EDITAR/ACTUALIZAR
				do {
					System.out.println(" ____________________________________________");
					System.out.println("|                                            |");
					System.out.println("|- 1 EDITAR USUARIO                          |");
					System.out.println("|- 2 EDITAR ORDENADOR                        |");
					System.out.println("|- 3 EDITAR ACCESO                           |");
					System.out.println("|- 0 MENU                                    |");
					System.out.println("|____________________________________________|");
					System.out.println("Opcion numero: ");

					opcionDos = Leer.datoInt();

				} while (opcionDos < 0 || opcionDos > 3);

				if (opcionDos == 1) {

					// Editar Usuario
					editarUsuario();

				} else if (opcionDos == 2) {

					// Editar Ordenador
					editarOrdenador();

				} else if (opcionDos == 3) {

					// Editar Acceso
					editarAcceso();

				}
				
				break;

			case 4:
				// BORRAR
				do {
					System.out.println(" ____________________________________________");
					System.out.println("|                                            |");
					System.out.println("|- 1 BORRAR USUARIO                          |");
					System.out.println("|- 2 BORRAR ORDENADOR                        |");
					System.out.println("|- 3 BORRAR ACCESO                           |");
					System.out.println("|- 0 MENU                                    |");
					System.out.println("|____________________________________________|");
					System.out.println("Opcion numero: ");

					opcionDos = Leer.datoInt();

				} while (opcionDos < 0 || opcionDos > 3);

				if (opcionDos == 1) {

					// Borrar Usuario
					mostrarUsuarios();
					System.out.println("Introducir ID del Usuario a eliminar: ");
					uDAO.borrar(uDAO.obtener(Leer.datoInt()));

				} else if (opcionDos == 2) {

					// Borrar Ordenador
					List<Ordenador> pcsActivoso = oDAO.listadoActivos(false);
					for (Ordenador item : pcsActivoso) {
						System.out.println(item);
					}

					System.out.println("Introducir ID del Ordenador a eliminar: ");
					oDAO.borrar(oDAO.obtener(Leer.datoInt()));

				} else if (opcionDos == 3) {

					// Borrar Acceso
					mostrarAccesos();
					System.out.println("Introducir ID del Acceso a eliminar: ");
					Acceso acs = aDAO.obtener(Leer.datoInt());

					Ordenador pc = oDAO.obtener(acs.getOrdenador().getIdOrdenador());

					if (aDAO.borrar(acs)) {
						pc.setActivo(false);
						oDAO.editar(pc);
					}
				}
				break;

			default:

				System.out.println("GOODBYE USER");
				break;
			}

		} while (opcion != 0);

	}

	/*
	 * ----------------------------------------------------------------------
	 * -------------------------------------------------------------- METODOS
	 * ----------------------------------------------------------------------
	 */

	public static int menu() {

		int opcion = 0;
		do {
			System.out.println(" ____________________________________________");
			System.out.println("|                                            |");
			System.out.println("|                  CIBERNATE                 |");
			System.out.println("|____________________________________________|");
			System.out.println("|                                            |");
			System.out.println("|- 1 LISTAR                                  |");
			System.out.println("|- 2 NUEVO  USUARIO | ORDENADOR | ACCESO     |");
			System.out.println("|- 3 EDITAR USUARIO | ORDENADOR | ACCESO     |");
			System.out.println("|- 4 BORRAR USUARIO | ORDENADOR | ACCESO     |");
			System.out.println("|- 0 SALIR                                   |");
			System.out.println("|____________________________________________|");
			System.out.println("Opcion numero: ");
			opcion = Leer.datoInt();
		} while (opcion < 0 || opcion > 4);

		return opcion;
	}

	// Mostrar lista de Usuarios
	public static void mostrarUsuarios() {

		System.out.println("LISTADO DE USUARIOS");
		List<Usuario> usuarios = uDAO.listar();
		for (Usuario item : usuarios) {
			System.out.println(item);
		}
	}

	// Mostrar lista de Ordenadores
	public static void mostrarOrdenadores() {

		System.out.println("LISTADO DE ORDENADORES");
		List<Ordenador> pcs = oDAO.listar();
		for (Ordenador item : pcs) {
			System.out.println(item);
		}
	}

	// Mostrar lista de Accesos
	public static void mostrarAccesos() {

		System.out.println("LISTADO DE ACCESOS");
		List<Acceso> accesos = aDAO.listar();
		for (Acceso item : accesos) {
			System.out.println(item);
		}
	}

	// Crear nuevo Usuario
	public static Usuario nuevoUsuario() {

		Usuario usu = new Usuario();
		String entrada;
		boolean valida;

		System.out.println("NUEVO USUARIO");
		System.out.println();

		do {
			System.out.println("Introducir Nombre del Usuario");
			usu.setNombre(Leer.dato().trim());
			valida = Pattern.matches("[A-Za-z]+", usu.getNombre());
		} while (valida == false);

		do {
			System.out.println("Introducir Apellidos del Usuario");
			usu.setApellidos(Leer.dato().trim());
			valida = Pattern.matches("[A-Za-z]+", usu.getApellidos());
		} while (valida == false);

		do {
			System.out.println("Introducir Email del Usuario");
			usu.setEmail(Leer.dato().trim());			
			valida = Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", usu.getEmail());
		} while (valida == false);

		do {
			System.out.println("Introducir Contraseña del Usuario");
			entrada = Leer.dato().trim();
			if (entrada.isEmpty()) {
				usu.setPassword(Valida.passGenerator(8));
			} else {
				if (Valida.validaPassword(entrada)) {
					usu.setPassword(entrada);
				}
			}
		} while (usu.getPassword().isEmpty());

		usu.setFechaRegistro(new Date());

		return usu;

	}

	// Crear nuevo Ordenador
	private static Ordenador nuevoOrdenador() {

		Ordenador pc = new Ordenador();
		boolean valida = false;

		System.out.println("NUEVO ORDENADOR");
		System.out.println();

		do {
			System.out.println("Introducir numero de IP del Ordenador");
			pc.setIpNum(Leer.dato().trim());
			valida = Pattern.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", pc.getIpNum());
		} while (valida == false);

		System.out.println("Introducir el Sistema Operativo del Ordenador");
		pc.setSisOperativo(Leer.dato().trim());

		do {
			List<Sala> misSalas = sDAO.listar();
			for (Sala item : misSalas) {
				System.out.println(item);
			}
			System.out.println("* Dejar el campo vacio y pulsar la tecla Intro para crear una nueva Sala *");
			System.out.println("Introducir ID de sala donde estara el Ordenador");
			pc.setSala(sDAO.obtener(Leer.datoInt()));
			if (pc.getSala() == null) {
				sDAO.guardar(nuevaSala());
			}
		} while (pc.getSala() == null);

		return pc;
	}

	// Crear nueva Sala
	private static Sala nuevaSala() {
		Sala sala = new Sala();
		boolean valida = false;
		

		System.out.println("NUEVO SALA");
		System.out.println();

		do {
			System.out.println("Introducir nombre de la Sala");
			sala.setNombre(Leer.dato().trim());
			valida = Pattern.matches("[A-Za-z0-9]+", sala.getNombre());
		} while (valida == false);

		return sala;
	}

	// Crear nuevo Acceso
	private static Acceso nuevoAcceso() {
		Acceso acs = new Acceso();

		Timestamp time = new Timestamp(System.currentTimeMillis());
		Date fecha = new Date(time.getTime());

		System.out.println("NUEVO ACCESO");
		System.out.println();

		do {
			List<Usuario> misUsuarios = uDAO.listar();
			for (Usuario item : misUsuarios) {
				System.out.println(item);
			}

			System.out.println("Introducir ID del Usuario");
			acs.setUsuario(uDAO.obtener(Leer.datoInt()));
		} while (acs.getUsuario() == null);

		do {
			List<Ordenador> misOrdenadores = oDAO.listadoActivos(false);
			for (Ordenador item : misOrdenadores) {
				System.out.println(item);
			}

			System.out.println("Introducir ID del Ordenador");
			acs.setOrdenador(oDAO.obtener(Leer.datoInt()));
			acs.getOrdenador().setActivo(false);
		} while (acs.getOrdenador() == null);

		// Inicializa fechaInicio a la hora actual del sistema
		acs.setFechaInicio(fecha);
		fecha = new Date();

		do {

			System.out.println("Introducir tiempo de sesion del Usuario");
			fecha.setMinutes(acs.getFechaInicio().getMinutes() + Leer.datoInt());
			acs.setFechaFin(fecha);
		} while (acs.getFechaFin() == null);

		return acs;
	}

	// Editar usuario de la Base de Datos
	private static void editarUsuario() {
		
		Usuario usu = new Usuario();
		String entrada;
		int numID;

		mostrarUsuarios();

		System.out.println("EDITAR USUARIO");
		System.out.println();

		System.out.println("Introducir ID del Usuario a editar: ");
		numID = Leer.datoInt();		
		
		// Pasamos el ID del usuario antiguo al nuevo
		usu.setIdUsuario(uDAO.obtener(numID).getIdUsuario());

		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Nombre del Usuario: '" + uDAO.obtener(numID).getNombre() + "'");
		System.out.println("Introducir nuevo nombre: ");
		entrada = Leer.dato().trim();

		if (entrada.isEmpty()) {
			usu.setNombre(uDAO.obtener(numID).getNombre());
		} else {
			usu.setNombre(entrada);
			entrada = "";
		}

		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Apellidos del Usuario: '" + uDAO.obtener(numID).getApellidos() + "'");
		System.out.println("Introducir nuevos Apellidos: ");
		entrada = Leer.dato().trim();

		if (entrada.isEmpty()) {
			usu.setApellidos(uDAO.obtener(numID).getApellidos());
		} else {
			usu.setApellidos(entrada);
			entrada = "";
		}

		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Email del Usuario: '" + uDAO.obtener(numID).getEmail() + "'");
		System.out.println("Introducir nuevo Email: ");
		entrada = Leer.dato().trim();

		if (entrada.isEmpty()) {
			usu.setEmail(uDAO.obtener(numID).getEmail());
		} else {
			usu.setEmail(entrada);
			entrada = "";
		}

		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Password del Usuario: '" + uDAO.obtener(numID).getPassword() + "'");
		System.out.println("Introducir nuevo Password: ");
		entrada = Leer.dato().trim();

		if (entrada.isEmpty()) {
			usu.setPassword(uDAO.obtener(numID).getPassword());
		} else {
			if (Valida.validaPassword(entrada)) {
				usu.setPassword(entrada);
				entrada = "";
			} else {
				usu.setPassword(uDAO.obtener(numID).getPassword());
			}
		}

		usu.setFechaRegistro(uDAO.obtener(numID).getFechaRegistro());

		uDAO.editar(usu);
	}

	// Editar Ordenador de la BD
	private static void editarOrdenador() {

		Ordenador pc = new Ordenador();
		String entrada;
		int numID;
		int num = 0;
		
		mostrarOrdenadores();

		System.out.println("EDITAR ORDENADOR");
		System.out.println();

		System.out.println("Introducir ID del Ordenador a editar: ");
		numID = Leer.datoInt();
		
		// Pasamos el ID del ordenador antiguo al nuevo
		pc.setIdOrdenador(oDAO.obtener(numID).getIdOrdenador());

		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Numero direccion IP: '" + oDAO.obtener(numID).getIpNum() + "'");
		System.out.println("Introducir nueva IP: ");
		entrada = Leer.dato().trim();

		if (entrada.isEmpty()) {
			pc.setIpNum(oDAO.obtener(numID).getIpNum());
		} else {
			pc.setIpNum(entrada);
			entrada = "";
		}

		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Sistema operativo del Ordenador: '" + oDAO.obtener(numID).getSisOperativo() + "'");
		System.out.println("Introducir nuevo sistema operativo en uso: ");
		entrada = Leer.dato().trim();

		if (entrada.isEmpty()) {
			pc.setSisOperativo(oDAO.obtener(numID).getSisOperativo());
		} else {
			pc.setSisOperativo(entrada);
			entrada = "";
		}

		sDAO.listar();
		System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
		System.out.println("Sala donde se encuentra el Ordenador: " + oDAO.obtener(numID).getSala().getIdSala() + "'"
				+ oDAO.obtener(numID).getSala().getNombre() + "'");
		System.out.println("Introducir nueva ubicacion (Sala): ");
		num = Leer.datoInt();

		if (num <= 0) {
			pc.setSala(oDAO.obtener(numID).getSala());
		} else {
			pc.setSala(sDAO.obtener(num));
		}

		oDAO.editar(pc);
	}

	// Editar Acceso de la BD
	private static void editarAcceso() {

		Acceso acs = new Acceso();
		Date fecha;
		int numID = 0;
		int num = 0;

		mostrarAccesos();

		System.out.println("EDITAR ACCESO");
		System.out.println();

		do {
			System.out.println("Introducir ID del Acceso a editar: ");
			numID = Leer.datoInt();
		} while (numID <= 0);

		// Paso el ID al nuevo Acceso
		acs.setIdAcceso(aDAO.obtener(numID).getIdAcceso());

		do {
			mostrarUsuarios();
			System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
			System.out.println("Usuario: '" + aDAO.obtener(numID).getUsuario() + "'");
			System.out.println("Introducir ID del Usuario a cambiar: ");
			num = Leer.datoInt();
		} while (num <= 0);

		if (num <= 0) {
			acs.setUsuario(aDAO.obtener(numID).getUsuario());
		} else {
			acs.setUsuario(uDAO.obtener(num));
		}

		do {
			mostrarOrdenadores();
			System.out.println("* Para omitir cualquier campo, dejar vacio y pulsar la tecla Intro *");
			System.out.println("Ordenador: '" + aDAO.obtener(numID).getOrdenador() + "'");
			System.out.println("Introducir ID del Ordenador a cambiar: ");
			num = Leer.datoInt();
		} while (num <= 0);

		if (num <= 0) {
			acs.setOrdenador(aDAO.obtener(numID).getOrdenador());
		} else {
			acs.setOrdenador(oDAO.obtener(num));
		}

		// Inicializa la fecha de cuando se creo el acceso
		fecha = aDAO.obtener(numID).getFechaInicio();
		acs.setFechaInicio(fecha);
		fecha = new Date();

		do {

			System.out.println("Introducir nuevo tiempo de sesion del Usuario");
			fecha.setMinutes(aDAO.obtener(numID).getFechaInicio().getMinutes() + Leer.datoInt());
			acs.setFechaFin(fecha);

		} while (acs.getFechaFin() == null);

		aDAO.editar(acs);
	}

}
