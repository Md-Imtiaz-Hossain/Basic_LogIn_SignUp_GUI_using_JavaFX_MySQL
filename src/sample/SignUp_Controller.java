package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class SignUp_Controller {
    CreateConnectionDemo createConnectionDemo = new CreateConnectionDemo();
    Statement statement;

    @FXML
    private Label emptyFieldWorning;
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
    @FXML
    private Button cencelButton;

    public void cencelButtonOnAction(ActionEvent event) {
        var stage = (Stage) cencelButton.getScene().getWindow();
        stage.close();
    }


    public void tempWorkOnAction(ActionEvent event) {
        Connection connection = createConnectionDemo.createConnection();
            try {
                String s = "SELECT * FROM users ;";
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(s);

                while (resultSet.next()){
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    System.out.println(firstName +" "+lastName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void saveOkOnAction(ActionEvent event) {
        Connection connection = createConnectionDemo.createConnection();

        if (isExiecute()){
            emptyFieldWorning.setText("Registration  Success...");
            System.out.println("Registration  Success...");
        }else {
            emptyFieldWorning.setText("Fill up all field...");
            System.out.println("You mast enter value in all field");
        }

        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            firstName.setText("");
            lastName.setText("");
            email.setText("");
            userName.setText("");
            password.setText("");
            phone.setText("");
        }
    }

    public boolean isExiecute(){
        Connection connection = createConnectionDemo.createConnection();
        try{
            statement = connection.createStatement();
            statement.execute("INSERT INTO users(firstName,lastName,email,userName,phone,password) VALUES(   '"+ firstName.getText() +"','"+ lastName.getText() +"','"+ email.getText() +"','"+ userName.getText() +"','"+ phone.getText() +"','"+ password.getText() +"'      )");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
