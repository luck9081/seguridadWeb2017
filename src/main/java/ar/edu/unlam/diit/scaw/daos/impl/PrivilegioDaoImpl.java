package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.PrivilegioDao;
import ar.edu.unlam.diit.scaw.entities.Usuario_Privilegio_Tarea;

public class PrivilegioDaoImpl implements PrivilegioDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public PrivilegioDaoImpl() {
		super();
	}
	
	@Override
	public List<Usuario_Privilegio_Tarea> colaboradoresYPrivilegios(Integer idTarea){
		String sql = "SELECT id_usuario,id_privilegio,id_tarea,estado_colaborador FROM Usuario_Privilegio_Tarea WHERE id_tarea = 1 AND estado_colaborador = TRUE";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea",idTarea);
		
		List<Usuario_Privilegio_Tarea> result = jdbcTemplate.query(sql,params,new PersonMapper());

		return result;
	}
	
	@Override
	public boolean cambiarPrivilegio(Integer idTarea,Integer idUsuario,Integer nuevoPrivilegio){
		String sql = "UPDATE Usuario_Privilegio_Tarea SET id_privilegio = :id_privilegio WHERE id_usuario = :id_usuario AND id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		params.put("id_privilegio",nuevoPrivilegio);
		
		jdbcTemplate.update(sql, params);
		
		return true;
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final class PersonMapper implements RowMapper<Usuario_Privilegio_Tarea> {

		public Usuario_Privilegio_Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Usuario_Privilegio_Tarea colaborador = new Usuario_Privilegio_Tarea();
			colaborador.setId_usuario(rs.getInt("id_usuario"));
			colaborador.setId_privilegio(rs.getInt("id_privilegio"));
			colaborador.setId_tarea(rs.getInt("id_tarea"));
			colaborador.setEstado_colaborador(rs.getBoolean("estado_colaborador"));
			
			return colaborador;
		}
	}

}
