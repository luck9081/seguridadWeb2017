package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String nombre;
	private String pass;
	private Integer id_estado_usuario;
	private Integer	id_tipo_usuario;
	
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getId_estado_usuario() {
		return id_estado_usuario;
	}

	public void setId_estado_usuario(Integer id_estado_usuario) {
		this.id_estado_usuario = id_estado_usuario;
	}

	public Integer getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(Integer id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
