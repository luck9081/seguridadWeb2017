package ar.edu.unlam.diit.scaw.daos;


import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioDao {

	public void save(Usuario usuario);
	
	public void saveAdmin(Usuario usuario);
	
	public boolean loguear(Usuario usuario);
	
	public boolean borrar(Integer idUsuario);
	
	public boolean editar(Usuario usuario);
	
	public boolean validarAdmin(Usuario admin);
	
	public void aceptarUsuario(Integer idUsuario);
	
	public void denegarUsuario(Integer idUsuario);
	
	public List<Usuario> listarUsuariosPendientes();
	
	public List<Usuario> findAll();
	
	public Integer buscarIdUsuario(String nombreUsuario);
	
	public String buscarNombreUsuario(Integer idUsuario);

	public List<String> listarUsuariosPorNombre(String Nombre);
	
	public List<String> listarAdminPorNombre(String Nombre);
	
	
}
