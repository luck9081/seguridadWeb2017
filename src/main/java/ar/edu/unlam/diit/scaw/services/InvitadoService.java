package ar.edu.unlam.diit.scaw.services;

import java.util.LinkedList;

import ar.edu.unlam.diit.scaw.entities.Invitado;

public interface InvitadoService {

	public LinkedList<Invitado> consultarInvitadosTarea(Integer idTarea);
	
	public boolean agregarInvitados(LinkedList<Invitado> nuevosInvitados);
	
	public boolean modificarPrivilegioInvitado(LinkedList<Invitado> invitadoModificado);
	
	public boolean borrarInvitado(LinkedList<Invitado> invitadoBorrado);

}
