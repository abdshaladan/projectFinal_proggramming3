/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sa
 */
public class loginpage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Patient Login");

        // Create a GridPane layout to hold the UI elements
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add a Text element for the page title
        Text scenetitle = new Text("Welcome to Patient Login");
        scenetitle.setFont(Font.font("", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Add a Label element for the username field
        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);
        usernameLabel.setFont(Font.font("", FontWeight.NORMAL, 20));
        // Add a TextField element for the username field
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        userTextField.setStyle("    -fx-border-color: darkblue; ");
        // Add a Label element for the password field
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);
        passwordLabel.setFont(Font.font("", FontWeight.NORMAL, 20));
        // Add a PasswordField element for the password field
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("    -fx-border-color: darkblue; ");
        grid.add(passwordField, 1, 2);

        // Add a Button element for the login action
        Button loginButton = new Button("Register");
        loginButton.setStyle("-fx-text-Fill: white; ");
        Button regstir = new Button("Login");
        HBox hbLoginButton = new HBox(10);
        hbLoginButton.setAlignment(Pos.CENTER);
        hbLoginButton.getChildren().add(loginButton);
        grid.add(regstir, 2, 4);

        loginButton.setStyle("-fx-padding: 10 25 10 25; ");
        loginButton.setStyle("-fx-background-color : #489ef4; ");

        regstir.setStyle("-fx-padding: 10 25 10 25; ");
        regstir.setStyle("-fx-background-color : #489ef4; ");
        grid.add(hbLoginButton, 1, 4);

       
        final Text loginStatusText = new Text();
        grid.add(loginStatusText, 1, 6);
        regstir.setOnAction(e -> {
          
           
           try {
                     ViewManager.openAdminPage();
                    ViewManager.closeRegisterPage();
                } catch (Exception ex) {
                    Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
       
        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passwordField.getText();

          
            if ("1".equals(username) && "1".equals(password)) {
                loginStatusText.setFill(javafx.scene.paint.Color.GREEN);
                loginStatusText.setText("Login successful!");
                RegisterPage registerPage = new RegisterPage();
                try {
                    registerPage.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                loginStatusText.setFill(javafx.scene.paint.Color.RED);
                loginStatusText.setText("Invalid username or password.");
            }
        });

        Scene scene = new Scene(grid, 400, 275);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
