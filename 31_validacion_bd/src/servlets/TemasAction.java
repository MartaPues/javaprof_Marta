package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tema;
import modelo.GestionClientes;

/**
 * Servlet implementation class temasAction
 */
@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Tema> temas;
		
		GestionClientes gclientes=new GestionClientes();
		
		temas= (ArrayList) gclientes.recuperarTemas();

		//atributo de petición
		request.setAttribute("temas", temas);
		
		request.getRequestDispatcher("temas.jsp").forward(request, response);

	}

}
