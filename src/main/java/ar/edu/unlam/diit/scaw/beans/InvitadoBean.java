package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

@ManagedBean(name = "usuarioBean", eager = true)
@RequestScoped
public class InvitadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idInvitado;
	private Integer idTarea;
	private Integer idPrivilegio;

	
	//Spring Inject
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	
	UsuarioService service = (UsuarioService) context.getBean("usuarioService");
	
	
	public InvitadoBean() {
		super();
	}
	
	public InvitadoBean(Integer idInvitado, Integer idTarea, Integer idPrivilegio) {
		super();
		this.idInvitado = idInvitado;
		this.idTarea = idTarea;
		this.idPrivilegio = idPrivilegio;
	}


}
