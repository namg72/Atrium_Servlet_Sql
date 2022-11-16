package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DaoSim;
import modelo.Sim;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Servlet implementation class AltaSim
 */
@WebServlet("/AltaSim")
public class AltaSim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaSim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//recogemos los datos del request instanciones un objeto sim y lo insertamos en la bd
		
		
		String nombre= request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		
		
		
		Sim s1 = new Sim(nombre, edad, categoria);
		
		try {
			s1.insertarSim();
			
			
			response.getWriter().append( "Registro  insertado correctamente");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			 
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
