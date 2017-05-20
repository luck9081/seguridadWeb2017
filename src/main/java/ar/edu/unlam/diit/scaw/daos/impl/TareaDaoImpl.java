package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.beans.TareaBean;
import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;

public class TareaDaoImpl implements TareaDao {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public TareaDaoImpl(){
		super();
	}
	

	@Override
	public void crearTarea(Tarea tarea,Integer id_usuario) {		
		
		String sql = "INSERT INTO Tarea (descripcion,id_modo_acceso,id_estado_tarea,id_usuario) VALUES (:descripcion, :id_modo_acceso,:id_estado_tarea,:id_autor)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("descripcion", tarea.getDescripcion());
		params.put("id_modo_acceso", tarea.getId_modo_acceso());
		params.put("id_estado_tarea", tarea.getId_estado_tarea());
		params.put("id_autor", id_usuario);
		jdbcTemplate.update(sql, params);
		
	}
	
	public List<TareaBean> listarTareasPendientes(Integer id){
		
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea WHERE id_usuario=:id_usuario AND id_estado_tarea=1";
		
		params.put("id_usuario", id);

		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;
		
	}
	
	@Override
	public int actualizarTarea(TareaBean tarea, Integer idUsuario){
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "INSERT INTO Tarea(descripcion,id_modo_acceso,id_estado_tarea,id_usuario) VALUES (:descripcion,:idModoAcceso,:idEstadoTarea,:idUsuario);";
		
		params.put("descripcion", tarea.getDescripcion());
		params.put("idModoAcceso", 1);
		params.put("idEstadoTarea", 1);
		params.put("idUsuario", idUsuario);

		return jdbcTemplate.update(sql, params);


	}
	
	@Override
	public TareaBean obtenerTarea(Integer id){
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea where id_tarea=:id_tarea";
		
		params.put("id_tarea", id);

		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result.get(0);
	}
	
	@Override
	public List<TareaBean> listarTareasCompletas(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea WHERE id_usuario=:id_usuario AND id_estado_tarea=2";
		
		params.put("id_usuario", id);

		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;
	}
	
	@Override
	public List<TareaBean> listarTareasGlobales(Integer id_usuario) {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea WHERE id_modo_acceso=1 AND id_usuario!=:id_usuario ";
		params.put("id_usuario", id_usuario);
	
		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;
	}
	
	
	
	@Override
	public void modificarEstadoTareaACompleto(Integer id) {
		
		String sql = "UPDATE Tarea SET id_estado_tarea=2 WHERE id_tarea=:id_tarea";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea", id);
		jdbcTemplate.update(sql, params);
		
		
		
	}



	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	private static final class PersonMapper implements RowMapper<TareaBean> {

		public TareaBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TareaBean tareaBean = new TareaBean();
			
			tareaBean.setId_tarea(rs.getInt("id_tarea"));
			tareaBean.setDescripcion(rs.getString("descripcion"));
			tareaBean.setId_modo_acceso_int(rs.getInt("id_modo_acceso"));
			tareaBean.setId_usuario(rs.getInt("id_usuario"));
	
			return tareaBean;
		}
	}

}
