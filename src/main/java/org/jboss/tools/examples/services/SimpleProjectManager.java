package org.jboss.tools.examples.services;

import java.util.List;

import org.jboss.tools.examples.domain.Project;
import org.jboss.tools.examples.repository.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class SimpleProjectManager implements ProjectManager {
	@Autowired
	private ProjectDao projectDao;
	

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		return projectDao.getProjects();
	}
}
