package model;

public class Ocorrencia {
	private Local local;
	private String objetosRoubados;
	private String detalhes;
	private float valorPrejuizo;
	private OcorrenciaSpec ocorrenciaSpec;
	private String emailUsuario;
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public String getObjetosRoubados() {
		return objetosRoubados;
	}
	public void setObjetosRoubados(String objetosRoubados) {
		this.objetosRoubados = objetosRoubados;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public float getValorPrejuizo() {
		return valorPrejuizo;
	}
	public void setValorPrejuizo(float valorPrejuizo) {
		this.valorPrejuizo = valorPrejuizo;
	}
	public OcorrenciaSpec getOcorrenciaSpec() {
		return ocorrenciaSpec;
	}
	public void setOcorrenciaSpec(OcorrenciaSpec ocorrenciaSpec) {
		this.ocorrenciaSpec = ocorrenciaSpec;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
}
