package modelo;

import java.sql.SQLException;

//EN ESTA CLASE VAMOS A CREAR EL OBJETO DE TIMPO SIM CON LAS PROPIEDADES QUE VAMOS A RECOGER EN EL FORMULARIO HTML

public class Sim {
	
	private int id;
	private String nombre;
	private int edad;
	private int categoria;
	private String foto;
	
	
	public Sim(int id, String nombre, int edad, int categoria) {

		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.categoria = categoria;
	}


	public Sim(String nombre, int edad, int categoria) {

		this.nombre = nombre;
		this.edad = edad;
		this.categoria = categoria;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	

	// Metodo para inserta un objeto en la bd. LLamamos a la clase DaoSim y gracias al patron Singleton
	// no tenemos que instanciar un objeto de esta clase. Directamente con su metodo statico getInstance 
	// que nos devuelve un objeto DaoSim podemos acceder a sus metodos no estaticos
	
	
	public void insertarSim() throws SQLException {
		
		
		DaoSim.getInstance().daoInsertarSim(this);
	}
	
	


}
