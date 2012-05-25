package org.jboss.tools.examples.repository;

import java.util.List;

import org.jboss.tools.examples.domain.Project;

public interface ProjectDao {
	public List<Project> getProjects();
	
	public void addProject(Project project);
	
	public Project getProject(String name);
}
