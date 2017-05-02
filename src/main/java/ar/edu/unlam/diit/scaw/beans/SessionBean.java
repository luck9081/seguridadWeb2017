package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "miSesion")
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	private String idUsuario;
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}	
	
}
