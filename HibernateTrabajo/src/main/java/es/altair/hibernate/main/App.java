package es.altair.hibernate.main;

import java.util.Scanner;

import es.altair.hibernate.util.Leer;

public class App 
{   
	private static Scanner sc = new Scanner(System.in);
	private static EquipoDAO eDAO = new EquipoDAOImpHibernate();
	private static JuegosDAO jDAO = new JuegosDAOImpHibernate();
	private static jugadoresDAO juDAO = new jugadoresDAOImpHibernate();
	private static TipoDAO tDAO = new TipoDAOImpHibernate();
    public static void main( String[] args )
    {
    	int opcion=0;
    	int opcion1 = 0;
        boolean hayError = false;
        do {
        	
        	opcion = menu();
        	
        	switch(opcion) {
        	case 1:
        	do {
        		do {
        			hayError = false;
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
        			
		List<Equipo> equipod = eDAO.listar();
		for (Usuario item : equipos) {
			System.out.println(item);
		}
        				break;
        			case 2:
        				
        				break;
        			case 3:
        				
        				break;
        			case 4:
        				
        				break;
        				}
        		
        		}while(opcion1!=0);
        		break;
        	case 2:
        	   do {
        		 do {
        			hayError = false;
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
        				
        				break;
        				}
        		
        		}while(opcion1!=0);
        		break;
        	case 3:
        		do {
        		 do {
        			hayError = false;
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.println("\t\t\t\t║                      Juegos                   ║");
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
        				
        				break;
        				}
        		
        		}while(opcion1!=0);
        		break;
        	case 4:
        		do {
        		 do {
        			hayError = false;
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
        				
        				break;
        			case 2:
        				
        				break;
        			case 3:
        				
        				break;
        			case 4:
        				
        				break;
        			}
        		}while(opcion1!=0);
        		break;
        	case 5:
        		do {
        		 do {
                    System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
                    System.out.println("\t\t\t\t║              Equipos en juegos                ║");
                    System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
                    System.out.println("\t\t\t\t║ 1. AÑADIR Conjunto                            ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 2. EDITAR Conjunto                            ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 3. BORRAR Conjunto                            ║");
                    System.out.println("\t\t\t\t║                                               ║");
                    System.out.println("\t\t\t\t║ 4. LISTAR Conjunto                            ║");
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
        				
        				break;
        				}
        		}while(opcion1!=0);
        		break;
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
            System.out.println("\t\t\t\t║ 5. EQUIPOS CON JUEGOS                         ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 0. Salir                                      ║");
            System.out.println("\t\t\t\t║═══════════════════════════════════════════════║");
        System.out.print("Opcion a escoger: ");
        opcion=Leer.datoInt();
		}while(opcion<0||opcion>5);
		return opcion;
	}
}
