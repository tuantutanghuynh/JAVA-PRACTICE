/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaadday7;

import DAO.UserDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

/**
 * FXML Controller class
 *
 * @author tangh
 */
public class MainController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMessage;
    
    private UserDAO dao = new UserDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lblMessage.setText("");
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) {
        User u = dao.login(txtUsername.getText(), txtPassword.getText());
        
      if( u ==  null){
          lblMessage.setText("Login Fail");
          return;
      }
      
      if(!u.status){
          lblMessage.setText("Blocked User");
          return;
      }
      
      if(u.role.equalsIgnoreCase("admin")){
          lblMessage.setText("Admin");
      }else{
          lblMessage.setText("User");
      }
    }
    
}
