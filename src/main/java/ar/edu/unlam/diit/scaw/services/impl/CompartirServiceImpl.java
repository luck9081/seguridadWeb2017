package ar.edu.unlam.diit.scaw.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.beans.ColaboradorBean;
import ar.edu.unlam.diit.scaw.daos.CompartirDao;
import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.CompartirService;

public class CompartirServiceImpl implements CompartirService {

	@Autowired
	CompartirDao compartirDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public LinkedList<ColaboradorBean> listarUsuariosParaCompartir(Integer idTarea,Integer miIdUsuario){
		
		// Traemos a todos los usuarios
		List<Usuario> listaUsuarios = usuarioDao.findAll();
		
		// Armamos una lista que los contendrá a todos (menos a mí) formateados con InvitadoBean, y un objeto InvitadoBean que servirá para añadirlos a la lista
		LinkedList<ColaboradorBean> listaCompartidos = new LinkedList<ColaboradorBean>();	// acá iría un linkedlist invitado o algo así con dos campos por fila
		ColaboradorBean colaborador = new ColaboradorBean();
		
		for (Usuario item : listaUsuarios){		    
			if(!item.getIdUsuario().equals(miIdUsuario)){ // Si en el listado aparece mi usuario, no lo añado (no puedo compartir mi tarea conmigo)
				
				// Si ya se ha compartido la tarea con este usuario, seteamos "estadoInvitado" del item InvitadoBean en True
				if(comprobarColaboradores(idTarea,item.getIdUsuario())){ // "comprobarColaboradores" es un método local
					colaborador.setEstadoInvitado(true);
			    }
			    else{
			    	colaborador.setEstadoInvitado(false);
			    }
				colaborador.setNombreInvitado(item.getNombre());				
				listaCompartidos.add(colaborador);
			}
		}
		
		return listaCompartidos;
	}

	@Override
	public boolean compartirTarea(Integer idTarea,String nombreUsuario){
		// NOTA: (REALIZAR) consumir servicio de usuario que, a partir del nombre de usuario, obtenga el ID
		Integer idUsuario = 0;
		return compartirDao.insertarColaborador(idTarea, idUsuario);
	}
	
	@Override
	public boolean eliminarColaborador(Integer idTarea,String nombreUsuario){
		// NOTA: (REALIZAR) consumir servicio de usuario que, a partir del nombre de usuario, obtenga el ID
		Integer idUsuario = 0;
		return compartirDao.eliminarColaborador(idTarea, idUsuario);
	}
	
	public boolean comprobarColaboradores(Integer idTarea,Integer idUsuario){
		LinkedList<Integer> listadoColaboradores = compartirDao.obtenerColaboradores(idTarea);
		boolean flag = false;
		for (Integer item : listadoColaboradores){
			if(item.equals(idUsuario)){
				flag = true;
			}
		}		
		return flag;
	}

}
