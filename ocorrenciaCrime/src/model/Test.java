package model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

	@org.junit.Test
	public void test() throws ParseException {
		
		//Teste de Usuario
		Usuario user1 = new Usuario();
		user1.setEmail("usuario1@email.com.br");
		user1.setSenha("123");
		UsuarioSpec usuarioSpec1 = new UsuarioSpec();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("dd/MM/yyy").parse("15/02/2001"));
		usuarioSpec1.setDataNascimento(c1);
		usuarioSpec1.setSexo("M");
		user1.setUsuarioSpec(usuarioSpec1);
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.cadastrarUsuario(user1);
		
		Usuario user2 = new Usuario();
		user2.setEmail("usuario2@email.com.br");
		user2.setSenha("456");
		UsuarioSpec usuarioSpec2 = new UsuarioSpec();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new SimpleDateFormat("dd/MM/yyy").parse("15/02/2001"));
		usuarioSpec2.setDataNascimento(c2);
		usuarioSpec2.setSexo("F");
		user2.setUsuarioSpec(usuarioSpec2);

		bancoDeDados.cadastrarUsuario(user2);
		
	}

}
