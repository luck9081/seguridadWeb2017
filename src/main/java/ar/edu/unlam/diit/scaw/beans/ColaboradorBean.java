package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "colaboradorBean", eager = true)
@RequestScoped
public class ColaboradorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombreInvitado;
	private boolean estadoInvitado;
	
	
	public String getNombreInvitado() {
		return nombreInvitado;
	}
	public void setNombreInvitado(String nombreInvitado) {
		this.nombreInvitado = nombreInvitado;
	}
	public boolean isEstadoInvitado() {
		return estadoInvitado;
	}
	public void setEstadoInvitado(boolean estadoInvitado) {
		this.estadoInvitado = estadoInvitado;
	}
	
}
