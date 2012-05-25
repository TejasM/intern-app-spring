package org.jboss.tools.examples.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="PROJECTS", uniqueConstraints={@UniqueConstraint(columnNames = "NAME")})
public class Project {
	
	
	
	@Id
	@Column(name="NAME")
	@Pattern(regexp="[A-Za-z0-9' ]+[A-Za-z0-9' ]+[A-Za-z0-9' ]", message="Project may only have letters and at most three words")
	private String name;
	
	@Max(50)
	@Min(0)
	private int maxPeople;
	
	
	@OneToMany
	private List<Intern> internsOnProject;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public List<Intern> getInternsOnProject() {
		return internsOnProject;
	}

	public void setInternsOnProject(List<Intern> internsOnProject) {
		this.internsOnProject = internsOnProject;
	}
	
	public void addInternsOnProject(Intern intern){
		if(this.internsOnProject == null){
			this.internsOnProject = new ArrayList<Intern>();
		}
		this.internsOnProject.add(intern);
	}
	
	public String toString(){
		return this.name;
	}
}
