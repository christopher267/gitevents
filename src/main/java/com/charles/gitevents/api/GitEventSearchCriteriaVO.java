package com.charles.gitevents.api;

import java.io.Serializable;

public class GitEventSearchCriteriaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String repoName;
	private String repoOwner;
	private String eventType;
	
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String getRepoOwner() {
		return repoOwner;
	}
	public void setRepoOwner(String repoOwner) {
		this.repoOwner = repoOwner;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
