package ar.edu.unlam.diit.scaw.services;

import java.util.LinkedList;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface PrivilegioService {
	
	public LinkedList<Usuario> listarUsuariosColaboradores(Integer idTarea);

	public void cambiarPrivilegio(Integer idTarea,String nombreUsuario);

}
