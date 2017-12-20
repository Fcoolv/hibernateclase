package es.altair.hibernate.main;

import java.util.Scanner;

import es.altair.hibernate.util.Leer;

public class App 
{   
	private static Scanner sc = new Scanner(System.in);
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
                try {
                opcion1=sc.nextInt();
                }catch (Exception e) {
        			System.out.println("No has introducido un numero.");
        			hayError = true;
        		}if(hayError) {
        			return;
        		}else {
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
