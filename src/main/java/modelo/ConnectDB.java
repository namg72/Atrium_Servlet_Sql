package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CREAMOS LA CONEXION CON LA BD CON UN METODO ESTATICO QUE NOS DEVUELVE UNA INSANCIA DE LA CONXION SIEMPRE QUE NO ESTE CREADA


public class ConnectDB {
	
	
	public static final String JDBC_URL= "jdbc:mysql://localhost:3360/juegoMaster?serverTimezone=UTC";    
	
	public static Connection instance = null;
	
	
	
	// Metodo para conecetarnos a la bd. Si el objeto instace esta null conecta y devuelve el objeto
	
	public static Connection getConecction() throws SQLException {
		
		if(instance==null) {
			
			instance = DriverManager.getConnection(JDBC_URL, "root", "");
			
		}
		
		return instance;
	}
	
	
	

}
