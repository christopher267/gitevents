package com.charles.gitevents.remote.api;

import java.io.Serializable;

public class GitPayloadRO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
