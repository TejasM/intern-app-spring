package org.jboss.tools.examples.repository;

import java.util.List;

import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.domain.Project;

public interface InternDao {

	public List<Intern> getInternList();
	
	public void addIntern(Intern intern);
	
	public Intern getIntern(String name);

}
