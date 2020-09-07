package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SignUp_SignInController  {

    Connection connection;

    @FXML
    private Label loginMassageLevel;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private Button signUpButton;
    @FXML
    private Button signInButton;

    public String storedUserName(){
        return usernameTextField.getText();
    }

    public void signUpButtonAction(ActionEvent event) throws IOException {
        Parent root_SignUp = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene_SignUp = new Scene(root_SignUp);
        Stage stage_SignUp = new Stage(StageStyle.DECORATED);
        stage_SignUp.setScene(scene_SignUp);
        stage_SignUp.show();
    }

    private void createConnection()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_page","root", "600660");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void signInButtonAction(ActionEvent event) {

        createConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("  SELECT count(1) FROM login_page.users where userName = '"+ usernameTextField.getText() +"' and password = '"+ enterPasswordField.getText() +"';  ");

            while (resultSet.next()){
                if (usernameTextField.getText().isEmpty() || enterPasswordField.getText().isEmpty()){
                    loginMassageLevel.setText("Enter Username And Password");
                    System.out.println("Please Enter Username And Password");
                }else {
                            if (resultSet.getInt(1) == 1){
                                System.out.println("Congratulation !! Successfully LogIn !!");

                                Parent root_SignIn = null;
                                try {
                                    root_SignIn = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Scene scene_SignIn = new Scene(root_SignIn);
                                Stage stage_SignIn = new Stage(StageStyle.DECORATED);
                                stage_SignIn.setScene(scene_SignIn);
                                stage_SignIn.show();
                            }else {
                                loginMassageLevel.setText("Invalid UserName or Password!!!");
                                System.out.println("Invalid UserName or Password!!!");
                            }
                }
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void cancelButtonAction(ActionEvent event){
        var stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
