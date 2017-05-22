package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import ar.edu.unlam.diit.scaw.beans.TareaBean;
import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.services.TareaService;



public class TareaServiceImpl implements TareaService {
	
	TareaDao tareaDao;
	
	public void crearTarea(Tarea tarea,Integer id_usuario){
		
		tareaDao.crearTarea(tarea,id_usuario);
		
	}
	
	@Override
	public void editarTarea(Tarea tarea){		
		tareaDao.editarTarea(tarea);		
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
	public List<TareaBean> listarTareasGlobales(Integer id_usuario) {
		return tareaDao.listarTareasGlobales(id_usuario);
	}
	
	@Override
	public void modificarEstadoTareaACompleto(Integer id_tarea) {
		tareaDao.modificarEstadoTareaACompleto(id_tarea);
	}
	
	@Override
	public List<TareaBean> listarTareasPendientesCompartidas(Integer id) {
		
		return tareaDao.listarTareasPendientesCompartidas(id);
		
	}
	
	@Override
	public List<TareaBean> listarTareasCompletasCompartidas(Integer id) {
		
		return tareaDao.listarTareasCompletasCompartidas(id);
	}
	
	@Override
	public void eliminarTarea(Integer idTarea) {
		tareaDao.eliminarTarea(idTarea);
		
	}


	@Override
	public void modificarModoAccesoAPublico(Integer idTarea) {
		tareaDao.modificarModoAccesoAPublico(idTarea);
		
	}
	
	public void modificarModoAccesoAPrivado(Integer idTarea) {
		tareaDao.modificarModoAccesoAPrivado(idTarea);
		
	}
	
	
	//GETTERS Y SETTERS
	public TareaDao getTareaDao() {
		return tareaDao;
	}

	public void setTareaDao(TareaDao tareaDao) {
		this.tareaDao = tareaDao;
	}

	




	



	


	
	
}
