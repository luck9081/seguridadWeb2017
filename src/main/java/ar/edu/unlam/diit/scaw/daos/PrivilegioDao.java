package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.TareaPorUsuario;

public interface PrivilegioDao {

	public List<TareaPorUsuario> colaboradoresYPrivilegios(Integer idTarea);
	
	public boolean cambiarPrivilegio(Integer idTarea,Integer idUsuario,Integer nuevoPrivilegio);
	
}
