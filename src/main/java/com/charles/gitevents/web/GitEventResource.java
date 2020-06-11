package com.charles.gitevents.web;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.core.IGitEventService;
import com.charles.gitevents.remote.api.GitEventRO;

@RestController("GitEventResource")
@RequestMapping(value = "v1/GitEvent")
public class GitEventResource {
	
	@Resource
	private IGitEventService service;
	
	@RequestMapping(
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@PermitAll
	public List<GitEventRO> getGitEvent(GitEventSearchCriteriaVO criteria) {
 		return service.findEvents(criteria);
	}
}
