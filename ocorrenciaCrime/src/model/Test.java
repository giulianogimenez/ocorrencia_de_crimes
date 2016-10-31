package model;

import static org.junit.Assert.*;

import java.util.Map;
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

		bancoDeDados.cadastrarUsuario(user1);
		bancoDeDados.cadastrarUsuario(user2);
		
		OcorrenciaSpec ocorrenciaSpec = new OcorrenciaSpec();
		ocorrenciaSpec.setDataHora(parseStringToCalendar("20/10/2016"));
		ocorrenciaSpec.setFezBO(true);
		ocorrenciaSpec.setTipoOcorrencia(TipoOcorrencia.INVASAO);

		Local localInvasao = new Local();
		localInvasao.setBairro("Centro");
		localInvasao.setCidade("SJC");
		localInvasao.setEstado("SP");
		localInvasao.setRua("Rua Humaita");
		
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDetalhes("Invadiram a minha casa e levaram o meu cachorro!");
		ocorrencia.setObjetosRoubados("Cachorro, Coleira e o pote de ra��o");
		ocorrencia.setOcorrenciaSpec(ocorrenciaSpec);
		ocorrencia.setValorPrejuizo(1000f);
		
		OcorrenciaSpec ocorrenciaSpec2 = new OcorrenciaSpec();
		ocorrenciaSpec2.setDataHora(parseStringToCalendar("17/10/2016"));
		ocorrenciaSpec2.setFezBO(false);
		ocorrenciaSpec2.setTipoOcorrencia(TipoOcorrencia.ASSALTO);

		Local localAssalto = new Local();
		localAssalto.setBairro("Centro");
		localAssalto.setCidade("SJC");
		localAssalto.setEstado("SP");
		localAssalto.setRua("Av. Nelson D'avila");
		
		Ocorrencia ocorrencia2 = new Ocorrencia();
		ocorrencia2.setDetalhes("Fui assaltado enquanto passeava de carro na Nelson D'avila... numa sexta... a noite... só q n tava fazendo nada de errado la...");
		ocorrencia2.setObjetosRoubados("Relogio, cateira com documentos e celular");
		ocorrencia2.setOcorrenciaSpec(ocorrenciaSpec2);
		ocorrencia2.setValorPrejuizo(3000f);
		
		bancoDeDados.cadastrarOcorrencia(user1, localInvasao, ocorrencia);
		bancoDeDados.cadastrarOcorrencia(user2, localAssalto, ocorrencia2);
		
		assertEquals(bancoDeDados.getListUsuarios().size(), 2);
		assertEquals(bancoDeDados.getListOcorrencias().size(), 2);
		
		Estatistica estatistica = new Estatistica(bancoDeDados);
		Map<TipoOcorrencia, Float> result = estatistica.getIndicePorOcorrencia();
		assertEquals(estatistica.getIndiceBoletimOcorrencia().get(Boolean.TRUE), new Float(0.5));

	}
	
	private Calendar parseStringToCalendar(String date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(new SimpleDateFormat("dd/MM/yyy").parse(date));
			return c;
		} catch(ParseException e) {
			throw new IllegalArgumentException("Data inserida inv�lida!");
		}
	}
}
