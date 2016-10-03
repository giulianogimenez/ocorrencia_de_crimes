package view;

import java.util.Scanner;

import model.BancoDeDados;
import model.Estatistica;
import model.TipoOcorrencia;

public class Principal {

	private static boolean sair = false;
	
	public static void main(String[] args) {
		while(!sair) {
			System.out.println("O que você deseja fazer?\n1-Autenticar\n2-Cadastrar-se\n3-Sair\n");
			Scanner scan = new Scanner(System.in);
			String opcao = scan.nextLine();
			operacoes(opcao);
		}
	}
	
	public static void operacoes(String opcao) {
		if(opcao.equalsIgnoreCase("3")) {
			System.out.println("Até mais!");
			sair = true;
		} else if (opcao.equalsIgnoreCase("1")){
			
		}  else if (opcao.equalsIgnoreCase("2")){
			CadastrarUsuarioView cadastrarUsuarioView = new CadastrarUsuarioView();
		} else {
			System.out.println("\nOpção Inválida!\n");
		}
	}
}
