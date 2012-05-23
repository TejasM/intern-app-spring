package org.jboss.tools.examples.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jboss.tools.examples.domain.Intern;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class JdbcInternDao extends SimpleJdbcDaoSupport implements InternDao {

	@Override
	public List<Intern> getInternList() {
		// TODO Auto-generated method stub
		List<Intern> interns = getSimpleJdbcTemplate().query(
                "select name, email from interns", 
                new InternMapper());
        return interns;
	}

	@Override
	public void addIntern(String name, String email) {
		// TODO Auto-generated method stub
		getSimpleJdbcTemplate().update("insert into interns (NAME, EMAIL) VALUES (?, ?)", name, email);
	}
	
	private static class InternMapper implements ParameterizedRowMapper<Intern> {

        public Intern mapRow(ResultSet rs, int rowNum) throws SQLException {
            Intern prod = new Intern();
            prod.setName(rs.getString("name"));
            prod.setEmail(rs.getString("email"));
            return prod;
        }

    }

}
