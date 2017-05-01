package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public class TareaDaoImpl implements TareaDao {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public TareaDaoImpl(){
		super();
	}
	

	@Override
	public void crearTarea(Tarea tarea) {
		
		
		String sql = "INSERT INTO Tarea (descripcion,id_modo_acceso,id_estado_tarea) VALUES (:descripcion, :id_modo_acceso,:id_estado_tarea)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("descripcion", tarea.getDescripcion());
		params.put("id_modo_acceso", tarea.getId_modo_acceso());
		params.put("id_estado_tarea", tarea.getId_estado_tarea());
		jdbcTemplate.update(sql, params);
		
	}
	
	public List<Tarea> listarTareas(Integer id){
		
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea WHERE id_usuario=:id";
		
		params.put("id_usuario", id);

		List<Tarea> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;
		
	}


	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	private static final class PersonMapper implements RowMapper<Tarea> {

		public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tarea tarea = new Tarea();
			tarea.setDescripcion(rs.getString("descripcion"));
			tarea.setId_modo_acceso(rs.getInt("id_modo_acceso"));

	
			return tarea;
		}
	}


}
