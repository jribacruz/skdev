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

import br.skdev.core.model.ETemplate;

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
	public ETemplate insert(ETemplate eTemplate) {
		final String insertActionSQL = " INSERT INTO SK_TEMPLATE(NAME, DESCRIPTION, ACTION_ID) VALUES(?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(insertActionSQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, eTemplate.getName());
				ps.setString(2, eTemplate.getDescription());
				ps.setInt(3, eTemplate.getActionId());
				return ps;
			}
		}, holder);
		int newTemplateId = holder.getKey().intValue();
		eTemplate.setId(newTemplateId);
		return eTemplate;
	}
	
	/**
	 * 
	 * @param id
	 * @param eTemplate
	 */
	@Transactional
	public void update(Integer id, ETemplate eTemplate) {
		// @formatter:off
		final String updateActionSQL = " UPDATE SK_TEMPLATE "
				+ "							SET NAME=?, "
				+ "								DESCRIPTION=?, "
				+ "								CONTENT=? "
				+ "						 WHERE ID = ? ";
		//@formatter:on
		jdbcTemplate.update(updateActionSQL, new Object[] { eTemplate.getName(), eTemplate.getDescription(), eTemplate.getContent(), id });
	}

}
