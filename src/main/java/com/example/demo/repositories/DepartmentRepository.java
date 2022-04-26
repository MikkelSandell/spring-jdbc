package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentRepository implements IRepository<Department> {

    @Override
    public List<Department> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Department> allDepartments = new ArrayList<Department>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departments");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Department temp = new Department(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                allDepartments.add(temp);
            }

        } catch (SQLException e) {
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allDepartments;
    }

    @Override
    public Department getSingleById(int id) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departments WHERE department_number = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            rs.next();
            Department temp = new Department(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            return temp;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean create(Department entity) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            String insert = "INSERT INTO departments (`department_number`, `department_name`, `location`) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setInt(1, (entity.getDeptno()));
            stmt.setString(2, entity.getDeptName());
            stmt.setString(3, entity.getLocation());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
