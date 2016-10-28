package model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Estatistica {
	
	private Map<String,Float> indicePorSexo = new HashMap<String, Float>();
	private Map<String,Float> indicePorIdade = new HashMap<String, Float>();
	private Map<String,Float> indicePorLocal = new HashMap<String, Float>();
	private Map<TipoOcorrencia,Float> indicePorOcorrencia = new HashMap<TipoOcorrencia, Float>();
	private Map<Boolean,Float> indiceBoletimOcorrencia = new HashMap<Boolean, Float>();
	private Calendar dataCalculo ;
	private final BancoDeDados bd;
	
	//Injeção de dependência
	public Estatistica(BancoDeDados bd) {
		this.bd = bd;
	}
	
	public Map<String, Float> getIndicePorSexo() {
		indicePorSexo =  calcularIndicePorSexo();
		return indicePorSexo;
	}
	
	public Map<String, Float> getIndicePorIdade() {
		indicePorIdade =  calcularIndicePorIdade();
		return indicePorIdade;
	}
	
	public Map<String, Float> getIndicePorLocal() {
		return indicePorLocal;
	}
	
	
	public Map<TipoOcorrencia, Float> getIndicePorOcorrencia() {
		indicePorOcorrencia = calcularIndicePorOcorrencia();
		return indicePorOcorrencia;
	}
	
	public Map<Boolean, Float> getIndiceBoletimOcorrencia() {
		return indiceBoletimOcorrencia;
	}
	
	public Calendar getDataCalculo() {
		return dataCalculo;
	}
		
	private Map<TipoOcorrencia,Float> calcularIndicePorOcorrencia(){
		Map<TipoOcorrencia, Float> map = new HashMap<TipoOcorrencia, Float>();
		
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			TipoOcorrencia tipoOcorrencia = ocorrencia.getOcorrenciaSpec().getTipoOcorrencia();
			map.put(tipoOcorrencia, map.get(tipoOcorrencia)+1f);	
		}
		
		return map;
	}
	
	private Map<String,Float> calcularIndicePorSexo(){
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
		Map<String,Float> map = new HashMap<String, Float>();
		map.put("h", h/(h+m));
		map.put("m", m/(h+m));
		return map;
	}
	
	private Map<String,Float> calcularIndicePorIdade(){
		Map<Integer,String> idades = new HashMap<Integer, String>();
		Map<String,Float> retorno = new HashMap<String, Float>();
		
		for(int i=0;i<=9;i++){
			int j = i*10;
			idades.put(i,(j+1)+" a "+(j+10));
			retorno.put((j+1)+" a "+(j+10), 0f);
		}
		
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			int idadeOcorrencia = getDiffYears(ocorrencia.getOcorrenciaSpec().getDataHora(), bd.usuarioByEmail(ocorrencia.getEmailUsuario()).getUsuarioSpec().getDataNascimento()) ;
			idadeOcorrencia /= 10;
			retorno.put(idades.get(idadeOcorrencia), retorno.get(idades.get(idadeOcorrencia)+1));
		}
		
		for (Map.Entry<String, Float> entry : retorno.entrySet()){
			retorno.put((String)entry.getKey(), (float)entry.getValue() / (float) bd.getListOcorrencias().size());
		}
		return retorno;
	}

	private int getDiffYears(Calendar first, Calendar last) {
		int diff = last.get(Calendar.YEAR) - first.get(Calendar.YEAR);
		if (first.get(Calendar.MONTH) > last.get(Calendar.MONTH) || (first.get(Calendar.MONTH) == last.get(Calendar.MONTH) && first.get(Calendar.DATE) > last.get(Calendar.DATE))) {
			diff--;
		}
		return diff;
	}


}
