package org.jboss.tools.examples.repository;

import java.util.List;

import org.jboss.tools.examples.domain.Intern;

public interface InternDao {

	public List<Intern> getInternList();
	
	public void addIntern(String name, String email);

}
