package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BancoDeDados {
	private List<Ocorrencia> listOcorrencias = new ArrayList();
	private List<Usuario> listUsuarios = new ArrayList();
	private List<Estatistica> listEstatisticas = new ArrayList();
	
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
	
	public List<Ocorrencia> listarOcorrencia(OcorrenciaSpec ocorrenciaSpec) {
		List<Ocorrencia> ocorrenciasEncontradas = new ArrayList();
		for (Ocorrencia ocorrencia : listOcorrencias) {
			if(ocorrencia.getOcorrenciaSpec().match(ocorrenciaSpec)) {
				ocorrenciasEncontradas.add(ocorrencia);
			}
		}
		return ocorrenciasEncontradas;
	}
	
	public void cadastrarOcorrencia(Usuario usuario, Local local, Ocorrencia ocorrencia) {
		ocorrencia.setEmailUsuario(usuario.getEmail());
		ocorrencia.setLocal(local);
		listOcorrencias.add(ocorrencia);
	}
	
	public boolean logar(Usuario usuario) {
		for (Usuario u : listUsuarios) {
			if(u.getEmail().equals(usuario.getEmail()) && 
					u.getSenha().equals(usuario.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	public Usuario usuarioByEmail(String email){
		for(Usuario usuario : listUsuarios){
			if( usuario.getEmail().equals(email) )
				return usuario;
		}
		return null;
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		listUsuarios.add(usuario);
	}
	
	public void salvarEstatistica(Estatistica estatistica) {
		listEstatisticas.add(estatistica);
	}
	
	public Estatistica buscarEstatistica(Calendar data) {
		String periodoInicioString = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		periodoInicioString += " 00:00";
		String periodoFimString = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		periodoFimString += " 23:59";
		Calendar periodoInicio = Calendar.getInstance();
		Calendar periodoFim = Calendar.getInstance();
		try {
			periodoInicio.setTime(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(periodoInicioString));
			periodoFim.setTime(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(periodoFimString));
		} catch (ParseException e) {
			System.out.println("Data de busca inválida.");
			return null;
		} catch (Exception e) {
			throw e;
		}
		for (Estatistica estatistica : listEstatisticas) {
			if(estatistica.getDataCalculo().after(periodoInicio) && estatistica.getDataCalculo().before(periodoFim)) {
				return estatistica;
			}
		}
		return null;
	}
}
