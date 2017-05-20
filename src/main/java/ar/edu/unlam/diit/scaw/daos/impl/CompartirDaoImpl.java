package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
		
		String sql = "INSERT INTO Usuario_Privilegio_Tarea (id_usuario,id_tarea,id_privilegio) VALUES (:id_usuario,:id_tarea,2)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		
		jdbcTemplate.update(sql, params);
		
		return true;
	}
	
	@Override
	public boolean eliminarColaborador(Integer idTarea,Integer idUsuario){
		String sql = "UPDATE Usuario_Privilegio_Tarea SET estado_colaborador = FALSE WHERE id_usuario = :id_usuario AND id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		
		jdbcTemplate.update(sql, params);
		
		return true;
	}
	
	@Override
	public boolean actualizarColaborador(Integer idTarea,Integer idUsuario,Boolean nuevoEstado){
		String sql = "UPDATE Usuario_Privilegio_Tarea SET estado_colaborador = :nuevoEstado WHERE id_usuario = :id_usuario AND id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		params.put("nuevoEstado",nuevoEstado);
		
		jdbcTemplate.update(sql, params);
		
		return true;
	}
	
	@Override
	public boolean existeColaborador(Integer idTarea,Integer idUsuario){
		String sql = "SELECT estado_colaborador FROM Usuario_Privilegio_Tarea WHERE id_usuario = :id_usuario AND id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea",idTarea);
		params.put("id_usuario",idUsuario);
		
		List<Boolean> resultado = jdbcTemplate.query(sql,params,new PersonMapperColaborador());
		
		// Si la consulta devuelve un resultado, retorna TRUE (quiere decir que ya existía este usuario como colaborador)
		if(resultado != null && !resultado.isEmpty())
			return true;
		else
			return false;
	}
	
	@Override
	public List<Integer> obtenerColaboradores(Integer idTarea){
		String sql = "SELECT id_usuario FROM Usuario_Privilegio_Tarea WHERE id_tarea = :id_tarea AND estado_colaborador = TRUE";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea",idTarea);
		
		List<Integer> result = jdbcTemplate.query(sql,params,new PersonMapper());

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
			
			Integer colaborador = rs.getInt("id_usuario");
			
			return colaborador;
		}
	}
	
	private static final class PersonMapperColaborador implements RowMapper<Boolean> {

		public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Boolean estado = rs.getBoolean("estado_colaborador");
			
			return estado;
		}
	}
	
	@Override
	public void autoasignarUsuarioATareaGlobal(Integer idUsuario,Integer idTarea) {
			
		String sql = "INSERT INTO Usuario_Privilegio_Tarea (id_usuario,id_tarea,id_privilegio) VALUES (:id_usuario,:id_tarea,2)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_usuario",idUsuario);
		params.put("id_tarea",idTarea);
		
		jdbcTemplate.update(sql, params);
	}

}
