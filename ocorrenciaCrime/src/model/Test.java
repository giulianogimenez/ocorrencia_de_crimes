package model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

	@org.junit.Test
	public void test() throws ParseException {
		BancoDeDados bancoDeDados = new BancoDeDados();
		
		//Teste de Usuario
		Usuario user1 = new Usuario();
		user1.setEmail("usuario1@email.com.br");
		user1.setSenha("123");
		UsuarioSpec usuarioSpec1 = new UsuarioSpec();
		usuarioSpec1.setDataNascimento(parseStringToCalendar("21/02/1995"));
		usuarioSpec1.setSexo("M");
		user1.setUsuarioSpec(usuarioSpec1);
		
		
		Usuario user2 = new Usuario();
		user2.setEmail("usuario2@email.com.br");
		user2.setSenha("456");
		UsuarioSpec usuarioSpec2 = new UsuarioSpec();
		usuarioSpec2.setDataNascimento(parseStringToCalendar("15/02/2001"));
		usuarioSpec2.setSexo("F");
		user2.setUsuarioSpec(usuarioSpec2);

		OcorrenciaSpec ocorrenciaSpec = new OcorrenciaSpec();
		ocorrenciaSpec.setDataHora(parseStringToCalendar("20/10/2016"));
		ocorrenciaSpec.setFezBO(true);
		ocorrenciaSpec.setTipoOcorrencia(TipoOcorrencia.INVASAO);

		Local localInvasao = new Local();
		localInvasao.setBairro("Centro");
		localInvasao.setCidade("SJC");
		localInvasao.setEstado("SP");
		localInvasao.setBairro("Rua Humaita");
		
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDetalhes("Invadiram a minha casa e levaram o meu cachorro!");
		ocorrencia.setEmailUsuario("usuario1@email.com.br");
		ocorrencia.setObjetosRoubados("Cachorro, Coleira e o pote de ração");
		ocorrencia.setOcorrenciaSpec(ocorrenciaSpec);
		ocorrencia.setValorPrejuizo(1000f);
		ocorrencia.setLocal(localInvasao);
		
		bancoDeDados.cadastrarUsuario(user2);
		bancoDeDados.cadastrarUsuario(user1);		
	}
	
	private Calendar parseStringToCalendar(String date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(new SimpleDateFormat("dd/MM/yyy").parse(date));
			return c;
		} catch(ParseException e) {
			throw new IllegalArgumentException("Data inserida inválida!");
		}
	}
}
