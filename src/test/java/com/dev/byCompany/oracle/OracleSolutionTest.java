package com.dev.byCompany.oracle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 31/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class OracleSolutionTest {
    OracleSolution solution = new OracleSolution();

    @Test
    void knapSack() {
        int capacity =4;
        int[] values = {1,2,3};
        int[] weights = {4,5,1};
        int maxValue = OracleSolution.knapSack(capacity, values, weights);
        assertEquals(3,maxValue );

    }
}