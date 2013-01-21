package br.caelum.clauvane.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.clauvane.logica.Logica;

public class ContatoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8523100058889735740L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametro = null;
		try {
			parametro = request.getParameter("logica");
			Class<?> classe = Class.forName("br.caelum.clauvane.logica."+parametro);
			Logica logica = (Logica) classe.newInstance();
			logica.execute(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
