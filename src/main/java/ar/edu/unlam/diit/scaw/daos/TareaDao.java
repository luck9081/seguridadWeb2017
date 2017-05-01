package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface TareaDao {
	public void crearTarea(Tarea tarea);
	public List<Tarea> listarTareas(Integer id);


}
