package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unlam.diit.scaw.services.UsuarioService;

@ManagedBean(name = "controller", eager = true)
@RequestScoped
public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;

		
	//Spring Inject
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	UsuarioService service = (UsuarioService) context.getBean("usuarioService");

	
	public Controller() {
		super();
	}
	
	public String usuarioHome(){
		return "usuario";
	}
	
	public String adminHome(){
		return "admin";
	}
	
	public String compartir(){
		return "compartir";
	}
	
	public String privilegios(){
		return "privilegios";
	}
	
	public String login(){
		return "usuario";
	}
	
	public void logout(){
		
	}
	
	public String registro(){
		return "index";
	}
	
	public void crearTarea(){
		
	}


}
