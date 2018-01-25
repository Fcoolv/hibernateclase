package es.altair.hibernate.main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mysql.cj.core.conf.ModifiableStringProperty;

import es.altair.hibernate.bean.EquipoJuego;
import es.altair.hibernate.bean.Equipos;
import es.altair.hibernate.bean.Juegos;
import es.altair.hibernate.bean.TiposJuego;
import es.altair.hibernate.bean.jugadores;
import es.altair.hibernate.dao.EquipoDAO;
import es.altair.hibernate.dao.EquipoDAOImpHibernate;
import es.altair.hibernate.dao.EquipoJuegoDAO;
import es.altair.hibernate.dao.EquipoJuegoDAOImpHibernate;
import es.altair.hibernate.dao.JuegosDAO;
import es.altair.hibernate.dao.JuegosDAOImpHibernate;
import es.altair.hibernate.dao.JugadoresDAO;
import es.altair.hibernate.dao.JugadoresDAOImpHibernate;
import es.altair.hibernate.dao.TipoDAO;
import es.altair.hibernate.dao.TipoDAOImpHibernate;
import es.altair.hibernate.util.Leer;

public class App 
{   
	private static Scanner sc = new Scanner(System.in);
	private static EquipoDAO eDAO = new EquipoDAOImpHibernate();
	private static JuegosDAO jDAO = new JuegosDAOImpHibernate();
	private static JugadoresDAO juDAO = new JugadoresDAOImpHibernate();
	private static TipoDAO tDAO = new TipoDAOImpHibernate();
	private static EquipoJuegoDAO ejDAO = new EquipoJuegoDAOImpHibernate();
    public static void main( String[] args )
    {
    	int opcion=0;
    	int opcion1 = 0;
        
        do {
        	
        	opcion = menu();
        	
        	switch(opcion) {
        	case 1:
        	do {
        		do {
        			
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.println("\t\t\t\t║                      Equipos                  ║");
                    System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
                    System.out.println("\t\t\t\t║ 1. AÑADIR EQUIPO                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 2. EDITAR EQUIPO                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 3. BORRAR EQUIPO                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 4. LISTAR EQUIPO                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 0. VOLVER                                     ║");
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                System.out.print("Opcion a escoger: ");
                opcion1=Leer.datoInt();
    			}while(opcion1<0||opcion1>4);
        			switch(opcion1) {
        			case 1:			
        				eDAO.save(nuevoEquipo());
        				break;
        			case 2:
        				editEquipo();
        				break;
        			case 3:
        				muestraEquipos();
        				System.out.println("Introduce la id del Equipo a borrar: ");
    					eDAO.delete(Leer.datoInt());
        				break;
        			case 4:
        				muestraEquipos();
        				break;
        				
        			}
        		}while(opcion1!=0);
        		break;
        	case 2:
        	   do {
        		 do {
        			
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.println("\t\t\t\t║                    Jugadores                  ║");
                    System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
                    System.out.println("\t\t\t\t║ 1. AÑADIR JUGADORES                           ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 2. EDITAR JUGADORES                           ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 3. BORRAR JUGADORES                           ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 4. LISTAR JUGADORES                           ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 5. Paginacion de jugadores                    ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 0. VOLVER                                     ║");
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.print("Opcion a escoger: ");
                opcion1=Leer.datoInt();
    			}while(opcion1<0||opcion1>5);
        			switch(opcion1) {
        			case 1:
        				juDAO.save(nuevoJugador());
        				break;
        			case 2:
        				editJugador();
        				break;
        			case 3:
        				muestraJugadores();
        				System.out.println("Introduce la id del Jugador a borrar: ");
    					juDAO.delete(Leer.datoInt());
        				break;
        			case 4:
        				muestraJugadores();
        				break;
        			
        			case 5:
        				System.out.println("Dime una cantidad de paginas");
        				int pag = Leer.datoInt();
        				juDAO.PaginacionJugadores(pag);
        				break;
        			}
        		}while(opcion1!=0);
        		break;
        	case 3:
        		do {
        		 do {
        			
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.println("\t\t\t\t║                      Juegos                   ║");
                    System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
                    System.out.println("\t\t\t\t║ 1. AÑADIR JUEGOS                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 2. EDITAR JUEGOS                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 3. BORRAR JUEGOS                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 4. LISTAR JUEGOS                              ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 0. VOLVER                                     ║");
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                System.out.print("Opcion a escoger: ");
                	opcion1=Leer.datoInt();
    			}while(opcion1<0||opcion1>4);
        			switch(opcion1) {
        			case 1:
        				jDAO.save(nuevoJuego());
        				break;
        			case 2:
        				editJuego();
        				break;
        			case 3:
        				muestraJuegos();
        				System.out.println("Introduce la id del juego a borrar: ");
    					jDAO.delete(Leer.datoInt());
        				break;
        			case 4:
        				muestraJuegos();
        				break;
        			}
        		}while(opcion1!=0);
        		break;
        	case 4:
        		do {
        		 do {
        			
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.println("\t\t\t\t║              Tipos de Juegos                  ║");
                    System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
                    System.out.println("\t\t\t\t║ 1. AÑADIR TIPO                                ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 2. EDITAR TIPO                                ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 3. BORRAR TIPO                                ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 4. LISTAR TIPO                                ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 0. VOLVER                                     ║");
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                System.out.print("Opcion a escoger: ");
                opcion1=Leer.datoInt();
    			}while(opcion1<0||opcion1>4);
        			switch(opcion1) {
        			case 1:
        				tDAO.save(nuevoTipo());
        				break;
        			case 2:
        				editTiposJuegos();
        				break;
        			case 3:
        				muestratipos();
    					System.out.println("Introduce la id del tipo de juego a borrar: ");
    					tDAO.delete(Leer.datoInt());
        				break;
        			case 4:
        				muestratipos();
        				break;
        			}
        		}while(opcion1!=0);
        		break;
        	case 5:
        		do {
           		 do {
           			
                       System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                       System.out.println("\t\t\t\t║            Equipos Con Juegos                 ║");
                       System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
                       System.out.println("\t\t\t\t║ 1. AÑADIR EquipoJuego                         ║");
                       System.out.println("\t\t\t\t║                                               ║");
                       System.out.println("\t\t\t\t║ 2. EDITAR EquipoJuego                         ║");
                       System.out.println("\t\t\t\t║                                               ║");
                       System.out.println("\t\t\t\t║ 3. BORRAR EquipoJuego                         ║");
                       System.out.println("\t\t\t\t║                                               ║");
                       System.out.println("\t\t\t\t║ 4. LISTAR EquipoJuego                         ║");
                       System.out.println("\t\t\t\t║                                               ║");
                       System.out.println("\t\t\t\t║ 0. VOLVER                                     ║");
                       System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                   System.out.print("Opcion a escoger: ");
                   opcion1=Leer.datoInt();
       			}while(opcion1<0||opcion1>4);
           			switch(opcion1) {
           			case 1:
           				nuevoEquipoGrupo();
           				break;
           			case 2:
           				
           				break;
           			case 3:
           				muestraEquipoJuegos();
    					System.out.println("Introduce la id del Equipo Con juego que quieres borrar: ");
    					ejDAO.delete(Leer.datoInt());
           				break;
           			case 4:
           				muestraEquipoJuegos();
           				break;
           			}
           		}while(opcion1!=0);
        	}
        	
        }while(opcion!=0);
    }
    private static int menu() {
		
		int opcion;
		do {
			opcion=0;
            System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
            System.out.println("\t\t\t\t║                      LVP                      ║");
            System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
            System.out.println("\t\t\t\t║ 1. EQUIPOS                                    ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 2. JUGADORES                                  ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 3. JUEGOS                                     ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 4. TIPO DE JUEGOS                             ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 5. Equipos Con Juegos                         ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 0. Salir                                      ║");
            System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
        System.out.print("Opcion a escoger: ");
        opcion=Leer.datoInt();
		}while(opcion<0||opcion>5);
		return opcion;
	}
    //Nuevo Equipo
    private static Equipos nuevoEquipo() {
    	Equipos equipo = new Equipos();
    	boolean validacion = false;
    	
    	System.out.println("añadir Equipo");
		System.out.println();

		do {
			System.out.println("Introducir nombre Del Equipo");
			equipo.setNombre(Leer.dato().trim());
			validacion = Pattern.matches("[A-Za-z]+", equipo.getNombre());
		} while (validacion == false);
		do {
			System.out.println("Introducir pais Del Equipo");
			equipo.setPais(Leer.dato().trim());
			validacion = Pattern.matches("[A-Za-z]+", equipo.getPais());
		} while (validacion == false);
		
    	return equipo;
    }
  //Nuevo Juego
    private static Juegos nuevoJuego() {
    	Juegos juego = new Juegos();
    	boolean validacion = false;
    	
    	System.out.println("añadir Juego");
		System.out.println();

		do {
			System.out.println("Introducir nombre Del Juego");
			juego.setNombre(Leer.dato().trim());
			validacion = Pattern.matches("[A-Za-z]+", juego.getNombre());
		} while (validacion == false);
		
		muestratipos();
		System.out.println("Selecciona un tipo");
		juego.setTipo(tDAO.get(Leer.datoInt()));
		
		do {
			System.out.println("Introducir año de salida Del juego");
			juego.setAnyoCreacion(Leer.dato());
			validacion = Pattern.matches("[0-9]+", juego.getAnyoCreacion());
		} while (validacion == false);
		
		do {
			System.out.println("Introducir empresa que creo el juego");
			juego.setCompayia(Leer.dato());
			validacion = Pattern.matches("[A-Za-z]+", juego.getCompayia());
		} while (validacion == false);
		
    	return juego;
    }
  //Editar un Juego
    private static void editJuego() {
    	Juegos juego = new Juegos();
    	int id;
    	boolean validacion = false;
    	
    	String cambio;
    	int tipo = 0;
    	
    	muestraJuegos();
    	System.out.println("Dime la id del Juego que quieres editar: ");
    	id = Leer.datoInt();
    	juego.setIdJuegos(id);
    	
    	do {
			System.out.println("Introducir nuevo nombre Del Juego o pulsa intro para no cambiarlo");
			cambio = Leer.dato().trim();
			if(cambio.isEmpty()) {
				validacion = true;
				juego.setNombre(jDAO.get(id).getNombre());
			}else {
			juego.setNombre(cambio);
			cambio="";
			validacion = Pattern.matches("[A-Za-z]+", juego.getNombre());
			}
		} while (validacion == false);
    	
    	muestratipos();
		System.out.println("Selecciona un nuevo tipo o pulsa intro para no cambiarlo");
		tipo = Leer.datoInt();
		
		if(tipo==0) {
			juego.setTipo(jDAO.get(id).getTipo());
		}else {
			juego.setTipo(tDAO.get(tipo));
		}
		
		do {
			System.out.println("Introducir nuevo año de salida Del juego o pulsa intro para no cambiarlo");
			cambio = Leer.dato();
			if(cambio.isEmpty()) {
				validacion = true;
				juego.setNombre(jDAO.get(id).getAnyoCreacion());
			}else {
			juego.setAnyoCreacion(cambio);
			cambio="";
			validacion = Pattern.matches("[0-9]+", juego.getAnyoCreacion());
			}
		} while (validacion == false);
		
		do {
			System.out.println("Introducir nueva empresa que creo el juego o pulsa intro para no cambiarlo");
			if(cambio.isEmpty()) {
				validacion = true;
				juego.setNombre(jDAO.get(id).getCompayia());
			}else {
			juego.setCompayia(cambio);
			cambio="";
			validacion = Pattern.matches("[0-9]+", juego.getCompayia());
			}
		} while (validacion == false);
		jDAO.update(juego);
    }
  //Editar un Equipo
    private static void editEquipo() {
    	Equipos equipo = new Equipos();
    	int id;
    	boolean validacion = false;
    	String cambio;
    	muestraEquipos();
    	System.out.println("Dime la id del Equipo que quieres editar: ");
    	id = Leer.datoInt();
    	equipo.setId(id);
    	do {
			System.out.println("Introducir nuevo nombre del equipo o pulsa intro para no cambiarlo");
			cambio = Leer.dato().trim();
			if(cambio.isEmpty()) {
				validacion = true;
				equipo.setNombre(eDAO.get(id).getNombre());
			}
			else {
			equipo.setNombre(cambio);
			cambio="";
			validacion = Pattern.matches("[A-Za-z]+", equipo.getNombre());
			}
		} while (validacion == false);
    	do {
			System.out.println("Introducir nuevo pais del equipo o pulsa intro para no cambiarlo");
			cambio = Leer.dato().trim();
			if(cambio.isEmpty()) {
				validacion = true;
				equipo.setPais(eDAO.get(id).getPais());
			}else {
			equipo.setPais(cambio);
			cambio="";
			validacion = Pattern.matches("[A-Za-z]+", equipo.getPais());
			}
		} while (validacion == false);
    	
    	eDAO.update(equipo);
    	
    }
    //Nuevo Jugador
    private static jugadores nuevoJugador(){
    	jugadores jugador = new jugadores();
    	boolean validacion = false;
    	
    	do {
			System.out.println("Introducir nombre del jugador");
			jugador.setNombre(Leer.dato());
			validacion = Pattern.matches("[A-Za-z]+", jugador.getNombre());
		} while (validacion == false);
		
		do {
			System.out.println("Introducir apellidos del jugador");
			jugador.setApellidos(Leer.dato());
			validacion = Pattern.matches("[A-Za-z]+", jugador.getApellidos());
		} while (validacion == false);
		
		do {
			System.out.println("Introducir nickname del jugador");
			jugador.setNickname(Leer.dato());
			validacion = Pattern.matches("[A-Za-z0-9]+", jugador.getNickname());
		} while (validacion == false);
    	
		muestraEquipos();
		System.out.println("Selecciona un Equipo");
		jugador.setIdEquipo(eDAO.get(Leer.datoInt()));
		
    	return jugador;
    }
    //Editar Jugador
    private static void editJugador(){
    	jugadores jugador = new jugadores();
    	boolean validacion = false;
    	String cambio;
    	int id,equipo = 0;
    	
    	muestraJugadores();
    	System.out.println("Dime la id del jugador que quieres editar: ");
    	id = Leer.datoInt();
    	jugador.setId(id);
    	
    	do {
			System.out.println("Introducir nuevo nombre del jugador o pulsa intro para no cambiarlo");
			cambio = Leer.dato();
			if(cambio.isEmpty()) {
				validacion = true;
				jugador.setNombre(juDAO.get(id).getNombre());
			}else {
			jugador.setNombre(cambio);
			cambio="";
			validacion = Pattern.matches("[A-Za-z]+", jugador.getNombre());
			}
		} while (validacion == false);
		
		do {
			System.out.println("Introducir nuevo apellido del jugador o pulsa intro para no cambiarlo");
			cambio = Leer.dato();
			if(cambio.isEmpty()) {
				validacion = true;
				jugador.setApellidos(juDAO.get(id).getApellidos());
				}else {
				jugador.setApellidos(cambio);
				validacion = Pattern.matches("[A-Za-z]+", jugador.getApellidos());
				cambio="";
			}
		} while (validacion == false);
		
		do {
			System.out.println("Introducir nuevo nickname del jugador o pulsa intro para no cambiarlo");
			cambio = Leer.dato();
			if(cambio.isEmpty()){
				validacion = true;
				jugador.setNickname(juDAO.get(id).getNickname());
			}else {
			jugador.setNickname(cambio);
			validacion = Pattern.matches("[A-Za-z0-9]+", jugador.getNickname());
			cambio="";
			}
		} while (validacion == false);
    	
		muestraEquipos();
		System.out.println("Selecciona un Equipo");
		equipo = Leer.datoInt();
		if(equipo==0)
			jugador.setIdEquipo(juDAO.get(id).getIdEquipo());
		else
			jugador.setIdEquipo(eDAO.get(equipo));
    	juDAO.update(jugador);
    }
    
