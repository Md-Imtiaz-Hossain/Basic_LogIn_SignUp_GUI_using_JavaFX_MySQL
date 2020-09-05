package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUp_SignInController  {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button signUpButton;
    @FXML
    private Button signInButton;

    public void signUpButtonAction(ActionEvent event) throws IOException {
        Parent root_SignUp = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene_SignUp = new Scene(root_SignUp);
        Stage stage_SignUp = new Stage(StageStyle.DECORATED);
        stage_SignUp.setScene(scene_SignUp);
        stage_SignUp.show();
    }

    public void signInButtonAction(ActionEvent event) {

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

    }

    public void cancelButtonAction(ActionEvent event){
        var stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
