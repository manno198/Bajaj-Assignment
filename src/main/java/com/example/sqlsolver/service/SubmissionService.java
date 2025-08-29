package com.example.sqlsolver.service;

import com.example.sqlsolver.model.SubmitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SubmissionService {

    private static final Logger logger = LoggerFactory.getLogger(SubmissionService.class);

    @Autowired
    private RestTemplate restTemplate;

    public void submitQuery(String webhookUrl, String accessToken, String query) {
        logger.info("Submitting SQL query to webhook: {}", webhookUrl);
        logger.info("SQL Query: {}", query);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        SubmitRequest submitRequest = new SubmitRequest(query);
        HttpEntity<SubmitRequest> entity = new HttpEntity<>(submitRequest, headers);

        try {
            String response = restTemplate.postForObject(webhookUrl, entity, String.class);
            logger.info("Query submitted successfully. Response: {}", response);
        } catch (Exception e) {
            logger.error("Error submitting query: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to submit query", e);
        }
    }
}
