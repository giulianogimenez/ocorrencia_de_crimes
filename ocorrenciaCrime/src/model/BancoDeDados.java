package model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	private List<Ocorrencia> listOcorrencias = new ArrayList();
	private List<Usuario> listUsuarios = new ArrayList();
	//TODO: private List<Estatistica> listEstatisticas = new ArrayList();
	
	public List<Ocorrencia> getListOcorrencias() {
		return listOcorrencias;
	}
	public void setListOcorrencias(List<Ocorrencia> listOcorrencias) {
		this.listOcorrencias = listOcorrencias;
	}
	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}
	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
	
	public List<Ocorrencia> listarOcorrencia(LocalSpec localSpec) {
		List<Ocorrencia> ocorrenciasEncontradas = new ArrayList();
		for (Ocorrencia ocorrencia : listOcorrencias) {
			if(ocorrencia.getLocal().getLocalSpec().match(localSpec)) {
				ocorrenciasEncontradas.add(ocorrencia);
			}
		}
		return ocorrenciasEncontradas;
	}
	
	public List<Ocorrencia> listarOcorrencia(Usuario usuario) {
		List<Ocorrencia> ocorrenciasEncontradas = new ArrayList();
		for (Ocorrencia ocorrencia : listOcorrencias) {
			if(ocorrencia.getEmailUsuario().equals(usuario.getEmail())) {
				ocorrenciasEncontradas.add(ocorrencia);
			}
		}
		return ocorrenciasEncontradas;
	}
}
