package com.charles.gitevents.remote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.core.IGitEventClient;
import com.charles.gitevents.remote.api.GitEventRO;

@Component
public class GitEventClient extends ApiClientBase implements IGitEventClient {
	
	@Value(value = "${git.repos.remote.url}")
	private String gitRepoUrl;
	
	public static final String REPOS_OWNER_ATTR = "repoOwner";
	public static final String REPOS_NAME_ATTR = "repoName";

	@Override
	public List<GitEventRO> findGitEvents(final GitEventSearchCriteriaVO criteria) {
		Map<String, Object> criteriaMap = new HashMap<>();
		criteriaMap.put(REPOS_OWNER_ATTR, criteria.getRepoOwner());
		criteriaMap.put(REPOS_NAME_ATTR, criteria.getRepoName());
		ResponseEntity<GitEventRO[]> response = getRestTemplate().getForEntity(getUriComponents(getGitEventsUrl(), criteriaMap).toUriString(), GitEventRO[].class);
		return Arrays.asList(response.getBody());
	}
	
    private String getGitEventsUrl() {
    	return gitRepoUrl + "/{" + REPOS_OWNER_ATTR + "}/{" + REPOS_NAME_ATTR + "}/events";
    }
    
}
