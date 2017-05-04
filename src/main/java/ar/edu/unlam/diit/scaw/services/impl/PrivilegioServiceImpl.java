package ar.edu.unlam.diit.scaw.services.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.beans.ColaboradorBean;
import ar.edu.unlam.diit.scaw.daos.PrivilegioDao;
import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Usuario_Privilegio_Tarea;
import ar.edu.unlam.diit.scaw.services.PrivilegioService;

public class PrivilegioServiceImpl implements PrivilegioService {

	@Autowired
	PrivilegioDao privilegioDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public LinkedList<ColaboradorBean> listarColaboradoresYPrivilegios(Integer idTarea){ // se busca listar solamente aquellos que colaboran con esta tarea y sus privilegios
		
		ColaboradorBean colaborador = new ColaboradorBean();
		LinkedList<ColaboradorBean> listaColaboradores = new LinkedList<ColaboradorBean>();		
		
		for(Usuario_Privilegio_Tarea item : privilegioDao.colaboradoresYPrivilegios(idTarea)){
			if(item.getId_privilegio().equals(1))
				colaborador.setPrivilegioEdicion(true);
			else
				colaborador.setPrivilegioEdicion(false);

			colaborador.setNombreColaborador(usuarioDao.buscarNombreUsuario(item.getId_usuario()));
			listaColaboradores.add(colaborador);
			colaborador = new ColaboradorBean();
		}
		
		return listaColaboradores;
	}
	
	@Override
	public boolean cambiarPrivilegio(Integer idTarea,String nombreUsuario,Integer nuevoPrivilegio){
		// NOTA: (REALIZAR) consumir servicio de usuario que, a partir del nombre de usuario, obtenga el ID
		Integer idUsuario = 0;
		return privilegioDao.cambiarPrivilegio(idTarea,idUsuario,nuevoPrivilegio);
	}
	
	
	//GETTERS Y SETTERS
	public PrivilegioDao getPrivilegioDao() {
		return privilegioDao;
	}

	public void setPrivilegioDao(PrivilegioDao privilegioDao) {
		this.privilegioDao = privilegioDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	
	
}
