/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import Connect.ConnectDB;
import model.User;
/**
 *
 * @author tangh
 */
public class UserDAO {
    public User login (String name, String password){
        try(Connection conn = ConnectDB.getConnection()){
            String sql = "SELECT * FROM users WHERE username =? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);

            ResultSet rs  = ps.executeQuery();

            if(rs.next()){
                User u = new User();
                u.id = rs.getInt("id");
                u.username = rs.getString("username");
                u.password= rs.getString("password");
                u.role = rs.getString("role");
                u.status = rs.getBoolean("status");
                return u;
            }

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
