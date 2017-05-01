package ar.edu.unlam.diit.scaw.daos;

import java.util.LinkedList;

import ar.edu.unlam.diit.scaw.entities.TareaPorUsuario;

public interface PrivilegioDao {

	public LinkedList<TareaPorUsuario> colaboradoresYPrivilegios(Integer idTarea);
	
	public boolean cambiarPrivilegio(Integer idTarea,Integer idUsuario,Integer nuevoPrivilegio);
	
}
