package com.charles.gitevents.service.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.api.exception.GitEventsException;
import com.charles.gitevents.core.IGitEventClient;
import com.charles.gitevents.core.IGitEventService;
import com.charles.gitevents.remote.api.GitEventRO;
import com.charles.gitevents.service.business.validation.GitEventSearchCriteriaValidator;

@Component
public class GitEventService implements IGitEventService {
	
	@Resource
	private IGitEventClient client;
	
	@Resource
	private GitEventSearchCriteriaValidator validator;
	
	@Override
	public List<GitEventRO> findEvents(GitEventSearchCriteriaVO criteria) throws GitEventsException {
		
		validator.validate(criteria);
		
		List<GitEventRO> gitEvents = client.findGitEvents(criteria);
		
		if(!StringUtils.isEmpty(criteria.getEventType()) 
				&& !CollectionUtils.isEmpty(gitEvents)) {
			gitEvents = gitEvents.stream().filter(event -> 
				criteria.getEventType().equalsIgnoreCase(event.getType())).collect(Collectors.toList());
		}
		
		return gitEvents;
	}

}
