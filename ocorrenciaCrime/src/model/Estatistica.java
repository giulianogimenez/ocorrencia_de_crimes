package model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estatistica {
	
	private Map<String,Float> indicePorSexo = new HashMap();
	private Map<String,Float> indicePorIdade = new HashMap();
	private Map<String,Float> indicePorLocal = new HashMap();
	private Map<TipoOcorrencia,Float> indicePorOcorrencia = new HashMap();
	private Map<Boolean,Float> indiceBoletimOcorrencia = new HashMap();
	private Calendar dataCalculo ;
	
	public Estatistica() {
		super();
	}
	public Estatistica(BancoDeDados bd) {
		indicePorSexo =  calcularIndicePorSexo(bd);
		//TODO: indicePorIdade =  calcularIndicePorIdade(bd);
		//TODO: indicePorLocal =  calcularIndicePorLocal(bd);
		//TODO: indicePorOcorrencia =  calcularIndicePorOcorrencia(bd);
		//TODO: indiceBoletimOcorrencia =  calcularIndicePorBoletimOcorrencia(bd);
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
	public Map<TipoOcorrencia, Float> getIndicePorOcorrencia() {
		return indicePorOcorrencia;
	}
	public void setIndicePorOcorrencia(Map<TipoOcorrencia, Float> indicePorOcorrencia) {
		this.indicePorOcorrencia = indicePorOcorrencia;
	}
	public Map<Boolean, Float> getIndiceBoletimOcorrencia() {
		return indiceBoletimOcorrencia;
	}
	public void setIndiceBoletimOcorrencia(
			Map<Boolean, Float> indiceBoletimOcorrencia) {
		this.indiceBoletimOcorrencia = indiceBoletimOcorrencia;
	}
	public Calendar getDataCalculo() {
		return dataCalculo;
	}
	public void setDataCalculo(Calendar dataCalculo) {
		this.dataCalculo = dataCalculo;
	}
	
	public Map<TipoOcorrencia,Float> calcularIndicePorOcorrencia(BancoDeDados bd ){
		Map<TipoOcorrencia, Float> map = new HashMap();
		
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			TipoOcorrencia tipoOcorrencia = ocorrencia.getOcorrenciaSpec().getTipoOcorrencia();
			map.put(tipoOcorrencia, map.get(tipoOcorrencia)+1f);	
		}
		return map;
	}
	
	public Map<String,Float> calcularIndicePorSexo(BancoDeDados bd ){
		float h = 0,m = 0;
		String sexo;
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			sexo = bd.usuarioByEmail(ocorrencia.getEmailUsuario()).getUsuarioSpec().getSexo();
			switch(sexo){
			case "h":
				h++;
				break;
			case "m":
				m++;
				break;
			}
		}
		Map<String,Float> map = new HashMap();
		map.put("h", h/(h+m));
		map.put("m", m/(h+m));
		return map;
	}

}
