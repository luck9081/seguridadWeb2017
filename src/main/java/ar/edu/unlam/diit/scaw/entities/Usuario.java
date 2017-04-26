package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private EstadoUsuario estadoUser;
	private TipoUsuario	tipoUser;
	
	public Usuario() {
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EstadoUsuario getEstadoUser() {
		return estadoUser;
	}

	public void setEstadoUser(EstadoUsuario estadoUser) {
		this.estadoUser = estadoUser;
	}

	public TipoUsuario getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUsuario tipoUser) {
		this.tipoUser = tipoUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
