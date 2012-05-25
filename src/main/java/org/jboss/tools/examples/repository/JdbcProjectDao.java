package org.jboss.tools.examples.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.tools.examples.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class JdbcProjectDao implements ProjectDao {

	@Autowired
	private EntityManager em;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Project> criteria = cb.createQuery(Project.class);
        Root<Project> project = criteria.from(Project.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */
        
    	

        criteria.select(project).orderBy(cb.asc(project.get("name")));
        return em.createQuery(criteria).getResultList();
	}
	

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		logger.info(project.getName() + " " + project.getMaxPeople());
		em.persist(project);
		logger.info(em.contains(project));
	}
	
	@Override
	public Project getProject(String name) {
		// TODO Auto-generated method stub
		return em.find(Project.class, name);
	}

}
