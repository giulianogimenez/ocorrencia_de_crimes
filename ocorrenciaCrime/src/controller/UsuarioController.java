package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.BancoDeDados;
import model.Usuario;

public class UsuarioController {
	public BancoDeDados bancoDeDados = new BancoDeDados();
	
	public boolean validaUsuario(String email, String senha, String sexo, String dataNascimento) {
		if(bancoDeDados.usuarioByEmail(email) != null) {
			System.out.println("\nUsuario " + email + " já existe!\n");
			return false;
		}
		if(senha.contains(" ")) {
			System.out.println("\nSenha não poderá conter caracteres em branco.\n");
			return false;
		}
		if(senha.length() < 5) {
			System.out.println("\nSenha não poderá conter menos de 5 caracteres.\n");
			return false;
		}
		if(!sexo.toUpperCase().equals("M") && !sexo.toUpperCase().equals("F")) {
			System.out.println("\nO sexo deverá ser M para masculino e F para feminino.\n");
			return false;
		}
		Calendar dt = Calendar.getInstance();
		try {
			dt.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento));
		} catch (ParseException e) {
			System.out.println("\nData inválida!\n");
			return false;
		}
		return true;
	}
}
