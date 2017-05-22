package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.beans.TareaBean;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface TareaService {
	
	public void crearTarea(Tarea tarea,Integer id_usuario);
	public List<TareaBean> listarTareasPendientes(Integer id);
	public void modificarEstadoTareaACompleto(Integer id_tarea);
	public List<TareaBean> listarTareasCompletas(Integer id_usuario);
	public List<TareaBean> listarTareasGlobales(Integer id_usuario);
	public List<TareaBean> listarTareasPendientesCompartidas(Integer id);
	public List<TareaBean> listarTareasCompletasCompartidas(Integer id);
	public void eliminarTarea(Integer idTarea);
	public void modificarModoAccesoAPublico(Integer idTarea);
	public void modificarModoAccesoAPrivado(Integer idTarea);




}
