package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.beans.TareaBean;
import ar.edu.unlam.diit.scaw.entities.Tarea;

public interface TareaDao {
	public void crearTarea(Tarea tarea);
	public List<TareaBean> listarTareas(Integer id);


}
