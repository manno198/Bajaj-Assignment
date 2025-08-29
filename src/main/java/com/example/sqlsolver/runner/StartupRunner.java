package com.example.sqlsolver.runner;

import com.example.sqlsolver.model.WebhookResponse;
import com.example.sqlsolver.service.QuestionService;
import com.example.sqlsolver.service.SubmissionService;
import com.example.sqlsolver.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class StartupRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);
    private static final String REG_NO = "REG12347";

    @Autowired
    private WebhookService webhookService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SubmissionService submissionService;

    @Override
    public void run(ApplicationArguments args) {
        logger.info("🚀 Starting SQL Solver Application Flow...");
        
        try {
            // Step 1: Generate webhook
            logger.info("Step 1: Generating webhook...");
            WebhookResponse response = webhookService.generateWebhook();
            
            // Step 2: Solve SQL problem based on registration number
            logger.info("Step 2: Solving SQL problem...");
            String sqlQuery = questionService.solveSqlProblem(REG_NO);
            
            // Step 3: Submit the final SQL query
            logger.info("Step 3: Submitting SQL query...");
            submissionService.submitQuery(response.getWebhook(), response.getAccessToken(), sqlQuery);
            
            logger.info("✅ SQL Query submitted successfully!");
            logger.info("🎉 Application flow completed successfully!");
            
        } catch (Exception e) {
            logger.error("❌ Error during application flow: {}", e.getMessage(), e);
            System.exit(1);
        }
    }
}
