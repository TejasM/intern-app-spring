package org.jboss.tools.examples.services;

import java.util.List;

import org.jboss.tools.examples.domain.Intern;

public interface InternManager {

	public List<Intern> getInterns();
	
	public void addUser(String name, String email);
}
