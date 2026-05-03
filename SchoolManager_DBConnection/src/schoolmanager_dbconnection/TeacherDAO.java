/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanager_dbconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tangh
 */
public class TeacherDAO {

    private Connection conn = ConnectDB.getConnection();

    public boolean insert(Teacher t) {
        String sql = "INSERT INTO Teachers(TeacherId, TeacherName, Subject, Salary, TeacherType, ClassLevel, Degree)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.id);
            ps.setString(2, t.name);
            ps.setString(3, t.subject);
            ps.setDouble(4, t.salary);
            ps.setString(5, t.getTypeCode());
            if (t instanceof PrimaryTeacher) {
                ps.setInt(6, ((PrimaryTeacher) t).classLevel);
                ps.setNull(7, Types.VARCHAR);
            } else {
                ps.setNull(6, Types.INTEGER);
                ps.setString(7, ((HighSchoolTeacher) t).degree);
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Teacher> findAll() {
        List<Teacher> list = new ArrayList<>();
        String sql = "SELECT * FROM Teachers";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Teacher findByID(String id) {
        String sql = "SELECT * FROM Teachers WHERE TeacherId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Teacher> findBySubject(String subject) {
        List<Teacher> list = new ArrayList<>();
        String sql = "SELECT * FROM Teachers WHERE Subject = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, subject);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Teachers WHERE TeacherId = ? ";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double totalSalary() {
        String sql = "SELECT SUM(Salary) FROM Teachers";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Teacher mapRow(ResultSet rs) throws SQLException {
        String type = rs.getString("TeacherType");
        if ("P".equals(type)) {
            PrimaryTeacher t = new PrimaryTeacher();
            t.id = rs.getString("TeacherId");
            t.name = rs.getString("TeacherName");
            t.subject = rs.getString("Subject");
            t.salary = rs.getDouble("Salary");
            t.classLevel = rs.getInt("ClassLevel");
            return t;
        } else {
            HighSchoolTeacher t = new HighSchoolTeacher();
            t.id = rs.getString("TeacherId");
            t.name = rs.getString("TeacherName");
            t.subject = rs.getString("Subject");
            t.salary = rs.getDouble("Salary");
            t.degree= rs.getString("Degree");
            return t;
        }
    }

}
