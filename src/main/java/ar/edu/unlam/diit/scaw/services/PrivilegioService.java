package ar.edu.unlam.diit.scaw.services;

import java.util.LinkedList;

import ar.edu.unlam.diit.scaw.beans.ColaboradorBean;

public interface PrivilegioService {
	
	public LinkedList<ColaboradorBean> listarColaboradoresYPrivilegios(Integer idTarea);

	public boolean cambiarPrivilegio(Integer idTarea,String nombreUsuario,Integer nuevoPrivilegio);

}
