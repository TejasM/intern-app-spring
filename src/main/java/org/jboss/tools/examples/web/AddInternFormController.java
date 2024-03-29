package org.jboss.tools.examples.web;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.repository.InternDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/adduser.htm")
public class AddInternFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private InternDao internDao;

	@RequestMapping(method = RequestMethod.GET)
	public String createRegisterForm(Model model) {
		model.addAttribute("intern", new Intern());
		return "adduser";
	}

	public InternDao getInternDao() {
		return internDao;
	}

	public void setInternDao(InternDao internDao) {
		this.internDao = internDao;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("intern") Intern intern,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			internDao.addIntern(intern);
			return "redirect:/";
		} else {
			return "adduser";
		}
	}

}
