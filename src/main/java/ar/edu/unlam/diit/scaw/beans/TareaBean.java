package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

@ManagedBean(name = "tareaBean", eager = true)
@RequestScoped
public class TareaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private boolean id_modo_acceso;
	private Integer id_estado_tarea;
	
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
	
	
	

	
}
