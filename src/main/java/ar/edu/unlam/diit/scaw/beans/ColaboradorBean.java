package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "colaboradorBean", eager = true)
@RequestScoped
public class ColaboradorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombreColaborador;
	private boolean estadoColaborador;
	private boolean privilegioEdicion;
	
	
	public String getNombreColaborador() {
		return nombreColaborador;
	}
	public void setNombreColaborador(String nombreInvitado) {
		this.nombreColaborador = nombreInvitado;
	}
	public boolean isEstadoColaborador() {
		return estadoColaborador;
	}
	public void setEstadoColaborador(boolean estadoInvitado) {
		this.estadoColaborador = estadoInvitado;
	}
	public boolean isPrivilegioEdicion() {
		return privilegioEdicion;
	}
	public void setPrivilegioEdicion(boolean privilegioEdicion) {
		this.privilegioEdicion = privilegioEdicion;
	}
	
	
	
}
