package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

public class Invitado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idInvitado;
	private Integer idTarea;
	private Integer idPrivilegio;
	
	public Invitado() {
	}
	
	public Integer getIdInvitado() {
		return idInvitado;
	}

	public void setIdInvitado(Integer idInvitado) {
		this.idInvitado = idInvitado;
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

	public void setId(Integer idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
