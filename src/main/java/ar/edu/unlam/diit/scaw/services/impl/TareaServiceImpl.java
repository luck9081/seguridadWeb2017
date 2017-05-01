package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import ar.edu.unlam.diit.scaw.beans.TareaBean;
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
	public List<TareaBean> listarTareasPendientes(Integer id) {
		return tareaDao.listarTareasPendientes(id);
	}
	
	@Override
	public List<TareaBean> listarTareasCompletas(Integer id) {
		
		return tareaDao.listarTareasCompletas(id);

	}
	
	@Override
	public List<TareaBean> listarTareasGlobales() {
		return tareaDao.listarTareasGlobales();
	}
	
	@Override
	public void modificarEstadoTareaACompleto(Integer id_tarea) {
		tareaDao.modificarEstadoTareaACompleto(id_tarea);
	}
	
	
	//GETTERS Y SETTERS
	public TareaDao getTareaDao() {
		return tareaDao;
	}

	public void setTareaDao(TareaDao tareaDao) {
		this.tareaDao = tareaDao;
	}

	



	


	
	
}
