package com.example.demo.models;

public class Employee {

    int id;
    String name;
    String job;
    int manger;
    String hiredate;
    int salary;
    int commisson;
    int deponum;

    public Employee(int id, String name, String job, int manger, String hiredate, int salary, int commisson, int deponum) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.manger = manger;
        this.hiredate = hiredate;
        this.salary = salary;
        this.commisson = commisson;
        this.deponum = deponum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManger() {
        return manger;
    }

    public void setManger(int manger) {
        this.manger = manger;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommisson() {
        return commisson;
    }

    public void setCommisson(int commisson) {
        this.commisson = commisson;
    }

    public int getDeponum() {
        return deponum;
    }

    public void setDeponum(int deponum) {
        this.deponum = deponum;
    }
}
