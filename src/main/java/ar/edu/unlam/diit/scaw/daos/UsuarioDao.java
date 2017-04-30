package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioDao {

	public void save(Usuario person);
	
	public boolean borrar(Integer idUsuario);
	
	public boolean editar(Integer idUsuario);
	
	public List<Usuario> findAll();
	
	void crearTarea(String descripcion, Integer id_modo_acceso,
			Integer id_estado_tarea);
	
}
