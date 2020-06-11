package com.charles.gitevents.core;

import java.util.List;

import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.remote.api.GitEventRO;

public interface IGitEventClient {
	
	public List<GitEventRO> findGitEvents(GitEventSearchCriteriaVO criteria);
	
}
