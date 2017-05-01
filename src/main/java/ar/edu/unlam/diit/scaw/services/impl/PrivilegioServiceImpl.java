package ar.edu.unlam.diit.scaw.services.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.PrivilegioService;

public class PrivilegioServiceImpl implements PrivilegioService {

	@Override
	public LinkedList<Usuario> listarUsuariosColaboradores(Integer idTarea){
		return new LinkedList<Usuario>();
	}
	
	@Override
	public void cambiarPrivilegio(Integer idTarea,String nombreUsuario){
		
	}

}
