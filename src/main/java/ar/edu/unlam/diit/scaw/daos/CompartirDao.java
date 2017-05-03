package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

public interface CompartirDao {

	public boolean insertarColaborador(Integer idTarea,Integer idUsuario);
	
	public boolean eliminarColaborador(Integer idTarea,Integer idUsuario);
	
	public List<Integer> obtenerColaboradores(Integer idTarea);
	
}
