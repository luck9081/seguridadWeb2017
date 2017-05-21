package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

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
		
	
	/* ---- Spring Inject ---- */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	
	
	/* ---- Servicios ---- */
	UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioService");
	TareaService tareaService = (TareaService) context.getBean("tareaService");
	CompartirService compartirService = (CompartirService) context.getBean("compartirService");
	PrivilegioService privilegioService = (PrivilegioService) context.getBean("privilegioService");
	
	
	/* ---- Propiedades ---- */
	@ManagedProperty(value = "#{miSesion}")
	private SessionBean sesion;
	
	
	public Controller() {
		super();
	}
	
	
	/* ---- Vistas ---- */
	
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
		return "compartir?faces-redirect=true&idTarea="+idTarea;
	}
	
	public String privilegios(Integer idTarea){
		return "privilegios?faces-redirect=true&idTarea="+idTarea;
	}
	
	public String login(UsuarioBean usuario){
		if(usuarioService.loguear(usuario) == true){
			
			sesion.setIdUsuario(usuarioService.buscarIdUsuario(usuario.getNombre()));
			sesion.setNombre(usuario.getNombre());
			
			return usuarioHome();
		}
		else{
			return validarAdmin(usuario);
		}

	}
	
	public String logout(){
		
		
		sesion.setIdUsuario(null);
		sesion.setNombre(null);
		
		return index();
	}
	
	public String editar(UsuarioBean usuario){
			
		usuarioService.editar(usuario);
		return "usuario";
		}
	
	public String registro(UsuarioBean usuario){
		
		usuarioService.save(usuario);
		return index();
	}
	
	public void nuevoAdmin(UsuarioBean usuario){
		
		usuarioService.saveAdmin(usuario);
		return;
	}
	
	public void autoasignarUsuarioATareaGlobal(Integer idUsuario,Integer idTarea){
		compartirService.autoasignarUsuarioATareaGlobal(idUsuario, idTarea);
	
	}
	
	/* -------------------------------------------------------- */
	/* -------------------------------------------------------- */
	
	public String validarAdmin(UsuarioBean usuario){
		
		if(usuarioService.validarAdmin(usuario) == true){
			
			sesion.setNombre(usuario.getNombre());
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
	
	public String crearTarea(TareaBean tareaBean,Integer id_usuario){
	
		Tarea tarea=tareaBean.buildTarea();
		
		tareaService.crearTarea(tarea,id_usuario);
		
		return usuarioHome();
		
	}
	
	public List<TareaBean> listarTareasPendientes(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasPendientes(id_usuario);
		
		return lista;
		
	}
	
	public List<TareaBean> listarTareasPendientesCompartidas(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasPendientesCompartidas(id_usuario);
		
		return lista;
		
	}
	
	public List<TareaBean> listarTareasCompletas(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasCompletas(id_usuario);
		
		return lista;
		
	}

	public List<TareaBean> listarTareasCompletasCompartidas(Integer id_usuario){
		
		List<TareaBean> lista = tareaService.listarTareasCompletasCompartidas(id_usuario);
		
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
	
	
	
	
	/* ----------------- COMPARTIR ----------------- */
	
	public LinkedList<ColaboradorBean> listarUsuariosParaCompartir(Integer idTarea){
		return compartirService.listarUsuariosParaCompartir(idTarea,getSesion().getIdUsuario());	// te muestra los usuarios compartidos y no compartidos, no debe mostrar usuario creador
	}
	
	public String compartirTarea(){
		Integer idTarea = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTarea"));
		String nombreUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nombreUsuario");
		
		compartirService.compartirTarea(idTarea,nombreUsuario);	// agregar usuario y tarea a la ternaria		
		return compartir(idTarea);
		
		// posibilidad de hacerlo por ajax por cada usuario
	}
	
	public String eliminarColaborador(){		
		Integer idTarea = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTarea"));
		String nombreUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nombreUsuario");
		
		compartirService.eliminarColaborador(idTarea,nombreUsuario);	// el usuario ya no colaborarÃ¡ con la tarea, o sea, estado de la ternaria "false"		
		return compartir(idTarea);
		// el privilegio debe regresar a "solo lectura"
		// redirigir a vista "compartir"
		
		// posibilidad de hacerlo por ajax por cada usuario
	}
	
	
	
	
	/* ----------------- PRIVILEGIOS ----------------- */
	
	public LinkedList<ColaboradorBean> listaUsuariosPrivilegios(Integer idTarea){
		return privilegioService.listarColaboradoresYPrivilegios(idTarea);	// te muestra los usuarios invitados a esta tarea
	}
	
	public void cambiarPrivilegio(Integer idTarea,String nombreUsuario,Integer nuevoPrivilegio){
		privilegioService.cambiarPrivilegio(idTarea, nombreUsuario,nuevoPrivilegio);	// modificar privilegio en la ternaria
		
		// si es por ajax, no hace falta refrescar la pagina, esto se ejecuta por checkbox
	}

	public SessionBean getSesion() {
		return sesion;
	}

	public void setSesion(SessionBean sesion) {
		this.sesion = sesion;
	}
	
}
