package ar.edu.unlam.diit.scaw.entities;

public class Usuario_Privilegio_Tarea {
	
	private Integer id_usuario;
	private Integer id_tarea;
	private Integer id_privilegio;
	private Boolean estado_colaborador;
	
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(Integer id_tarea) {
		this.id_tarea = id_tarea;
	}
	public Integer getId_privilegio() {
		return id_privilegio;
	}
	public void setId_privilegio(Integer id_privilegio) {
		this.id_privilegio = id_privilegio;
	}
	public Boolean getEstado_colaborador() {
		return estado_colaborador;
	}
	public void setEstado_colaborador(Boolean estado_colaborador) {
		this.estado_colaborador = estado_colaborador;
	}
		
}
