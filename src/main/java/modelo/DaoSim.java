package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;




public class DaoSim {
	
	
	//En esta clase vamos a trabajar con la conexion a la bad es un capa intemedia entre el el servlet y la bd
	
	private Connection con;
	
	public static DaoSim instance=null;   
	
	
	
	
	// Constructor. En el llamamos al mtodo getConection de la clase connectDB que nos devuelve una coneions
	
	public DaoSim() throws SQLException {
		
		con = ConnectDB.getConecction();
	}
	
	
	
	//patron Singleton. 
	// Metodo estatico que no devuelve un objeto del tipo DaoSim paara poder acceder a sus metodos sin instanciarlo
	
	public static DaoSim getInstance() throws SQLException {
		
		if(instance==null) {
			instance = new DaoSim();
		}
		
		
		return instance;
	}
	
	
	//Metodo para insertar un objeto Sim en la bae de datos
	
	public void daoInsertarSim(Sim s) throws SQLException {
		
		PreparedStatement ps =  con.prepareStatement("INSERT INTO sim (nombre, edad, categoria) VALUES (?,?,?);");
		
		ps.setString(1, s.getNombre());
		ps.setInt(2, s.getEdad());
		ps.setInt(3, s.getCategoria());
		ps.executeUpdate();		
		//cerrarmos el statement
		ps.close();
		
		
	}
	
	
	  //Metodo para listar todos los Sim
	  
	  public ArrayList<Sim> listarSim() throws SQLException{
	  
	  PreparedStatement ps= con.prepareStatement("SELECT * FROM sim");
	  
	  ResultSet result= ps.executeQuery();
	  
	  ArrayList<Sim> lista=null;
	  
	  
	  while(result.next()) {
	  
		  if(lista==null) {
		  
		  lista= new ArrayList<Sim>();
		  }
	  lista.add(new Sim(result.getInt("id"), result.getString("nombre"),
	  result.getInt("edad"), result.getInt("categoria")));
	  
	  }
	result.close();
	 ps.close();
	 
	 
	  return lista;
	  
	  
	  }
	 
	
	// Metodo para covertir el JSON para ello hemos importarado en el buidpath la libreria GSON. Creamos un objeto gson y y con el meetodo
	//to String le psamos el el arralyt lista para que lo convierta  y lo almacenamos en una variablae Stirn que retornamos. Este metodo lo 
	//llamaeremos desde el servlet
	


	public String listadoJSON() throws SQLException {
		
		Gson gson= new Gson();
		
		String listado= gson.toJson(this.listarSim());
				
		
				
		return listado;
		
		
		
	}
	
	

}
