package model;

public enum TipoOcorrencia {
	
	ASSALTO("Assalto a mão armada"),
	ROUBO("Roubo qualificado ou por meio violento"),
	INVASAO("Invasão domiciliar ou estabelecimento"),
	FURTO("Furto qualificado"),
	INVASAO_AUTOMOVEL("Invasão à um automóvel"),
	ROUBO_CARRO("Roubo de um automóvel");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	private TipoOcorrencia(String descricao) {
		this.descricao = descricao;
	}
}
