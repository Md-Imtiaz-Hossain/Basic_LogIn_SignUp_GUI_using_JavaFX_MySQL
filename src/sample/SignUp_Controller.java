package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class SignUp_Controller {

    Connection connection;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField userName;

    @FXML
    private TextField phone;

    @FXML
    private TextField password;

    @FXML
    private Button saveOk;

    @FXML
    private Button tempWork;



    public void tempWorkOnAction(ActionEvent event) {

    }

    private void createConnection()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_page","root", "600660");
            System.out.println("Success !!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOkOnAction(ActionEvent event) {
        createConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO users(firstName,lastName,email,userName,phone,password) VALUES(   '"+ firstName.getText() +"','"+ lastName.getText() +"','"+ email.getText() +"','"+ userName.getText() +"','"+ phone.getText() +"','"+ password.getText() +"'      )");

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
