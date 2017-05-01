package ar.edu.unlam.diit.scaw.entities;

public class Tarea {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_tarea;
	private String descripcion;
	private Integer id_modo_acceso;
	private Integer id_estado_tarea;
	private Integer id_usuario;
	
	
	public Integer getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(Integer id_tarea) {
		this.id_tarea = id_tarea;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getId_modo_acceso() {
		return id_modo_acceso;
	}
	public void setId_modo_acceso(Integer id_modo_acceso) {
		this.id_modo_acceso = id_modo_acceso;
	}
	public Integer getId_estado_tarea() {
		return id_estado_tarea;
	}
	public void setId_estado_tarea(Integer id_estado_tarea) {
		this.id_estado_tarea = id_estado_tarea;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
}
