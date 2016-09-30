package model;

import java.util.Date;

public class UsuarioSpec {
	
	private String sexo;
	private Date dataNascimento;
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean match(UsuarioSpec spec){
		if( spec.getSexo().equals(this.sexo) ) return true;
		if( spec.getDataNascimento().equals(this.dataNascimento) ) return true;
		return false;
	}
	
	
}
