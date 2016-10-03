package model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estatistica {
	
	private Map<String,Float> indicePorSexo = new HashMap();
	private Map<String,Float> indicePorIdade = new HashMap();
	private Map<String,Float> indicePorLocal = new HashMap();
	private Map<String,Float> indicePorOcorrencia = new HashMap();
	private Map<String,Float> indiceBoletimOcorrencia = new HashMap();
	private Calendar dataCalculo ;
	
	public Estatistica() {
		super();
	}
	public Estatistica(List<Ocorrencia> ocorrencias,List<Usuario> usuarios) {
		indicePorSexo =  calcularIndicePorSexo(ocorrencias, usuarios);
	}
	public Map<String, Float> getIndicePorSexo() {
		return indicePorSexo;
	}
	public void setIndicePorSexo(Map<String, Float> indicePorSexo) {
		this.indicePorSexo = indicePorSexo;
	}
	public Map<String, Float> getIndicePorIdade() {
		return indicePorIdade;
	}
	public void setIndicePorIdade(Map<String, Float> indicePorIdade) {
		this.indicePorIdade = indicePorIdade;
	}
	public Map<String, Float> getIndicePorLocal() {
		return indicePorLocal;
	}
	public void setIndicePorLocal(Map<String, Float> indicePorLocal) {
		this.indicePorLocal = indicePorLocal;
	}
	public Map<String, Float> getIndicePorOcorrencia() {
		return indicePorOcorrencia;
	}
	public void setIndicePorOcorrencia(Map<String, Float> indicePorOcorrencia) {
		this.indicePorOcorrencia = indicePorOcorrencia;
	}
	public Map<String, Float> getIndiceBoletimOcorrencia() {
		return indiceBoletimOcorrencia;
	}
	public void setIndiceBoletimOcorrencia(
			Map<String, Float> indiceBoletimOcorrencia) {
		this.indiceBoletimOcorrencia = indiceBoletimOcorrencia;
	}
	public Calendar getDataCalculo() {
		return dataCalculo;
	}
	public void setDataCalculo(Calendar dataCalculo) {
		this.dataCalculo = dataCalculo;
	}
	
	public Map<String,Float> calcularIndicePorSexo( List<Ocorrencia> lOcorrencias, List<Usuario> lUsuario  ){
		float h = 0,m = 0;
		for (Ocorrencia ocorrencia : lOcorrencias) {

		}
		int commitTest = 0;
		
		return null;
	}

}
