package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

public interface CompartirDao {

	public boolean insertarColaborador(Integer idTarea,Integer idUsuario);
	
	public boolean eliminarColaborador(Integer idTarea,Integer idUsuario);
	
	public boolean actualizarColaborador(Integer idTarea,Integer idUsuario,Boolean nuevoEstado);
	
	public boolean existeColaborador(Integer idTarea,Integer idUsuario);
	
	public List<Integer> obtenerColaboradores(Integer idTarea);
	
	public void autoasignarUsuarioATareaGlobal(Integer idUsuario,Integer idTarea);
	
}
