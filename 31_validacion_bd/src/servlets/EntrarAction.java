package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;

/**
 * Servlet implementation class EntrarAction
 */
@WebServlet("/EntrarAction")
public class EntrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inicio entrar");
		
		GestionClientes gclientes=new GestionClientes();
		if (gclientes.estaRegistrado(
		                  request.getParameter("usuario"),
		                  request.getParameter("password"))) {
		  request.getRequestDispatcher("TemasAction").forward(request, response);
		  System.out.println("true");}
		else
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		    System.out.println("false");
		}
		System.out.println("fin entrar");
	}

}
