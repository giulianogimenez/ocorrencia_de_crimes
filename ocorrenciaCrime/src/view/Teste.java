package view;

import model.BancoDeDados;
import model.Estatistica;
import model.TipoOcorrencia;

public class Teste {

	public static void main(String[] args) {
		System.out.println(TipoOcorrencia.ASSALTO.getDescricao());
		
		BancoDeDados b = new BancoDeDados();
		Estatistica e = new Estatistica(b.getListOcorrencias(),b.getListUsuarios());
	}
}
