package com.charles.gitevents.service.business.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.charles.gitevents.MockTestBase;
import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.api.exception.GitEventsException;

public class GitEventSearchCriteriaValidatorTest extends MockTestBase {

	@InjectMocks
	private GitEventSearchCriteriaValidator validator;
	
	@Test
	public void testValidate_Success() throws Exception {
		
		final String EXPECTED_REPO_NAME = "repoName";
		final String EXPECTED_REPO_OWNER = "repoOwner";
		
		GitEventSearchCriteriaVO criteria = new GitEventSearchCriteriaVO();
		criteria.setRepoName(EXPECTED_REPO_NAME);
		criteria.setRepoName(EXPECTED_REPO_OWNER);
		
		try {
			validator.validate(criteria);
		} catch(GitEventsException ex) {
			fail("Validation should not throw exception.");
		}
	}
	
	@Test
	public void testValidate_MissingRepoOwner() throws Exception {
		
		final String EXPECTED_REPO_NAME = "repoName";
		
		GitEventSearchCriteriaVO criteria = new GitEventSearchCriteriaVO();
		criteria.setRepoName(EXPECTED_REPO_NAME);
		
		try {
			validator.validate(criteria);
		} catch(GitEventsException ex) {
			assertEquals(GitEventSearchCriteriaValidator.MISSING_REQUIRED_FIELDS_MESSAGE, ex.getMessage());
		}
	}
	
	@Test
	public void testValidate_MissingRepoName() throws Exception {
		
		final String EXPECTED_REPO_OWNER = "repoOwner";
		
		GitEventSearchCriteriaVO criteria = new GitEventSearchCriteriaVO();
		criteria.setRepoName(EXPECTED_REPO_OWNER);
		
		try {
			validator.validate(criteria);
		} catch(GitEventsException ex) {
			assertEquals(GitEventSearchCriteriaValidator.MISSING_REQUIRED_FIELDS_MESSAGE, ex.getMessage());
		}
	}

}
