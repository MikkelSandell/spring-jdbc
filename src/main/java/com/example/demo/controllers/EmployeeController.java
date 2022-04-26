package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
        private final IRepository<Employee> employeeRepository = new EmployeeRepository();

        @GetMapping("/employees")
        public String allemployees(Model model) {
            List employees = employeeRepository.getAllEntities();
            model.addAttribute("employees", employees);
            return "employees";
        }

        @GetMapping("/employee")
        public String allemployee(@RequestParam("id") int id, Model model) {
            Employee d = employeeRepository.getSingleById(id);
            model.addAttribute("employee", d);
            return "employee";
        }

        @GetMapping("/createemployee")
        public String createemployee(@RequestParam("id") int id, @RequestParam("name") String name,
                                     @RequestParam("job") String job, @RequestParam("manger") int manger,
                                     @RequestParam("hiredate") String hiredate, @RequestParam("salary") int salary,
                                     @RequestParam("commisson") int commisson, @RequestParam("deponum") int deponum, Model model) {
            EmployeeRepository d = new EmployeeRepository();
            Employee employee = new Employee(
                    id,
                    name,
                    job,
                    manger,
                    hiredate,
                    salary,
                    commisson,deponum);
            d.create(employee);
            List employees = employeeRepository.getAllEntities();
            model.addAttribute("employees", employees);
            return "employees";
        }

    }

