package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.junit.jupiter.api.Test;
import testrepo.testrepo;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTestTest {
    IRepository<Employee> testrepo = new testrepo();
    EmployeeTest test = new EmployeeTest(testrepo);

    @Test
    void aboveAverage() {


        Employee e = new Employee(17,"hans","it",23,"10",100000,1000,10);
        boolean forvetnet = true;

        assertEquals(forvetnet,test.aboveAverage(e));
    }

    @Test
    void highestDepoNum(){

        int forventet = 40;
        assertEquals(forventet,test.highestDepoNum());
    }
}