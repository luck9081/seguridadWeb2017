package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
	public boolean loguear(Usuario usuario) {
		
		this.findAll().equals(usuario);
		
		return true;
	}
	
	//No borra el user, le cambia el estado a 'baja'
	@Override
	public boolean borrar(Integer idUsuario){
		return true;
	}
	
	@Override
	public boolean editar(Integer idUsuario){
		return true;		
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
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("pass"));
			usuario.setId_estado_usuario(rs.getInt("id_estado_usuario"));
			usuario.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
	
			return usuario;
		}
	}




}
