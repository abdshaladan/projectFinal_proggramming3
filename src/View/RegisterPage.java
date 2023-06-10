/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Yahya
 */
public class RegisterPage extends Stage {

    final Label usernameLabel;
    final TextField usernameTF;

    final Label passwordLabel;
    final PasswordField passwordTF;

    final Label emailLabel;
    final TextField emailTF;

    final Label groupLabel;
    final ToggleGroup genderGroup;
    final RadioButton maleGender;
    final RadioButton femaleGender;

    final Button registerBtn;
    final GridPane grid;
    final Label stackPaneLabel;
    final StackPane stackPane;
    final HBox hbox;

    public RegisterPage() {
        usernameLabel = new Label("User name : ");
        usernameTF = new TextField();
        usernameTF.setStyle("    -fx-border-color: darkblue; ");
        usernameLabel.setFont(Font.font("", FontWeight.NORMAL, 20));
        passwordLabel = new Label("Password : ");
        passwordTF = new PasswordField();
        passwordTF.setStyle("    -fx-border-color: darkblue; ");

        passwordLabel.setFont(Font.font("", FontWeight.NORMAL, 20));

        emailLabel = new Label("Email : ");
        emailTF = new TextField();
        emailTF.setStyle("    -fx-border-color: darkblue; ");

        emailLabel.setFont(Font.font("", FontWeight.NORMAL, 20));

        groupLabel = new Label("Gender : ");
        groupLabel.setFont(Font.font("", FontWeight.NORMAL, 20));

        genderGroup = new ToggleGroup();
        maleGender = new RadioButton("Male");
        maleGender.setStyle("    -fx-border-color: darkblue; ");

        maleGender.setFont(Font.font("", FontWeight.NORMAL, 20));

        femaleGender = new RadioButton("Female");
        femaleGender.setFont(Font.font("", FontWeight.NORMAL, 20));
        femaleGender.setStyle("    -fx-border-color: darkblue; ");

        maleGender.setToggleGroup(genderGroup);
        femaleGender.setToggleGroup(genderGroup);
        HBox genderHbox = new HBox(10, maleGender, femaleGender);

        registerBtn = new Button("Enter As Guest");
        registerBtn.setFont(Font.font("", FontWeight.NORMAL, 20));
        registerBtn.setCursor(Cursor.HAND);
        registerBtn.setStyle("-fx-text-Fill: white; ");
        registerBtn.setStyle("-fx-padding: 10 25 10 25; ");
        registerBtn.setStyle("-fx-background-color : #489ef4; ");
        registerBtn.getStyleClass().add("btn");
        registerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    ViewManager.openAdminPage();
                    ViewManager.closeRegisterPage();
                } catch (IOException ex) {
                    Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);

        grid.add(usernameLabel, 0, 1);
        grid.add(usernameTF, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordTF, 1, 2);

        grid.add(emailLabel, 0, 4);
        grid.add(emailTF, 1, 4);
        grid.add(groupLabel, 0, 5);
        grid.add(genderHbox, 1, 5);
        grid.add(registerBtn, 1, 6, 2, 2);
        grid.setAlignment(Pos.CENTER);
        stackPaneLabel = new Label();
        stackPane = new StackPane(stackPaneLabel);
        stackPane.setMinWidth(200);
        stackPane.setMinHeight(200);
        hbox = new HBox(30, stackPane, grid);

        StackPane root = new StackPane();
        root.getChildren().add(hbox);

        Scene scene = new Scene(root, 740, 440);
        stackPane.getStyleClass().add("stackPane");
        scene.getStylesheets().add("\\css\\style.css");

        this.setScene(scene);
        this.setTitle("Rigester Page");
        this.setResizable(false);
        this.show();
    }

    void start(Stage stage) {
    }

}
