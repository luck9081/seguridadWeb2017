package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.CompartirService;
import ar.edu.unlam.diit.scaw.services.PrivilegioService;
import ar.edu.unlam.diit.scaw.services.TareaService;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

@ManagedBean(name = "controller", eager = true)
@RequestScoped
public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	//Spring Inject
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	
	//Servicios
	
	UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioService");
	TareaService tareaService = (TareaService) context.getBean("tareaService");
	CompartirService compartirService = (CompartirService) context.getBean("compartirService");
	PrivilegioService privilegioService = (PrivilegioService) context.getBean("privilegioService");
	
	public Controller() {
		super();
	}
	
	/* ---- VISTAS ---- */
	
	public String index(){
		return "index?faces-redirect=true";
	}
	
	public String usuarioHome(){
		return "usuario?faces-redirect=true";
	}
	
	public String adminHome(){
		return "admin?faces-redirect=true";
	}
	
	public String compartir(Integer idTarea){
		return "compartir?faces-redirect=true&id="+idTarea;
	}
	
	public String privilegios(Integer idTarea){
		return "privilegios?faces-redirect=true&id="+idTarea;
	}
	
	public String login(UsuarioBean usuario){
		if(usuarioService.loguear(usuario) == true){
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("usuario", usuario.getNombre());
			return usuarioHome();
		}
		else{
			return index();
		}
	}
	
	public String logout(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.removeAttribute("usuario");
		
		return "index";
	}
	
	public String editar(UsuarioBean usuario){
			
		usuarioService.editar(usuario);
		return "usuario";
		}
	
	public String registro(UsuarioBean usuario){
		
		usuarioService.save(usuario);
		return index();
	}
	
	/* -------------------------------------------------------- */
	/* -------------------------------------------------------- */
	
	public String validarAdmin(UsuarioBean usuario){
		
		if(usuarioService.validarAdmin(usuario) == true){
			
			return adminHome();
		}
		else{
			return index();
		}
	}
	
	public List<Usuario> listarUsuariosPendientes(){
		
		List<Usuario> lista = usuarioService.listarUsuariosPendientes();
		
		return lista;
		
	}
	
	public void aceptarUsuario(Integer idUsuario){
		
		usuarioService.aceptarUsuario(idUsuario);
	}
	
	public void denegarUsuario(Integer idUsuario){
		
		usuarioService.denegarUsuario(idUsuario);
	}
	
	public String crearTarea(TareaBean tareaBean){
	
		Tarea tarea=tareaBean.buildTarea();
		
		tareaService.crearTarea(tarea);
		
		return usuarioHome();
		
	}
	
	public List<TareaBean> listarTareasPendientes(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasPendientes(id_usuario);
		
		return lista;
		
	}
	
	public List<TareaBean> listarTareasCompletas(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasCompletas(id_usuario);
		
		return lista;
		
	}
	
	public List<TareaBean> listarTareasGlobales(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasGlobales(id_usuario);
		
		return lista;
		
	}
	
	public String modificarEstadoTareaACompleto(Integer id_tarea){
		tareaService.modificarEstadoTareaACompleto(id_tarea);
		
		return "usuario";
	}
	
	public LinkedList<ColaboradorBean> listarUsuariosParaCompartir(Integer idTarea,Integer idAutor){
		return compartirService.listarUsuariosParaCompartir(idTarea,idAutor);	// te muestra los usuarios compartidos y no compartidos, no debe mostrar usuario creador
	}
	
	public void compartirTarea(Integer idTarea,String nombreUsuario){
		compartirService.compartirTarea(idTarea,nombreUsuario);	// aÃ±adir usuario y tarea a la ternaria
		
		// posibilidad de hacerlo por ajax por cada usuario
	}
	
	public void eliminarColaborador(Integer idTarea,String nombreUsuario){
		
		compartirService.eliminarColaborador(idTarea,nombreUsuario);	// el usuario ya no colaborarÃ¡ con la tarea, o sea, estado de la ternaria "false"
		
		// el privilegio debe regresar a "solo lectura"
		// redirigir a vista "compartir"
		
		// posibilidad de hacerlo por ajax por cada usuario
	}
	
	public LinkedList<ColaboradorBean> listaUsuariosPrivilegios(Integer idTarea){
		return privilegioService.listarColaboradoresYPrivilegios(idTarea);	// te muestra los usuarios invitados a esta tarea
	}
	
	public void cambiarPrivilegio(Integer idTarea,String nombreUsuario,Integer nuevoPrivilegio){
		privilegioService.cambiarPrivilegio(idTarea, nombreUsuario,nuevoPrivilegio);	// modificar privilegio en la ternaria
		
		// si es por ajax, no hace falta refrescar la pagina, esto se ejecuta por checkbox
	}


}
