package fr.dawan.project.controlers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.project.jms.JMS20Producer;
import fr.dawan.project.model.Person;

/**
 * Servlet implementation class JMSController
 */
@WebServlet("/JMSController")
public class JMSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private JMS20Producer jms20Producer;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person clara = new Person("clara","morgane");
		String res = jms20Producer.send(clara);
		response.getWriter().append("****JMS res" + res +"<br/> Sent : " + clara.toString() );
	}



}
