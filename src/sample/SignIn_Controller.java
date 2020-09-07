package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static javafx.fxml.FXMLLoader.load;

public class SignIn_Controller {

    @FXML
    private Button profileButton;

    public void profileButtonOnAction() throws IOException {

    }


}





/*    public void tempWorkOnAction(ActionEvent event) {
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
    }*/
