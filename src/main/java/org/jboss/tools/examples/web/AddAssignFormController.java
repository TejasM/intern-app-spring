package org.jboss.tools.examples.web;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.domain.Project;
import org.jboss.tools.examples.domain.Project_Intern;
import org.jboss.tools.examples.repository.InternDao;
import org.jboss.tools.examples.repository.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/assignproject.htm")
public class AddAssignFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InternDao internDao;
	
	@Autowired
	private ProjectDao projectDao;

	@RequestMapping(method = RequestMethod.GET)
	public String createRegisterForm(Model model) {
		List<Project> projects = projectDao.getProjects();
		
		List<Intern> interns = internDao.getInternList();

		model.addAttribute("project_intern", new Project_Intern());
		
		model.addAttribute("interns", interns);
		model.addAttribute("projects", projects);
		return "assignproject";
	}

	public InternDao getInternDao() {
		return internDao;
	}

	public void setInternDao(InternDao internDao) {
		this.internDao = internDao;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@ModelAttribute("project_intern") Project_Intern project_intern,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			Project project = projectDao.getProject(project_intern.getProject());
			Intern intern = internDao.getIntern(project_intern.getIntern());
			project.addInternsOnProject(intern);
			return "redirect:/";
		} else {
			logger.error("Some sort of error");
			return "assignproject";
		}
		
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
