package model;

import java.util.Calendar;

public class UsuarioSpec {
	
	private String sexo;
	private Calendar dataNascimento;
	int test;
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean match(UsuarioSpec spec){
		if( spec.getSexo().equals(this.sexo) ) return true;
		if( spec.getDataNascimento().equals(this.dataNascimento) ) return true;
		return false;
	}
	
	
}
