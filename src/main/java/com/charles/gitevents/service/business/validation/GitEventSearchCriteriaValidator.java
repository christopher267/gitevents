package com.charles.gitevents.service.business.validation;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.api.exception.ExceptionType;
import com.charles.gitevents.api.exception.GitEventsException;
import com.charles.gitevents.core.Validator;

@Component
public class GitEventSearchCriteriaValidator implements Validator<GitEventSearchCriteriaVO> {

	public final static String MISSING_REQEST_MESSAGE = "Criteria cannot be empty."; 
	public final static String MISSING_REQUIRED_FIELDS_MESSAGE = "Repo Owner and Repo Name are required.";
	
	@Override
	public boolean validate(GitEventSearchCriteriaVO request) throws GitEventsException {
		
		if(request == null) {
			throw new GitEventsException(MISSING_REQEST_MESSAGE, ExceptionType.MISSING_DATA);
		}
		
		if(StringUtils.isBlank(request.getRepoName()) || StringUtils.isBlank(request.getRepoOwner())) {
			throw new GitEventsException(MISSING_REQUIRED_FIELDS_MESSAGE, ExceptionType.INVALID_DATA);
		}
		
		return true;
	}

}
