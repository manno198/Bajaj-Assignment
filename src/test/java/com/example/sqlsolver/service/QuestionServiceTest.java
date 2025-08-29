package com.example.sqlsolver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    void testSolveSqlProblemWithOddRegistrationNumber() {
        // Test with odd registration number (REG12347 -> 47 is odd)
        String result = questionService.solveSqlProblem("REG12347");
        assertNotNull(result);
        assertTrue(result.contains("SELECT"));
        assertTrue(result.contains("FROM"));
    }

    @Test
    void testSolveSqlProblemWithEvenRegistrationNumber() {
        // Test with even registration number (REG12346 -> 46 is even)
        String result = questionService.solveSqlProblem("REG12346");
        assertNotNull(result);
        assertTrue(result.contains("SELECT"));
        assertTrue(result.contains("FROM"));
    }

    @Test
    void testSolveSqlProblemWithDifferentOddNumbers() {
        // Test various odd numbers
        String result1 = questionService.solveSqlProblem("REG12341");
        String result2 = questionService.solveSqlProblem("REG12343");
        
        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.contains("SELECT"));
        assertTrue(result2.contains("SELECT"));
    }

    @Test
    void testSolveSqlProblemWithDifferentEvenNumbers() {
        // Test various even numbers
        String result1 = questionService.solveSqlProblem("REG12340");
        String result2 = questionService.solveSqlProblem("REG12342");
        
        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.contains("SELECT"));
        assertTrue(result2.contains("SELECT"));
    }
}
