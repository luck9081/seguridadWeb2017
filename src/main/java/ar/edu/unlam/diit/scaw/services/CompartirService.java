package ar.edu.unlam.diit.scaw.services;

import java.util.LinkedList;

import ar.edu.unlam.diit.scaw.beans.ColaboradorBean;

public interface CompartirService {
	
	public LinkedList<ColaboradorBean> listarUsuariosParaCompartir(Integer idTarea,Integer miIdUsuario);

	public boolean compartirTarea(Integer idTarea,String nombreUsuario);
	
	public boolean eliminarColaborador(Integer idTarea,String nombreUsuario);

}
