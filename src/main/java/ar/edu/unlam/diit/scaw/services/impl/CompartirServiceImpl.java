package ar.edu.unlam.diit.scaw.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.beans.ColaboradorBean;
import ar.edu.unlam.diit.scaw.beans.TareaBean;
import ar.edu.unlam.diit.scaw.daos.CompartirDao;
import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.CompartirService;

public class CompartirServiceImpl implements CompartirService {

	@Autowired
	CompartirDao compartirDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	TareaDao tareaDao;
	
	@Override
	public LinkedList<ColaboradorBean> listarUsuariosParaCompartir(Integer idTarea,Integer miIdUsuario){
		
		// Traemos a todos los usuarios
		List<Usuario> listaUsuarios = usuarioDao.findAll();
		
		// Armamos una lista que los contendrá a todos (menos a mí) formateados con ColaboradorBean, y un objeto InvitadoBean que servirá para añadirlos a la lista
		LinkedList<ColaboradorBean> listaCompartidos = new LinkedList<ColaboradorBean>();	// acá iría un linkedlist invitado o algo así con dos campos por fila
		ColaboradorBean colaborador = new ColaboradorBean();
		
		for (Usuario item : listaUsuarios){
			if(!item.getIdUsuario().equals(miIdUsuario)){ // Si en el listado aparece mi usuario, no lo añado (no puedo compartir mi tarea conmigo)
				
				// Si ya se ha compartido la tarea con este usuario, seteamos "estadoInvitado" del item InvitadoBean en True
				if(comprobarColaborador(idTarea,item.getIdUsuario())){ // "comprobarColaboradores" es un método local
					colaborador.setEstadoColaborador(true);
			    }
			    else{
			    	colaborador.setEstadoColaborador(false);
			    }
				colaborador.setNombreColaborador(item.getNombre());
				listaCompartidos.add(colaborador);
				colaborador = new ColaboradorBean();
			}
		}
		return listaCompartidos;
	}

	@Override
	public boolean compartirTarea(Integer idTarea,String nombreUsuario){
		Integer idUsuario = usuarioDao.buscarIdUsuario(nombreUsuario);
		
		TareaBean tarea = tareaDao.obtenerTarea(idTarea);
		int x = tareaDao.actualizarTarea(tarea, idUsuario);
		if(compartirDao.existeColaborador(idTarea,idUsuario)) // Si este método es llamado y el colaborador ya estaba registrado, quiere decir que estaba con estado FALSE
			return compartirDao.actualizarColaborador(idTarea,idUsuario,true); // Por lo que simplemente se lo actualiza a TRUE
		else
			return compartirDao.insertarColaborador(idTarea,idUsuario); // Por el contrario, si el colaborador no estaba registrado en la tabla, se hace un INSERT
	}
	
	@Override
	public boolean eliminarColaborador(Integer idTarea,String nombreUsuario){
		Integer idUsuario = usuarioDao.buscarIdUsuario(nombreUsuario);
		
		// Para des-compartir un usuario, primeramente debe haber estado compartido
		// por lo que ya habia sido registrado en la ternaria. Solo se actualiza a FALSE
		return compartirDao.actualizarColaborador(idTarea,idUsuario,false);
	}
	
	public boolean comprobarColaborador(Integer idTarea,Integer idUsuario){
		// Devuelve un listado de colaboradores (registros en ternaria con campo "estado_colaborador = TRUE"
		List<Integer> listadoColaboradores = compartirDao.obtenerColaboradores(idTarea);
		
		boolean flag = false;
		
		for (Integer item : listadoColaboradores){
			// Si el usuario a corroborar figura en la ternaria, flag es TRUE
			if(item.equals(idUsuario)){
				flag = true;
				break;
			}
		}		
		return flag;
	}
	
	@Override
	public void autoasignarUsuarioATareaGlobal(Integer idUsuario,Integer idTarea) {
		compartirDao.autoasignarUsuarioATareaGlobal(idUsuario, idTarea);
		
	}
	
	//GETTERS Y SETTERS

	public CompartirDao getCompartirDao() {
		return compartirDao;
	}

	public void setCompartirDao(CompartirDao compartirDao) {
		this.compartirDao = compartirDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	

}
