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
	private Calendar dataCalculo;
	private final BancoDeDados bd;
	
	//Inje��o de depend�ncia
	public Estatistica(BancoDeDados bd) {
		this.bd = bd;
		this.dataCalculo = Calendar.getInstance();
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
		indicePorLocal = calcularIndicePorLocal();
		return indicePorLocal;
	}
	
	
	public Map<TipoOcorrencia, Float> getIndicePorOcorrencia() {
		indicePorOcorrencia = calcularIndicePorOcorrencia();
		return indicePorOcorrencia;
	}
	
	public Map<Boolean, Float> getIndiceBoletimOcorrencia() {
		indiceBoletimOcorrencia = calcularBoletimOcorrencia();
		return indiceBoletimOcorrencia;
	}
	
	public Calendar getDataCalculo() {
		return dataCalculo;
	}
		
	private Map<TipoOcorrencia,Float> calcularIndicePorOcorrencia(){
		Map<TipoOcorrencia, Float> retorno = new HashMap<TipoOcorrencia, Float>();
		
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			TipoOcorrencia tipoOcorrencia = ocorrencia.getOcorrenciaSpec().getTipoOcorrencia();
			retorno.put(tipoOcorrencia, retorno.get(tipoOcorrencia) == null ? 1f : retorno.get(tipoOcorrencia));	
		}
		for (Map.Entry<TipoOcorrencia, Float> entry : retorno.entrySet()){
			retorno.put((TipoOcorrencia)entry.getKey(), (float)entry.getValue() / (float) bd.getListOcorrencias().size());
		}
		
		return retorno;
	}
	
	private Map<String,Float> calcularIndicePorSexo(){
		float m = 0,f = 0;
		char sexo;
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			sexo = bd.usuarioByEmail(ocorrencia.getEmailUsuario()).getUsuarioSpec().getSexo().toCharArray()[0];
			switch(sexo){
			case 'M':
				m++;
				break;
			case 'F':
				f++;
				break;
			}
		}
		Map<String,Float> map = new HashMap<String, Float>();
		map.put("M", m/(m+f));
		map.put("F", f/(m+f));
		return map;
	}
	
	private Map<String,Float> calcularIndicePorIdade(){
		Map<Integer,String> idades = new HashMap<Integer, String>();
		Map<String,Float> retorno = new HashMap<String, Float>();
		
		for(int i=0;i<=9;i++){
			int j = i*10;
			idades.put(i,Integer.valueOf(j+1).toString() + " a "+Integer.valueOf(j+10).toString());
			retorno.put((j+1)+" a "+(j+10), 0f);
		}
		
		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			int idadeOcorrencia = getDiffYears(bd.usuarioByEmail(ocorrencia.getEmailUsuario()).getUsuarioSpec().getDataNascimento(), ocorrencia.getOcorrenciaSpec().getDataHora()) ;
			idadeOcorrencia /= 10;
			retorno.put(idades.get(idadeOcorrencia), retorno.get(idades.get(idadeOcorrencia)) + 1f);
		}
		
		for (Map.Entry<String, Float> entry : retorno.entrySet()){
			if(entry.getValue() != null)
				retorno.put((String)entry.getKey(), (float)entry.getValue() / (float) bd.getListOcorrencias().size());
		}
		return retorno;
	}
	
	private Map<String,Float> calcularIndicePorLocal(){
		Map<String,Float> retorno = new HashMap<String, Float>();

		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			String cidadeOcorrencia = ocorrencia.getLocal().getCidade();
			retorno.put(cidadeOcorrencia, retorno.get(cidadeOcorrencia) == null ? 1f : retorno.get(cidadeOcorrencia) + 1f);
		}
		
		for (Map.Entry<String, Float> entry : retorno.entrySet()){
			retorno.put((String)entry.getKey(), (float)entry.getValue() / (float) bd.getListOcorrencias().size());
		}
		return retorno;
	}
	
	private Map<Boolean,Float> calcularBoletimOcorrencia(){
		Map<Boolean,Float> retorno = new HashMap<Boolean, Float>();

		for (Ocorrencia ocorrencia : bd.getListOcorrencias()) {
			Boolean fezBo = ocorrencia.getOcorrenciaSpec().isFezBO();
			retorno.put(fezBo, retorno.get(fezBo) == null ? 1f : retorno.get(fezBo));
		}
		
		for ( Map.Entry<Boolean, Float> entry : retorno.entrySet() ){
			retorno.put((Boolean)entry.getKey(), (float)entry.getValue() / (float) bd.getListOcorrencias().size());
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
