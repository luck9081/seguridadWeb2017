package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.InvitadoDao;
import ar.edu.unlam.diit.scaw.entities.Invitado;

public class InvitadoDaoImpl implements InvitadoDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public InvitadoDaoImpl() {
		super();
	}

	@Override
	public LinkedList<Invitado> consultarInvitadosTarea(Integer idTarea){
		return new LinkedList<Invitado>();
	}

	@Override
	public boolean agregarInvitados(LinkedList<Integer> idInvitados,LinkedList<Integer> idTareas,LinkedList<Integer> idPrivilegios){
		return true;
	}

	@Override
	public boolean modificarPrivilegioInvitado(Integer idInvitado,Integer idTarea,Integer idPrivilegio){
		return true;
	}

	@Override
	public boolean borrarInvitado(Integer idInvitado,Integer idTarea,Integer idPrivilegio){
		return true;
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*private static final class PersonMapper implements RowMapper<Usuario> {

		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("pass"));
			usuario.setId_estado_usuario(rs.getInt("id_estado_usuario"));
			usuario.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
	
			return usuario;
		}
	}*/

}
