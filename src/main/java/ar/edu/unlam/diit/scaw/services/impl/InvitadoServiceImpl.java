package ar.edu.unlam.diit.scaw.services.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.daos.InvitadoDao;
import ar.edu.unlam.diit.scaw.entities.Invitado;
import ar.edu.unlam.diit.scaw.services.InvitadoService;

public class InvitadoServiceImpl implements InvitadoService {

	@Autowired
	InvitadoDao invitadoDao;
	
	@Override
	public LinkedList<Invitado> consultarInvitadosTarea(Integer idTarea){
		return invitadoDao.consultarInvitadosTarea(idTarea);
	}
	
	@Override
	public boolean agregarInvitados(LinkedList<Invitado> nuevosInvitados){
		return true;
	}
	
	@Override
	public boolean modificarPrivilegioInvitado(LinkedList<Invitado> invitadoModificado){
		return true;
	}
	
	@Override
	public boolean borrarInvitado(LinkedList<Invitado> invitadoBorrado){
		return true;
	}

	public InvitadoDao getInvitadoDao() {
		return invitadoDao;
	}

	public void setInvitadoDao(InvitadoDao invitadoDao) {
		this.invitadoDao = invitadoDao;
	}

}
