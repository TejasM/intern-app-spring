package org.jboss.tools.examples.web;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jboss.tools.examples.domain.Intern;
import org.jboss.tools.examples.services.InternManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddInternFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private InternManager internManager;
    
    @RequestMapping(method=RequestMethod.POST)
    public String addUser(@Valid Intern intern, BindingResult result){
    	if(result.hasErrors()){
    		return "adduser";
    	}else{
    		internManager.addUser(intern.getName(), intern.getEmail());
    		return "home";
    	}
    }

    public void setInternManager(InternManager productManager) {
        this.internManager = productManager;
    }

    public InternManager getInternManager() {
        return this.internManager;
    }

}
