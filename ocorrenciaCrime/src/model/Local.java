package model;

public class Local {
	private String cidade;
	private String rua;
	private String bairro;
	private String estado;
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public boolean match(Local local) {
		if(local == null)
			return false;
		if(!local.getBairro().equals(this.bairro))
			return false;
		if(!local.getCidade().equals(this.cidade))
			return false;
		if(!local.getEstado().equals(this.estado))
			return false;
		if(!local.getRua().equals(this.rua))
			return false;
		return true;
	}
}
