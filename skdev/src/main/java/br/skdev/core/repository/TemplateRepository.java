package br.skdev.core.repository;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.skdev.core.model.ETemplate;

@Repository
public class TemplateRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ETemplate findByName(String name) {
		ETemplate eTemplate = jdbcTemplate.queryForObject("SELECT T.* FROM TEMPLATE T WHERE T.NAME = ?", new Object[] { name }, (rs, i) -> {
			return new ETemplate(rs.getInt("id"), rs.getString("name") , rs.getString("content"));
		});
		return eTemplate;
	}

}
