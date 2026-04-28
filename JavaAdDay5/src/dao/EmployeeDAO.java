package dao;

import connect.ConnectDB;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn = ConnectDB.getConnection();

    public boolean insert(Employee e) {
        String sql = "INSERT INTO EmployeeTB(EmpId, EmpName, Salary, EmpDep) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getId());
            ps.setString(2, e.getName());
            ps.setFloat(3, e.getSalary());
            ps.setString(4, e.getDepartment());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM EmployeeTB";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Employee(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM EmployeeTB WHERE EmpId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Employee findByID(String id) {
        String sql = "SELECT * FROM EmployeeTB WHERE EmpId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> findByName(String name) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM EmployeeTB WHERE EmpName LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
