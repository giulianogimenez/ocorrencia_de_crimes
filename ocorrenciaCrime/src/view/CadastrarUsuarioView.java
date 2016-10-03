package view;

import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;

public class CadastrarUsuarioView {
	
	public CadastrarUsuarioView() {
		UsuarioController usuarioController = new UsuarioController();
		System.out.println("CADASTRO DE USUÁRIOS\n\n");
		String email = "";
		String senha = "";
		String sexo = "";
		String dataNascimento = "";
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Email: ");
			email = scanner.nextLine();
			System.out.println("Senha: ");
			senha = scanner.nextLine();
			System.out.println("Sexo: (M/F): ");
			sexo = scanner.nextLine();
			System.out.println("Data de Nascimento (dd/mm/aaaa): ");
			dataNascimento = scanner.nextLine();
		} while(!usuarioController.validaUsuario(email, senha, sexo, dataNascimento));
		
	}
}
