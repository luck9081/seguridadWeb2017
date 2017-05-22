package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ar.edu.unlam.diit.scaw.entities.Tarea;

@ManagedBean(name = "tareaBean", eager = true)
@RequestScoped
public class TareaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_tarea;
	private String descripcion;
	private boolean id_modo_acceso;
	private Integer id_modo_acceso_int;
	private Integer id_estado_tarea;
	private Integer id_usuario;
	private Integer id_privilegio;
	
	public Integer getId_privilegio() {
		return id_privilegio;
	}

	public void setId_privilegio(Integer id_privilegio) {
		this.id_privilegio = id_privilegio;
	}

	public TareaBean() {
		super();
	}
	
	public TareaBean(String descripcion, boolean id_modo_acceso, Integer id_estado_tarea) {
		super();
		this.descripcion=descripcion;
		this.id_modo_acceso=id_modo_acceso;
		this.id_estado_tarea=id_estado_tarea;
	}


	public Tarea buildTarea() {
		Tarea tarea = new Tarea();
		tarea.setDescripcion(this.descripcion);
		tarea.setId_estado_tarea(1);// 1 es pendiente
		
		if(this.id_modo_acceso==true){
			tarea.setId_modo_acceso(1);
		}else{
			tarea.setId_modo_acceso(2);
		}

		return tarea;
	}
	

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

	public boolean getId_modo_acceso() {
		return id_modo_acceso;
	}

	public void setId_modo_acceso(boolean id_modo_acceso) {
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

	public Integer getId_modo_acceso_int() {
		return id_modo_acceso_int;
	}

	public void setId_modo_acceso_int(Integer id_modo_acceso_int) {
		this.id_modo_acceso_int = id_modo_acceso_int;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}	
	
}
