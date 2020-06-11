package com.charles.gitevents.remote;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class ApiClientBase {
	
    protected RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
	
    protected UriComponents getUriComponents(final String url, Map<String, Object> pathParams) {
        if (pathParams != null) {
            return UriComponentsBuilder.fromHttpUrl(url).buildAndExpand(pathParams);
        } else {
        	return UriComponentsBuilder.fromHttpUrl(url).build();
        }
    }

}
