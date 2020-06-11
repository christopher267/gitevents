package com.charles.gitevents.service.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.charles.gitevents.MockTestBase;
import com.charles.gitevents.api.GitEventSearchCriteriaVO;
import com.charles.gitevents.core.IGitEventClient;
import com.charles.gitevents.remote.api.GitEventRO;
import com.charles.gitevents.service.business.validation.GitEventSearchCriteriaValidator;

public class GitEventServiceTest extends MockTestBase {

	@Mock
	private IGitEventClient client;
	
	@Mock
	private GitEventSearchCriteriaValidator validator;
	
	@InjectMocks
	private GitEventService service;
	
	@Test
	public void testFindEvents_Success() throws Exception {

		final int EXPECTED_COUNT = 2;
		GitEventSearchCriteriaVO criteria = new GitEventSearchCriteriaVO();
		
		Mockito.when(validator.validate(criteria)).thenReturn(true);
		Mockito.when(client.findGitEvents(Mockito.any())).thenReturn(getGitEventsResults());
		
		List<GitEventRO> results = service.findEvents(criteria);
		assertNotNull(results);
		assertEquals(EXPECTED_COUNT, results.size());
		
	}
	
	@Test
	public void testFindEvents_SuccessFilter() throws Exception {

		final int EXPECTED_COUNT = 1;
		final String EXPECTED_TYPE = "PushEvent";
		GitEventSearchCriteriaVO criteria = new GitEventSearchCriteriaVO();
		criteria.setEventType("PushEvent");
		
		Mockito.when(validator.validate(criteria)).thenReturn(true);
		Mockito.when(client.findGitEvents(Mockito.any())).thenReturn(getGitEventsResults());
		
		List<GitEventRO> results = service.findEvents(criteria);
		assertNotNull(results);
		assertEquals(EXPECTED_COUNT, results.size());
		assertEquals(EXPECTED_TYPE, results.get(0).getType());
		
	}
	
	private List<GitEventRO> getGitEventsResults() {
		GitEventRO event = new GitEventRO();
		event.setId(1l);
		event.setType("PushEvent");
		GitEventRO event2 = new GitEventRO();
		event2.setId(2l);
		event2.setType("PullEvent");
		return Arrays.asList(event, event2);
	}

}
