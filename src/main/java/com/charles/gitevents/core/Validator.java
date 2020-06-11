package com.charles.gitevents.core;

import com.charles.gitevents.api.exception.GitEventsException;

public interface Validator<T> {
	
	public boolean validate(T request) throws GitEventsException;

}
