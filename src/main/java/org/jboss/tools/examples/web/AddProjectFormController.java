package org.jboss.tools.examples.web;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.tools.examples.domain.Project;
import org.jboss.tools.examples.repository.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/addproject.htm")
public class AddProjectFormController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProjectDao projectDao;

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("project", new Project());
		return "addproject";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addProject(Model model,
			@Valid @ModelAttribute("project") Project project,
			BindingResult result) {
		if (!result.hasErrors()) {
			projectDao.addProject(project);
			return "redirect:/";
		} else {
			return "addproject";
		}
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
