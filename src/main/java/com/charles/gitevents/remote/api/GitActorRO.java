package com.charles.gitevents.remote.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitActorRO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String login;
	private String displayLogin;
	private String gravatarId;
	private String url;
	private String avatarUrl;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@JsonProperty("display_login")
	public String getDisplayLogin() {
		return displayLogin;
	}
	public void setDisplayLogin(String displayLogin) {
		this.displayLogin = displayLogin;
	}
	@JsonProperty("gravatar_id")
	public String getGravatarId() {
		return gravatarId;
	}
	public void setGravatarId(String gravatarId) {
		this.gravatarId = gravatarId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@JsonProperty("avatar_url")
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
}
