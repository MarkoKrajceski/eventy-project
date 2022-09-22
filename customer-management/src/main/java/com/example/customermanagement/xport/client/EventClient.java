package com.example.customermanagement.xport.client;

import com.example.customermanagement.domain.valueobjects.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.http.client.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import org.springframework.web.util.*;

import java.util.*;

@Service
public class EventClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public EventClient(@Value("http://localhost:9090") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Event> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/event").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Event>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
