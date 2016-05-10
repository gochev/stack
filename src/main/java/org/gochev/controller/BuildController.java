package org.gochev.controller;

import java.net.Authenticator.RequestorType;

import javax.validation.Valid;

import org.gochev.BuildService;
import org.gochev.domain.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/build")
public class BuildController {

	private BuildService buildService;

	@Autowired
	public BuildController(BuildService buildService) {
		this.buildService = buildService;
	}

	@RequestMapping("/search")
	public String search(Model model, Pageable page, @RequestParam(required=false) String buildName) {
		Page<Build> buildsPage = null;
		if(StringUtils.isEmpty(buildName)){
			buildsPage = buildService.search(page);
		} else {
			buildsPage = buildService.search(buildName, page);
		}
		model.addAttribute("buildsPage", buildsPage);
		
		return "build/search";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("build", new Build());
		return "build/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Build build, BindingResult result) {
		if (result.hasErrors()) {
			return "build/create";
		}
		buildService.create(build);
		return "build/done";
	}
	
	@RequestMapping(value="/detail/{buildId}", method = RequestMethod.GET)
	public String detail(@PathVariable String buildId, Model model){
		
		populateModel(buildId, model);
		
		return "build/detail";
	}

	@RequestMapping(value="/edit/{buildId}", method = RequestMethod.GET)
	public String edit(@PathVariable String buildId, Model model){
		
		populateModel(buildId, model);
		
		return "build/create";
	}
	
	private void populateModel(String buildId, Model model) {
		Build build = buildService.get(Long.parseLong(buildId));
		model.addAttribute("build", build);
	}
}
