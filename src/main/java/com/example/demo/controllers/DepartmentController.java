package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentController {
    private final IRepository<Department> departmentRepository = new DepartmentRepository();

    @GetMapping("/departments")
    public String allDepartments(Model model){
        List departments = departmentRepository.getAllEntities();
        model.addAttribute("departments",departments);
        return "departments";
    }
    @GetMapping("/department")
    public String allDepartment(@RequestParam("id") int id, Model model){
        Department d = departmentRepository.getSingleById(id);
        model.addAttribute("department",d);
        return "department";
    }
}
