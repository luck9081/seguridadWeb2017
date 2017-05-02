package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public UsuarioDaoImpl() {
		super();
	}

	@Override
	public void save(Usuario usuario) {

		String sql = "INSERT INTO Usuario (nombre, pass, id_estado_usuario, id_tipo_usuario) VALUES (:nombre, :pass,1,2)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nombre", usuario.getNombre());
		params.put("pass", usuario.getPass());
		jdbcTemplate.update(sql, params);

	}
	
	@Override
	public LinkedList<String> listarUsuariosPorNombre(String nombre) {
		
		String sql = "SELECT pass FROM Usuario where nombre = :nombre";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nombre", nombre);
		

		LinkedList<String> result = (LinkedList<String>) jdbcTemplate.query(sql, params, new UserMapper());

		return result;
	}
	
	@Override
	public boolean loguear(Usuario usuario) {
		
		LinkedList<String> lista = listarUsuariosPorNombre(usuario.getNombre());
		boolean flag = false;
		for (String item : lista){
			if(item.equals(usuario.getPass())){
				flag = true;
			}
		}		
		return flag;

	}
	
	//No borra el user, le cambia el estado a 'baja'
	@Override
	public boolean borrar(Integer idUsuario){
		
		String sql = "UPDATE Usuario SET id_estado_usuario = 3 WHERE id_usuario :idUsuario";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
		jdbcTemplate.update(sql, params);
		
		return true;
	}
	
	@Override
	public boolean validarAdmin(Usuario admin){
		
		List<Usuario> listaAdmin = findAll();
		boolean flag = false;
		for(Usuario item : listaAdmin){
			
			if(item.equals(admin)){
				flag = true;
			}
		}
		
	return flag;
		
	}
	
	@Override
	public boolean editar(Usuario usuario){
		
		String sql = "UPDATE Usuario SET (nombre = :nombre,  pass = :pass where id_usuario :id_usuario";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nombre", usuario.getNombre());
		params.put("pass", usuario.getPass());
		params.put("id_usuario", usuario.getIdUsuario());
		jdbcTemplate.update(sql, params);
		return true;		
	}

	@Override
	public List<Usuario> listarUsuariosPendientes() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Usuario WHERE id_estado_usuario = 1";

		List<Usuario> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;
	}
	
	@Override
	public void aceptarUsuario(Integer idUsuario){
		
		String sql = "UPDATE Usuario SET id_estado_usuario = 2 WHERE id_usuario = :idUsuario";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
		jdbcTemplate.update(sql, params);
		
	}
	
	@Override
	public void denegarUsuario(Integer idUsuario){
		
		String sql = "UPDATE Usuario SET id_estado_usuario = 3 WHERE id_usuario = :idUsuario";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
		jdbcTemplate.update(sql, params);
		
	}
	
	@Override
	public List<Usuario> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Usuario";

		List<Usuario> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final class PersonMapper implements RowMapper<Usuario> {

		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("id_usuario"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("pass"));
			usuario.setId_estado_usuario(rs.getInt("id_estado_usuario"));
			usuario.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
	
			return usuario;
		}
	}
	
	private static final class UserMapper implements RowMapper<String> {

		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			String user = rs.getString("pass");	
			
			return user;
		}
	}




}
