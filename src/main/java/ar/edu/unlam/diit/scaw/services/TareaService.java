package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface TareaService {
	
	public void crearTarea(Tarea tarea);
	public List<Tarea> listarTareas(Integer id);


}