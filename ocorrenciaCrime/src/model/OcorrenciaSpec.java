package model;

import java.util.Calendar;

public class OcorrenciaSpec {
	private TipoOcorrencia tipoOcorrencia;
	private Calendar dataHora;
	private boolean fezBO;
	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}
	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public boolean isFezBO() {
		return fezBO;
	}
	public void setFezBO(boolean fezBO) {
		this.fezBO = fezBO;
	}
	
	public boolean match(OcorrenciaSpec ocorrenciaSpec) {
		if(ocorrenciaSpec == null)
			return false;
		if(ocorrenciaSpec.getTipoOcorrencia() != this.tipoOcorrencia)
			return false;
		if(!ocorrenciaSpec.getDataHora().equals(getDataHora()))
			return false;
		if(ocorrenciaSpec.isFezBO() != this.fezBO)
			return false;
		return true;
	}
}
