package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {
    @Override
    public List<Employee> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }

        } catch (SQLException e) {
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employee getSingleById(int id) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();
            Employee temp = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8)
            );
            return temp;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean create(Employee entity) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            String insert = "INSERT INTO employees (`id`, `employee_name`, `job`, `manager`, `hiredate`, `salary`, `commission`, `department_number`) VALUES (?, ?, ?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setInt(1, (entity.getId()));
            stmt.setString(2, entity.getName());
            stmt.setString(3, entity.getJob());
            stmt.setInt(4, entity.getManger());
            stmt.setDate(5, Date.valueOf(entity.getHiredate()));
            stmt.setInt(6, entity.getSalary());
            stmt.setInt(7, entity.getCommisson());
            stmt.setInt(8, entity.getDeponum());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
