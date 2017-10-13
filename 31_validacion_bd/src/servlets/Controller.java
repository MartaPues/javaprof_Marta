package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		switch(op) {
		    case "doEntrar":
			  url="EntrarAction";
			  break;		
			case "doAlta":
				url="AltaAction";
				break;
			case "doConsultaTemas":
				url="ConsultaTemas";
				break;
			case "toInicio":
				url="inicio.html";
				break;
			case "toRegistro":
				url="registro.html";
				break;	
			case "toTemas":
				url="temas.jsp";
				
				break;				
				

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
