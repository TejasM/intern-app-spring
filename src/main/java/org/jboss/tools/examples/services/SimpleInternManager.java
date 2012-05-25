package org.jboss.tools.examples.services;

import java.util.List;

import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.repository.InternDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SimpleInternManager implements InternManager {

	@Autowired
	private InternDao internDao;
	
	
	@Override
	public List<Intern> getInterns() {
		// TODO Auto-generated method stub
		return this.internDao.getInternList();
	}


	public InternDao getInternDao() {
		return internDao;
	}


	public void setInternDao(InternDao internDao) {
		this.internDao = internDao;
	}


}
