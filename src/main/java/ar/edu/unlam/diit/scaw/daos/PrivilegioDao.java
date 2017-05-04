package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario_Privilegio_Tarea;

public interface PrivilegioDao {

	public List<Usuario_Privilegio_Tarea> colaboradoresYPrivilegios(Integer idTarea);
	
	public boolean cambiarPrivilegio(Integer idTarea,Integer idUsuario,Integer nuevoPrivilegio);
	
}
