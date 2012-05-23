package org.jboss.tools.examples.web;

import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.services.InternManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private InternManager internManager;

	@RequestMapping(value = "*.htm")
	public String hello(Model model) {

		List<Intern> interns = new ArrayList<Intern>();
		interns = this.internManager.getInterns();

		model.addAttribute("interns", interns);

		return "hello";

	}

	public void setInternManager(InternManager internManager) {
		this.internManager = internManager;
	}
	
	
	
}
