package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.IRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    IRepository<Employee> repo;
    List<Employee> allemployee = new ArrayList<>();

    public EmployeeTest(IRepository<Employee> repo){
        this.repo = repo;
    }


    public boolean aboveAverage(Employee e){

        List<Employee> allEmployee = repo.getAllEntities();
        int allSalary = 0;

        for (int i = 0; i < allEmployee.size(); i++) {
            allSalary = allSalary + allEmployee.get(i).getSalary();
        }
        int average = allSalary/allEmployee.size();

        if(average< e.getSalary()){
            return true;
        }else {
            return false;
        }
    }

    public int highestDepoNum(){


        List<Employee> allEmployee = repo.getAllEntities();
        int highestDepoNum = 0;

        for (int i = 0; i < allEmployee.size(); i++) {
            if (highestDepoNum < allEmployee.get(i).getDeponum()){
                highestDepoNum = allEmployee.get(i).getDeponum();
            }
        }

        return highestDepoNum;
    }

    public int DepartmentWithMostEmployees(){


        return 0;
    }
}
