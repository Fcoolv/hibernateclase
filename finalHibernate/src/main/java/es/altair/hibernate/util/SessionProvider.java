package es.altair.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Clase util para no tener que crear un archivo de configuracion xml
public class SessionProvider {

	private static Session session;
	private static Configuration configuration;
	
	public SessionProvider() {		
	}
	
	static {
		configuration = new Configuration()
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver.class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ciberhibernate")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "root")
				.setProperty("hibernate.show_sql", "true")
				.addAnnotatedClass(es.altair.hibernate.bean.Usuario.class)
				.addAnnotatedClass(es.altair.hibernate.bean.Ordenador.class)
				.addAnnotatedClass(es.altair.hibernate.bean.Acceso.class)
				.addAnnotatedClass(es.altair.hibernate.bean.Sala.class);
	}
	
	public static Session getSession() {
		SessionFactory sf = configuration.buildSessionFactory();
		session = sf.openSession();
		return session;
	}
}
