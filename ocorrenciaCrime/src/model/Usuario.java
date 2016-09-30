package model;

public class Usuario {
	
	private String email;
	private String senha;
	private UsuarioSpec usuarioSpec;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioSpec getUsuarioSpec() {
		return usuarioSpec;
	}
	public void setUsuarioSpec(UsuarioSpec usuarioSpec) {
		this.usuarioSpec = usuarioSpec;
	}
	
	public boolean autenticar(Usuario user){
		if(user == null) return false;
		if(user.getEmail().equals(this.email)) return false;
		if(user.getSenha().equals(this.senha)) return false;
		return true;
	}

}
