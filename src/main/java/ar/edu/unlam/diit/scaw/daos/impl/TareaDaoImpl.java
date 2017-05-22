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
	
	@Override
	public void editarTarea(Tarea tarea) {

		String sql = "UPDATE Tarea SET descripcion=:descripcion WHERE id_tarea=:id_tarea";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea", tarea.getId_tarea());
		params.put("descripcion", tarea.getDescripcion());
		jdbcTemplate.update(sql, params);

	}

	public List<TareaBean> listarTareasPendientes(Integer id){

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea WHERE id_usuario=:id_usuario AND id_estado_tarea=1 ORDER BY id_tarea";

		params.put("id_usuario", id);

		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;

	}

	public List<TareaBean> listarTareasPendientesCompartidas(Integer idUsuario){

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT TAR.id_tarea,TAR.descripcion,TAR.id_modo_acceso,UPT.id_usuario,UPT.id_privilegio FROM Usuario_Privilegio_Tarea UPT JOIN Tarea TAR ON UPT.id_tarea=TAR.id_tarea  WHERE UPT.id_usuario=:id_usuario AND TAR.id_estado_tarea=1;";

		params.put("id_usuario", idUsuario);

		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper2());

		return result;

	}

	@Override
	public int actualizarTarea(TareaBean tarea, Integer idUsuario){
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "INSERT INTO Usuario_Privilegio_Tarea(id_usuario,id_tarea,id_privilegio) VALUES (:id_usuario,:id_tarea,2);";

		params.put("id_usuario", idUsuario);
		params.put("id_tarea", tarea.getId_tarea());

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


	public List<TareaBean> listarTareasCompletasCompartidas(Integer id){

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT TAR.id_tarea,TAR.descripcion,TAR.id_modo_acceso,UPT.id_usuario FROM Usuario_Privilegio_Tarea UPT JOIN Tarea TAR ON UPT.id_tarea=TAR.id_tarea  WHERE UPT.id_usuario=:id_usuario AND TAR.id_estado_tarea=2;";

		params.put("id_usuario", id);

		List<TareaBean> result = jdbcTemplate.query(sql, params, new PersonMapper());

		return result;

	}

	@Override
	public List<TareaBean> listarTareasGlobales(Integer id_usuario) {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM Tarea WHERE id_modo_acceso=1 and id_usuario <> :id_usuario";
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

	public void eliminarTarea(Integer idTarea){

		String sql2 = "DELETE FROM Usuario_Privilegio_Tarea WHERE id_tarea = :id_tarea";
		String sql = "DELETE FROM Tarea WHERE id_tarea = :id_tarea";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea", idTarea);
		jdbcTemplate.update(sql2, params);
		jdbcTemplate.update(sql, params);

	}

	@Override
	public void modificarModoAccesoAPublico(Integer idTarea) {

		String sql = "UPDATE Tarea SET id_modo_acceso=1 WHERE id_tarea=:id_tarea";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea", idTarea);
		jdbcTemplate.update(sql, params);



	}

	public void modificarModoAccesoAPrivado(Integer idTarea) {

		String sql = "UPDATE Tarea SET id_modo_acceso=2 WHERE id_tarea=:id_tarea";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_tarea", idTarea);
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

	private static final class PersonMapper2 implements RowMapper<TareaBean> {

		public TareaBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TareaBean tareaBean = new TareaBean();

			tareaBean.setId_tarea(rs.getInt("id_tarea"));
			tareaBean.setDescripcion(rs.getString("descripcion"));
			tareaBean.setId_modo_acceso_int(rs.getInt("id_modo_acceso"));
			tareaBean.setId_usuario(rs.getInt("id_usuario"));
			tareaBean.setId_privilegio(rs.getInt("id_privilegio"));

			return tareaBean;
		}
	}




}
