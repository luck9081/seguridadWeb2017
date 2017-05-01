package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.TareaService;



public class TareaServiceImpl implements TareaService {
	
	TareaDao tareaDao;
	
	public void crearTarea( Tarea tarea){
		
		tareaDao.crearTarea(tarea);
		
	}
	
	@Override
	public List<Tarea> listarTareas(Integer id) {
		return tareaDao.listarTareas(id);
	}
	
	
	//GETTERS Y SETTERS
	public TareaDao getTareaDao() {
		return tareaDao;
	}

	public void setTareaDao(TareaDao tareaDao) {
		this.tareaDao = tareaDao;
	}


	
	
}
