package ar.edu.unlam.diit.scaw.services;

import java.util.List;


import ar.edu.unlam.diit.scaw.beans.UsuarioBean;


import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioService {

	public void save(UsuarioBean usuario);
	
	public void saveAdmin(UsuarioBean usuario);
	
	public List<Usuario> findAll();
	
	public boolean borrar(Integer idUsuario);
	
	public boolean editar(UsuarioBean usuario);

	public boolean loguear(UsuarioBean usuario);
	
	public boolean validarAdmin(UsuarioBean usuario);
	
	public void aceptarUsuario(Integer idUsuario);
	
	public void denegarUsuario(Integer idUsuario);
	
	public List<Usuario> listarUsuariosPendientes();

	public Integer buscarIdUsuario(String nombreUsuario);
	
	public String buscarNombreUsuario(Integer idUsuario);

}
