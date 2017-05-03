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
import ar.edu.unlam.diit.scaw.entities.TareaPorUsuario;

public class PrivilegioDaoImpl implements PrivilegioDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public PrivilegioDaoImpl() {
		super();
	}
	
	@Override
	public List<TareaPorUsuario> colaboradoresYPrivilegios(Integer idTarea){
		String sql = "SELECT id_usuario,id_privilegio FROM Usuario_Tarea_Privilegio WHERE id_tarea = :id_tarea";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea",idTarea);
		
		List<TareaPorUsuario> result = jdbcTemplate.query(sql,params,new PersonMapper());

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

	private static final class PersonMapper implements RowMapper<TareaPorUsuario> {

		public TareaPorUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			TareaPorUsuario colaborador = new TareaPorUsuario();
			colaborador.setIdUsuario(rs.getInt("id_usuario"));
			colaborador.setIdPrivilegio(rs.getInt("id_privilegio"));
			
			return colaborador;
		}
	}

}
