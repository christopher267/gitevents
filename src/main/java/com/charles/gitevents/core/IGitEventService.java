package com.charles.gitevents.core;

import java.util.List;

import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.api.exception.GitEventsException;
import com.charles.gitevents.remote.api.GitEventRO;

public interface IGitEventService {

	public List<GitEventRO> findEvents(GitEventSearchCriteriaVO criteria) throws GitEventsException;
	

}
