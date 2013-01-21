package br.caelum.clauvane.logica;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.clauvane.dao.ContatoDao;
import br.caelum.clauvane.modelo.Contato;

public class AlterarContato implements Logica{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Contato contato = new Contato();
		contato.setId(new Long(id));
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		
		Calendar data = null;
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
			data = Calendar.getInstance();
			data.setTime(d);
			contato.setDataNascimento(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ContatoDao dao = new ContatoDao();
		dao.alterContato(contato);

		RequestDispatcher rd = request.getRequestDispatcher("/contatoAlterado.jsp");
		rd.forward(request, response);
	}

}
