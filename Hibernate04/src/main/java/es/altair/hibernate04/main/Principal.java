package es.altair.hibernate04.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.altair.hibernate03.bean.Cancion;
import es.altair.hibernate03.bean.Artista;
import es.altair.hibernate03.bean.Estilo;
import es.altair.hibernate04.mean.ArtistaDAO;
import es.altair.hibernate04.mean.ArtistaDAOImpJDBC;
import es.altair.hibernate04.mean.CancionDAO;
import es.altair.hibernate04.mean.CancionDAOImpJDBC;
import es.altair.hibernate04.mean.EstiloDAO;
import es.altair.hibernate04.mean.EstiloDAOImpJDBC;


public class Principal {

	private static Scanner sc= new Scanner(System.in);
	private static ArtistaDAO aDAO = new ArtistaDAOImpJDBC();
	private static EstiloDAO estDAO = new EstiloDAOImpJDBC();
	private static CancionDAO cDAO = new CancionDAOImpJDBC();
	public static void main(String[] args) {
		int opcion=0;
		int opcion1=0;
		do {
        opcion=menu();
        switch (opcion) {
        case 1:
        	System.out.println("Elige:1.Artistas,2.canciones,3.Estilos");
        	try {
        	opcion1 = sc.nextInt();
        	}catch (Exception e) {
				System.out.println("El valor elegido no es el indicado");
			}
        	switch (opcion1) {
        	case 1:
        		insertarArtista();
        		break;
        	case 2:
        		insertarCancion();
            	break;
            case 3:
            	insertarEstilo();
            	
            	break;
        	}
        	break;
        
		case 2:
			listarArtistasEstilo();
			break;
		case 3:
			cancionesArtista();
			break;
		case 4:
			modificarEdad();
			break;
		case 5:
			unMinMas();
			break;
		case 6:
			borrarCanciones();
			break;
		case 7:
			mostrarTodo();
			break;
		default:
			break;
		}
		}while(opcion!=0);
     System.out.println("ADIOS!!!");
	}
	private static void mostrarTodo() {
Artista[] artistas=aDAO.lArtistas();
		
		List<Cancion> canciones=new ArrayList<Cancion>();
		for (int i = 0; i < artistas.length; i++) {
			System.out.println(artistas[i].toString());
			canciones=cDAO.cancionesTodas(artistas[i].getId());
			for (Cancion cancion : canciones) 
			{
			  System.out.println(cancion.toString());
			}
		}
		
	}
	private static void borrarCanciones() {
		aDAO.listarArtistas();
		int idArtista=0;
		System.out.println("Dime el id del artista del que quieres borrar las canciones: ");
		try {
			idArtista=sc.nextInt();
		}catch (Exception e) {
			System.out.println("El valor introducido no es un número");
		}
		cDAO.borrarCancionesArt(idArtista);
		
	}
	private static void unMinMas() {
		aDAO.paisesArtistas();
		System.out.println("Nombre del pais al que quieres cambiar duracion de canciones 1 minuto mas: ");
		String pais=sc.next();
		int[] idArtistas;
		idArtistas=aDAO.idArtistasPais(pais);
		
		cDAO.inserMinMasPais(idArtistas);
		
	}
	private static void modificarEdad() {
		int idArtista=0;
	    String edad = "";
		aDAO.listarArtistas();
		
		try {
			System.out.println("Id del artista al que quieres cambiar la edad: ");
			idArtista=sc.nextInt();
			System.out.println("Edad Nueva: ");
			edad=sc.next();
		}catch (Exception e) {
			System.out.println("No has introducido un numero.");
		}
		aDAO.modificarEdad(idArtista, edad);
		
	}
	private static void cancionesArtista() {
		aDAO.listarArtistas();
		int idArtista=0;
		System.out.println("Id del artista del que quieres ver las canciones: ");
		try {
			idArtista=sc.nextInt();
		}catch (Exception e) {
			System.out.println("El valor introducido no es un numero");
		}
		cDAO.cancionesArtista(idArtista);
		
	}
	private static void listarArtistasEstilo() {
		try {
		    estDAO.listarEstilos();
			System.out.print("Id del estilo que quieras buscar artistas: ");
			List<Artista> artistas = aDAO.artistaSegunEstilo(sc.nextInt());
			for (Artista artista : artistas) {
				System.out.println(artista);
			}
			}catch (Exception e) 			
			{
				System.out.println("El valor introducido no es un numero.");
			}
		
	}
	private static void insertarCancion() {
		System.out.println("Nombre de la canción: ");
		String nombre=sc.next();
		System.out.println("Duración de la canción: ");
		int duracion=0;
		try {
			duracion= sc.nextInt();
			}catch (Exception e) {
				System.out.println("El valor introducido no es un numero.");
			}
		aDAO.listarArtistas();
		System.out.println("Id del artista que pertenece esta cancion: ");
		int idArtista=0;
		try {
		idArtista=sc.nextInt();
		}catch (Exception e) {
			System.out.println("El valor introducido no es un numero.");
		}
		try {
			Cancion c= new Cancion(1,nombre,duracion,idArtista);
			cDAO.insertar(c);
		}catch (Exception e) {
			System.out.println("La cancion no se pudo introducir.");
		}
		
	}
	private static void insertarEstilo() {
		System.out.println("Nombre del estilo: ");
		String est = sc.next();
		try {
		estDAO.insertar(new Estilo(0,est));
		}catch (Exception e) {
			System.out.println("El estilo no se pudo insertar");
		}
		
	}
	private static void insertarArtista() {
		System.out.println("Nombre del artista: ");
		String nombre=sc.next();
		System.out.println("Apellido del artista: ");
		String apellido=sc.next();
		System.out.println("Edad: ");
		String edad=sc.next();
		System.out.println("Pais del artista: ");
		String pais=sc.next();
		estDAO.listarEstilos();
		System.out.println("id del estilo a elegir: ");
		int idEstilo=0;
		try {
			idEstilo=sc.nextInt();
		}catch (Exception e) {
			System.out.println("El valor insertada no es un numero.");
		}
		try {
		Artista a= new Artista(0,nombre,apellido,edad,pais,idEstilo);
		aDAO.insertar(a);
		}catch (Exception e) {
			System.out.println("El artista no se pudo insertar");
		}
		
	}
	private static int menu() {
		
		int opcion=0;
		do {
            System.out.println("\t\t\t\t♪═══════════════════════════════════════════════♪");
            System.out.println("\t\t\t\t║               ♪♪ MENU MUSICA ♪♪               ║");
            System.out.println("\t\t\t\t╠═══════════════════════════════════════════════╣");
            System.out.println("\t\t\t\t║ 1. Insertar artista,cancion o estilo          ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 2. Artista con su estilo                      ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 3. Todas las canciones de un artista          ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 4. Cambiar edad del artista                   ║");
            System.out.println("\t\t\t\t║                                               ║");
            System.out.println("\t\t\t\t║ 5. 1min mas canciones de los artistas por pais║");
            System.out.println("\t\t\t\t║                                               ║"); 
            System.out.println("\t\t\t\t║ 6. Borrar todas las canciones de un artista   ║");
            System.out.println("\t\t\t\t║                                               ║"); 
            System.out.println("\t\t\t\t║ 7. Mostrar todo                               ║");
            System.out.println("\t\t\t\t║                                               ║"); 
            System.out.println("\t\t\t\t║ 0. Salir                                      ║");
            System.out.println("\t\t\t\t♪═══════════════════════════════════════════════♪");
        System.out.print("Opcion a escoger: ");
        try {
        opcion=sc.nextInt();
        }catch (Exception e) {
			System.out.println("No has introducido un numero.");
		}
		}while(opcion<0||opcion>7);
		return opcion;
	}

}
