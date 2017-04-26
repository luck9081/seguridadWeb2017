package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioService {

	public void save(Usuario usuario);
	public boolean borrar(Integer idUsuario);
	public boolean editar(Integer idUsuario);

	public List<Usuario> findAll();

}
