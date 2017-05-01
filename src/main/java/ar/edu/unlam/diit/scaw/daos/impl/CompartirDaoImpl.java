package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.CompartirDao;

public class CompartirDaoImpl implements CompartirDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public CompartirDaoImpl() {
		super();
	}
	
	@Override
	public boolean insertarColaborador(Integer idTarea,Integer idUsuario){
		
		String sql = "INSERT INTO Usuario_Privilegio_Tarea (id_usuario,id_tarea) VALUES (:id_usuario,:id_tarea)";
		
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		
		jdbcTemplate.update(sql, params);
		
		return true;
	}
	
	@Override
	public boolean eliminarColaborador(Integer idTarea,Integer idUsuario){
		String sql = "UPDATE Usuario_Privilegio_Tarea SET estado = FALSE WHERE id_usuario = :id_usuario AND id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		
		jdbcTemplate.update(sql, params);
		
		return true;
	}
	
	@Override
	public LinkedList<Integer> obtenerColaboradores(Integer idTarea){
		String sql = "SELECT id_usuario FROM Usuario_Tarea_Privilegio WHERE id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea",idTarea);
		
		LinkedList<Integer> result = (LinkedList<Integer>)jdbcTemplate.query(sql,params,new PersonMapper());

		return result;
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final class PersonMapper implements RowMapper<Integer> {

		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Integer listadoIdColaboradores = rs.getInt("id_usuario");	
			
			return listadoIdColaboradores;
		}
	}

}
