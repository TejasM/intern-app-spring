package org.jboss.tools.examples.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class JdbcInternDao implements InternDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<Intern> getInternList() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Intern> criteria = cb.createQuery(Intern.class);
        Root<Intern> member = criteria.from(Intern.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).orderBy(cb.asc(member.get("email")));
        return em.createQuery(criteria).getResultList();
	}

	@Override
	public void addIntern(Intern intern) {
		// TODO Auto-generated method stub
		em.persist(intern);
	}
	
	@Override
	public Intern getIntern(String name) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Intern> criteria = builder.createQuery(Intern.class);
        Root<Intern> member = criteria.from(Intern.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(member).where(builder.equal(member.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
	}

}
