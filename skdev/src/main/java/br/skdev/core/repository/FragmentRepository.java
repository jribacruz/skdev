package br.skdev.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.skdev.core.model.EFragment;

@Repository
public class FragmentRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<EFragment> findAll() {
		final String findAllSQL = "SELECT * FROM SK_FRAGMENT ";
		return jdbcTemplate.query(findAllSQL, (rs, i) -> {
			EFragment fragment = new EFragment();
			fragment.setId(rs.getInt("ID"));
			fragment.setName(rs.getString("NAME"));
			fragment.setFragment(rs.getString("FRAGMENT"));
			return fragment;
		});

	}

}
