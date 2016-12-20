package br.skdev.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.skdev.core.model.EWorkspace;
import br.skdev.core.proxy.EWorkspaceProxy;
import br.skdev.core.util.FS;

@Repository
public class WorkspaceRepository {

	private Logger log = LoggerFactory.getLogger(WorkspaceRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FS fs;

	public EWorkspace findWorkspace() {
		String q = "SELECT * FROM WORKSPACE W";
		try {
			return jdbcTemplate.queryForObject(q, new RowMapper<EWorkspace>() {
				@Override
				public EWorkspace mapRow(ResultSet rs, int arg1) throws SQLException {
					return new EWorkspaceProxy(fs,rs.getString("path"));
				}
			});
		} catch (EmptyResultDataAccessException e) {
			log.info("Nenhum workspace encontrado");
		}
		return null;
	}

	public int updateWorkspace(String path) {
		String q = "UPDATE WORKSPACE SET PATH=? WHERE PATH=?";
		return jdbcTemplate.update(q, path, path);
	}

	public int insertWorkspace(String path) {
		String q = "INSERT INTO WORKSPACE(PATH) VALUES(?)";
		return jdbcTemplate.update(q, path);
	}

}
