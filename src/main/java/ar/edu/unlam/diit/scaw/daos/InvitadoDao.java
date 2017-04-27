package ar.edu.unlam.diit.scaw.daos;

import java.util.LinkedList;

import ar.edu.unlam.diit.scaw.entities.Invitado;

public interface InvitadoDao {
	
	public LinkedList<Invitado> consultarInvitadosTarea(Integer idTarea);

	public boolean agregarInvitados(LinkedList<Integer> idInvitados,LinkedList<Integer> idTareas,LinkedList<Integer> idPrivilegios);

	public boolean modificarPrivilegioInvitado(Integer idInvitado,Integer idTarea,Integer idPrivilegio);

	public boolean borrarInvitado(Integer idInvitado,Integer idTarea,Integer idPrivilegio);
}