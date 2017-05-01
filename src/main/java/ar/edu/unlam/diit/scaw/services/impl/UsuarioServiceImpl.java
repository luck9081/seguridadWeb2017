package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.beans.UsuarioBean;
import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;
	

	@Override
	public void save(UsuarioBean usuario) {
		Usuario user = new Usuario();
		user.setNombre(usuario.getNombre());
		user.setPass(usuario.getPass());
		usuarioDao.save(user);
	}
	
	@Override
	public boolean loguear(UsuarioBean usuario){
		
		Usuario user2 = new Usuario();
		user2.setNombre(usuario.getNombre());
		user2.setPass(usuario.getPass());
		usuarioDao.loguear(user2);
		return true;
		
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}
	
	@Override
	public boolean borrar(Integer idUsuario) {
		usuarioDao.borrar(idUsuario);
		return true;
	}
	
	@Override
	public boolean editar(Integer idUsuario) {
		usuarioDao.editar(idUsuario);
		return true;
	}
	

	
	//GETTERS / SETTERS
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	


}
