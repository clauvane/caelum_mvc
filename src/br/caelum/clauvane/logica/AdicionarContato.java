package br.caelum.clauvane.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.clauvane.dao.ContatoDao;
import br.caelum.clauvane.modelo.Contato;

public class AdicionarContato implements Logica{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Contato contato = new Contato();
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
		dao.addContato(contato);
	}

}
