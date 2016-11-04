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
		//Usuario 1
		Usuario user1 = new Usuario();
		user1.setEmail("usuario1@email.com.br");
		user1.setSenha("123");
		UsuarioSpec usuarioSpec1 = new UsuarioSpec();
		usuarioSpec1.setDataNascimento(parseStringToCalendar("21/02/1995"));
		usuarioSpec1.setSexo("M");
		user1.setUsuarioSpec(usuarioSpec1);
		
		//Usuario 2
		Usuario user2 = new Usuario();
		user2.setEmail("usuario2@email.com.br");
		user2.setSenha("456");
		UsuarioSpec usuarioSpec2 = new UsuarioSpec();
		usuarioSpec2.setDataNascimento(parseStringToCalendar("15/02/2001"));
		usuarioSpec2.setSexo("F");
		user2.setUsuarioSpec(usuarioSpec2);
		
		//Usuario 3
		Usuario user3 = new Usuario();
		user3.setEmail("usuario3@email.com.br");
		user3.setSenha("559");
		UsuarioSpec usuarioSpec3 = new UsuarioSpec();
		usuarioSpec3.setDataNascimento(parseStringToCalendar("20/04/1986"));
		usuarioSpec3.setSexo("F");
		user3.setUsuarioSpec(usuarioSpec3);

		//Cadastro dos usuarios
		bancoDeDados.cadastrarUsuario(user1);
		bancoDeDados.cadastrarUsuario(user2);
		bancoDeDados.cadastrarUsuario(user3);
		
		//Ocorrencia 1
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
		
		//Ocorrencia 2
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
		
		//Ocorrencia 3
		OcorrenciaSpec ocorrenciaSpec3 = new OcorrenciaSpec();
		ocorrenciaSpec3.setDataHora(parseStringToCalendar("04/05/2016"));
		ocorrenciaSpec3.setFezBO(true);
		ocorrenciaSpec3.setTipoOcorrencia(TipoOcorrencia.ROUBO_CARRO);

		Local localRouboCarro = new Local();
		localRouboCarro.setBairro("Pq. Industrial");
		localRouboCarro.setCidade("SJC");
		localRouboCarro.setEstado("SP");
		localRouboCarro.setRua("Rua Icatu");
		
		Ocorrencia ocorrencia3 = new Ocorrencia();
		ocorrencia3.setDetalhes("Levaram meu carro qndo estava estacionado na rua");
		ocorrencia3.setObjetosRoubados("Carro");
		ocorrencia3.setOcorrenciaSpec(ocorrenciaSpec3);
		ocorrencia3.setValorPrejuizo(50000f);
		
		bancoDeDados.cadastrarOcorrencia(user1, localInvasao, ocorrencia);
		bancoDeDados.cadastrarOcorrencia(user2, localAssalto, ocorrencia2);
		bancoDeDados.cadastrarOcorrencia(user3, localRouboCarro, ocorrencia3);
		
		//Teste com usuarios
		assertEquals(bancoDeDados.getListUsuarios().size(), 3);
		assertEquals(bancoDeDados.getListOcorrencias().size(), 3);
		
		Estatistica estatistica = new Estatistica(bancoDeDados);
		
		//Teste do indice por Tipo de Ocorrencia
		assertEquals(estatistica.getIndicePorOcorrencia().get(TipoOcorrencia.ASSALTO), new Float(0.33333334)); ;
		//Teste do indice de BO
		assertEquals(estatistica.getIndiceBoletimOcorrencia().get(Boolean.TRUE), new Float(0.33333334));
		//Teste do indice por Sexo
		assertEquals(estatistica.getIndicePorSexo().get("F"), new Float(0.6666667));
		//Teste do indice por Idade
		assertEquals(estatistica.getIndicePorIdade().get("11 a 20"), new Float(0.33333334));
		//Teste do indice por Local
		assertEquals(estatistica.getIndicePorLocal().get("SJC"), new Float(1f));
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
