package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.beans.UsuarioBean;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioService {

	public void save(UsuarioBean usuario);
	
	public List<Usuario> findAll();
	
	public boolean borrar(Integer idUsuario);
	
	public boolean editar(Integer idUsuario);
	
	public boolean loguear(UsuarioBean usuario);

}
