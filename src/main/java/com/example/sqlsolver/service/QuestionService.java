package com.example.sqlsolver.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public String solveSqlProblem(String regNo) {
        // Extract last two digits of regNo
        int lastTwoDigits = Integer.parseInt(regNo.substring(regNo.length() - 2));
        
        logger.info("Registration number: {}, Last two digits: {}", regNo, lastTwoDigits);
        
        if (lastTwoDigits % 2 == 0) {
            // For even regNo → Question 2 SQL
            logger.info("Even registration number - solving Question 2");
            return solveQuestion2();
        } else {
            // For odd regNo → Question 1 SQL
            logger.info("Odd registration number - solving Question 1");
            return solveQuestion1();
        }
    }

    private String solveQuestion1() {
        // Sample SQL query for Question 1 (odd registration number)
        // This would be replaced with the actual solution from the Google Drive document
        return "SELECT name, COUNT(*) as count FROM employees GROUP BY name HAVING COUNT(*) > 1";
    }

    private String solveQuestion2() {
        // Sample SQL query for Question 2 (even registration number)
        // This would be replaced with the actual solution from the Google Drive document
        return "SELECT customer_id, SUM(amount) as total_amount FROM orders WHERE order_date >= '2023-01-01' GROUP BY customer_id HAVING SUM(amount) > 1000";
    }
}
