package com.charles.gitevents.remote.api;

import java.io.Serializable;
import java.sql.Timestamp;

import com.charles.gitevents.remote.GitRepo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GitEventRO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String type;
	private GitActorRO actor;
	private GitRepo repo;
	private GitPayloadRO payload;
	private boolean publicBool;
	private Timestamp createdAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public GitActorRO getActor() {
		return actor;
	}
	public void setActor(GitActorRO actor) {
		this.actor = actor;
	}
	public GitRepo getRepo() {
		return repo;
	}
	public void setRepo(GitRepo repo) {
		this.repo = repo;
	}
	public GitPayloadRO getPayload() {
		return payload;
	}
	public void setPayload(GitPayloadRO payload) {
		this.payload = payload;
	}
	@JsonProperty("public")
	public boolean isPublicBool() {
		return publicBool;
	}
	public void setPublicBool(boolean publicBool) {
		this.publicBool = publicBool;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
}
