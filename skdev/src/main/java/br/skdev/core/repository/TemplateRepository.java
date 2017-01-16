package br.skdev.core.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.skdev.core.domain.Template;

@Repository
public class TemplateRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = LoggerFactory.getLogger(TemplateRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @param eTemplate
	 */
	@Transactional
	public Template insert(Template eTemplate) {
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param eTemplate
	 */
	@Transactional
	public void update(Integer id, Template eTemplate) {
		// @formatter:off
		final String updateTemplateSQL = " UPDATE SK_TEMPLATE "
				+ "							SET NAME=?, "
				+ "								DESCRIPTION=?, "
				+ "								CONTENT=? "
				+ "						 WHERE ID = ? ";
		//@formatter:on
		jdbcTemplate.update(updateTemplateSQL,
				new Object[] { eTemplate.getName(), eTemplate.getDescription(), eTemplate.getContent(), id });
	}

	/**
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Integer id) {
		final String deleteTemplateSQL = " DELETE FROM SK_TEMPLATE WHERE ID = ?";
		jdbcTemplate.update(deleteTemplateSQL, id);
	}

}
