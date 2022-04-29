package com.example.demo.services;

import com.example.demo.models.Employee;

public class testingunittest {

    public String testtime (int time){

        if(time >= 5 && time <= 12){
            return "morning";
        } else if (time >= 12 && time <= 16){
            return "afternoon";
        } else if (time >= 16 && time <= 22){
            return "evening";
        }else {
            return "night";
        }
    }

    public boolean validDepartment(int deponum){

        if (deponum > 9 && deponum <1000 && deponum % 10 ==0){
            return true;
        }

        return false;
    }

    public boolean validcommision(Employee employee){

        if (employee.getSalary() >= employee.getCommisson()){
            return true;
        }else{
            return false;
        }
    }
}
