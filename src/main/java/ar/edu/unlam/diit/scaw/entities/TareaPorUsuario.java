package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

public class TareaPorUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private Integer idTarea;
	private Integer	idPrivilegio;
	private boolean estado;
	
	public TareaPorUsuario() {
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	public Integer getIdPrivilegio() {
		return idPrivilegio;
	}

	public void setIdPrivilegio(Integer idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
