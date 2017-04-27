package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
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
	
	@Override
	public boolean privilegioUsuarioTarea(Integer idUsuarioAdjunto,Integer idTarea,Integer tipoPrivilegio){
		return usuarioDao.privilegioUsuarioTarea(idUsuarioAdjunto, idTarea, tipoPrivilegio);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
