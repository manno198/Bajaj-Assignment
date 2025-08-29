package com.example.sqlsolver.model;

public class SubmitRequest {
    private String finalQuery;

    // Default constructor
    public SubmitRequest() {}

    // Parameterized constructor
    public SubmitRequest(String finalQuery) {
        this.finalQuery = finalQuery;
    }

    // Getters and setters
    public String getFinalQuery() { 
        return finalQuery; 
    }
    
    public void setFinalQuery(String finalQuery) { 
        this.finalQuery = finalQuery; 
    }

    @Override
    public String toString() {
        return "SubmitRequest{" +
                "finalQuery='" + finalQuery + '\'' +
                '}';
    }
}
