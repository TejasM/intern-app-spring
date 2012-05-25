package org.jboss.tools.examples.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.domain.Project;
import org.jboss.tools.examples.services.InternManager;
import org.jboss.tools.examples.services.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private InternManager internManager;
	
	@Autowired
	private ProjectManager	projectManager;

	@RequestMapping(value = "*.htm")
	public String hello(Model model) {

		List<Intern> interns = new ArrayList<Intern>();
		interns = this.internManager.getInterns();
		List<Project>projects=new ArrayList<Project>();
		projects = this.projectManager.getProjects();
		
		
		logger.info(projects);
		
		model.addAttribute("interns", interns);
		model.addAttribute("projects", projects);
		return "hello";

	}

	public void setInternManager(InternManager internManager) {
		this.internManager = internManager;
	}
	
	
	
}
