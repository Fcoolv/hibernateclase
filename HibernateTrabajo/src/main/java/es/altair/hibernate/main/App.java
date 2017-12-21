package es.altair.hibernate.main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import es.altair.hibernate.bean.Equipos;
import es.altair.hibernate.bean.TiposJuego;
import es.altair.hibernate.dao.EquipoDAO;
import es.altair.hibernate.dao.EquipoDAOImpHibernate;
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
        				
		             
        				break;
        			case 2:
        				
        				break;
        			case 3:
        				
        				break;
        			case 4:
        				List<Equipos> equipos = eDAO.listar();
        				for (Equipos item : equipos) {
        					System.out.println(item);
        				}
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
                    System.out.println("\t\t\t\t║ 0. VOLVER                                     ║");
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.print("Opcion a escoger: ");
                opcion1=Leer.datoInt();
    			}while(opcion1<0||opcion1>4);
        			switch(opcion1) {
        			case 1:
        				
        				break;
        			case 2:
        				
        				break;
        			case 3:
        				
        				break;
        			case 4:
        				List<Equipos> equipos = eDAO.listar();
        				for (Equipos item : equipos) {
        					System.out.println(item);
        				}
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
        				
        				break;
        			case 2:
        				
        				break;
        			case 3:
        				
        				break;
        			case 4:
        				List<Equipos> equipos = eDAO.listar();
        				for (Equipos item : equipos) {
        					System.out.println(item);
        				}
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
        				
        				break;
        			case 3:
        				
        				break;
        			case 4:
        				List<TiposJuego> tipos = tDAO.listar();
        				for (TiposJuego item : tipos) {
        					System.out.println(item);
        				}
        				break;
        			}
        		}while(opcion1!=0);
        		break;
        	case 5:
        		
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
            System.out.println("\t\t\t\t║ 0. Salir                                      ║");
            System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
        System.out.print("Opcion a escoger: ");
        opcion=Leer.datoInt();
		}while(opcion<0||opcion>5);
		return opcion;
	}
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
}
