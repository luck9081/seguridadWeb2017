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
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre = null;
	private String pass = null;

	
	//Spring Inject
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	UsuarioService service = (UsuarioService) context.getBean("personService");
	
	
	public UsuarioBean() {
		super();
	}
	
	public String save() {
		
		Usuario usuario = buildPerson();
		
		service.save(usuario);
		
		return "welcome";
	}
	
	public String delete(Integer id){
		
		/*if(this.es_admin==1){
			
		return "borrado";
		
		}else{
			
		return "No borre nada";
			
		}*/
		
		return "metodo no implementando";
	}
	
	
	public List<Usuario> getFindAll() {
		List<Usuario> list = service.findAll();
		return list;
	}
	
	private Usuario buildPerson() {
		Usuario usuario = new Usuario();
		usuario.setNombre(this.nombre);
		usuario.setPass(this.pass);		
		return usuario;
	}

	public UsuarioBean(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}