    // Mostrar Equipos
    private static void muestraEquipos() {
    	List<Equipos> equipos = eDAO.listar();
		for (Equipos item : equipos) {
			System.out.println(item);
			}
		}
 // Mostrar Jugadores
    private static void muestraJugadores() {
    	List<jugadores> jugadores = juDAO.listar();
		for (jugadores item : jugadores) {
			System.out.println(item);
			}
    }
 // Mostrar Juegos
    private static void muestraJuegos() {
    	List<Juegos> juegos = jDAO.listar();
		for (Juegos item : juegos) {
			System.out.println(item);
		}
    }
 // Nuevo Tipo de Juego
    private static TiposJuego nuevoTipo() {
    	TiposJuego tipo = new TiposJuego();
		boolean validacion = false;
		

		System.out.println("añadir tipo de juego");
		System.out.println();

		do {
			System.out.println("Introducir nombre de Tipo");
			tipo.setNombreTipo(Leer.dato().trim());
			validacion = Pattern.matches("[A-Za-z]+", tipo.getNombreTipo());
		} while (validacion == false);

		return tipo;
	}
 // Mostrar Tipos de juegos
    private static void muestratipos() {
    	List<TiposJuego> tipos = tDAO.listar();
		for (TiposJuego item : tipos) {
			System.out.println(item);
		}
    }
  // Editar Tipos de Juegos
    private static void editTiposJuegos() {
    	TiposJuego tipo = new TiposJuego();
    	int id;
    	boolean validacion = false;
    	muestratipos();
    	System.out.println("Dime la id del tipo de juego que quieres editar: ");
    	id = Leer.datoInt();
    	tipo.setId(id);
    	do {
			System.out.println("Introducir nuevo nombre al Tipo");
			tipo.setNombreTipo(Leer.dato().trim());
			validacion = Pattern.matches("[A-Za-z]+", tipo.getNombreTipo());
		} while (validacion == false);
    	
    	tDAO.update(tipo);
    }
    //añadir EquipoGrupo
    private static void nuevoEquipoGrupo() {
    	int idEquipo,idJuego;
    	Equipos equipo;
    	Juegos juego;
    	muestraEquipos();
    	System.out.println("Selecciona un equipo");
    	idEquipo = Leer.datoInt();
    	
    	muestraJuegos();
    	System.out.println("Selecciona un Juego para ese equipo");
    	idJuego = Leer.datoInt();
    	
    	equipo = eDAO.get(idEquipo);
    	juego = jDAO.get(idJuego);
    	
    	equipo.getJuegos().add(juego);
    	juego.getEquipos().add(equipo);
    	
    	eDAO.save(equipo);
    	
    }
    //mostrar equipos juegos
    private static void muestraEquipoJuegos() {
    	List<EquipoJuego> EquipoJuego = ejDAO.listar();
		for (EquipoJuego item : EquipoJuego) {
			System.out.println(item);
		}
    }
}
