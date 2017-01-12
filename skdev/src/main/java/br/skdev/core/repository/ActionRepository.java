package br.skdev.core.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.skdev.core.model.EAction;
import br.skdev.core.model.EGroup;
import br.skdev.core.model.ETemplate;

@Repository
public class ActionRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = LoggerFactory.getLogger(ActionRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Retorna todas as actions.
	 * 
	 * @return
	 */
	public List<EAction> findAll() {
		//// @formatter:off
		String sql = "select ac.*, tm.*, gp.* from SK_ACTION ac "
				+ "		left join SK_TEMPLATE tm on (tm.action_id = ac.id) "
				+ "		left join SK_ACTION_GROUP ac_gp on (ac_gp.action_id = ac.id) "
				+ "		left join SK_GROUP gp on (ac_gp.group_id = gp.id) ";
		// @formatter:on
		return jdbcTemplate.query(sql, (rs) -> {
			Map<Integer, EAction> eActionsMap = new HashMap<>();
			EAction eAction = new EAction();

			while (rs.next()) {
				Integer actionId = rs.getInt("ac.id");
				eAction = eActionsMap.get(actionId);
				if (eAction == null) {
					eAction = new EAction();
					eAction.setId(rs.getInt("ac.id"));
					eAction.setDescription(rs.getString("ac.description"));
					eAction.setName(rs.getString("ac.name"));
					eAction.setCreatedAt(rs.getTimestamp("ac.created_at"));
					eAction.setDialogHTML(rs.getString("ac.dialoghtml"));
					eAction.setExecuteJS(rs.getString("ac.executejs"));
					eActionsMap.put(eAction.getId(), eAction);
				}
				// Add os templates a action
				Integer templateId = rs.getInt("tm.id");
				if (templateId > 0) {
					ETemplate eTemplate = new ETemplate();
					eTemplate.setId(rs.getInt("tm.id"));
					eTemplate.setName(rs.getString("tm.name"));
					eTemplate.setCreatedAt(rs.getTimestamp("tm.created_at"));
					eTemplate.setDescription(rs.getString("tm.description"));
					eTemplate.setContent(rs.getString("tm.content"));
					eTemplate.setActionId(rs.getInt(rs.getInt("tm.action_id")));
					eAction.getTemplates().put(eTemplate.getName(), eTemplate);
				}

				// Add os groups a action
				Integer groupId = rs.getInt("gp.id");
				if (groupId > 0) {
					EGroup eGroup = new EGroup();
					eGroup.setId(rs.getInt("gp.id"));
					eGroup.setName(rs.getString("gp.name"));
					eAction.getGroups().add(eGroup);
				}
			}

			return new ArrayList<>(eActionsMap.values());
		});
	}

	public EAction find(Integer id) {
		//// @formatter:off
		String sql = "select ac.*, tm.*, gp.* from SK_ACTION ac "
				+ "		left join SK_TEMPLATE tm on (tm.action_id = ac.id) "
				+ "		left join SK_ACTION_GROUP ac_gp on (ac_gp.action_id = ac.id) "
				+ "		left join SK_GROUP gp on (ac_gp.group_id = gp.id)"
				+ "	  where ac.id = ? ";
		// @formatter:on
		return jdbcTemplate.query(sql, new Object[] { id }, (rs) -> {
			Map<Integer, EAction> eActionsMap = new HashMap<>();
			EAction eAction = new EAction();

			while (rs.next()) {
				Integer actionId = rs.getInt("ac.id");
				eAction = eActionsMap.get(actionId);
				if (eAction == null) {
					eAction = new EAction();
					eAction.setId(rs.getInt("ac.id"));
					eAction.setDescription(rs.getString("ac.description"));
					eAction.setName(rs.getString("ac.name"));
					eAction.setCreatedAt(rs.getTimestamp("ac.created_at"));
					eAction.setDialogHTML(rs.getString("ac.dialoghtml"));
					eAction.setExecuteJS(rs.getString("ac.executejs"));
					eActionsMap.put(eAction.getId(), eAction);
				}
				// Add os templates a action
				Integer templateId = rs.getInt("tm.id");
				if (templateId > 0) {
					ETemplate eTemplate = new ETemplate();
					eTemplate.setId(rs.getInt("tm.id"));
					eTemplate.setName(rs.getString("tm.name"));
					eTemplate.setCreatedAt(rs.getTimestamp("tm.created_at"));
					eTemplate.setDescription(rs.getString("tm.description"));
					eTemplate.setContent(rs.getString("tm.content"));
					eTemplate.setActionId(rs.getInt(rs.getInt("tm.action_id")));
					eAction.getTemplates().put(eTemplate.getName(), eTemplate);
				}

				// Add os groups a action
				Integer groupId = rs.getInt("gp.id");
				if (groupId > 0) {
					EGroup eGroup = new EGroup();
					eGroup.setId(rs.getInt("gp.id"));
					eGroup.setName(rs.getString("gp.name"));
					eAction.getGroups().add(eGroup);
				}
			}

			return new ArrayList<>(eActionsMap.values()).get(0);
		});
	}

	/**
	 * 
	 * @param eAction
	 */
	@Transactional
	public EAction insert(EAction eAction) {
		final String insertActionSQL = " INSERT INTO SK_ACTION(NAME, DESCRIPTION) VALUES(?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(insertActionSQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, eAction.getName());
				ps.setString(2, eAction.getDescription());
				return ps;
			}
		}, holder);
		int newActionId = holder.getKey().intValue();
		eAction.setId(newActionId);
		return eAction;
	}

	@Transactional
	public void update(Integer id, EAction eAction) {
		// @formatter:off
		final String updateActionSQL = " UPDATE SK_ACTION "
				+ "							SET NAME=?, "
				+ "								DESCRIPTION=?,"
				+ "								DIALOGHTML=?,"
				+ "								EXECUTEJS=?"
				+ "						 WHERE ID = ? ";
		//@formatter:on
		jdbcTemplate.update(updateActionSQL,
				new Object[] { eAction.getName(), eAction.getDescription(), eAction.getDialogHTML(), eAction.getExecuteJS(), id });
	}

}
