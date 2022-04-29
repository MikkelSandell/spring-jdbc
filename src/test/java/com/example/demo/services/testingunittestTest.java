package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testingunittestTest {

    testingunittest t = new testingunittest();
    @Test
    void testtime() {


        String forvnetet = "morning";
        int tid = 7;

        assertEquals(forvnetet,t.testtime(tid));
    }

    @Test
    void validDepartment(){

        boolean forventet = true;
        int deponum = 30;

        assertEquals(forventet,t.validDepartment(deponum));

    }

    @Test
    void validcommision(){

        Employee e = new Employee(12,"hans","it",23,"10",1000,1000,12);

        boolean forventet = true;
        assertEquals(forventet,t.validcommision(e));

    }
}