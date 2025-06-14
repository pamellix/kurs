package com.university.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthController {
    @FXML private Button selectRoleBtn;
    @FXML private VBox roleButtonsContainer;
    @FXML private Button studentBtn;
    @FXML private Button teacherBtn;
    @FXML private Button adminBtn;

    @FXML
    private void handleRoleSelection() {
        roleButtonsContainer.setVisible(!roleButtonsContainer.isVisible());
    }

    @FXML
    private void handleRoleChoice(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        try {
            Stage stage = (Stage) selectRoleBtn.getScene().getWindow();
            Parent root;

            switch (clickedButton.getId()) {
                case "teacherBtn":
                    root = FXMLLoader.load(getClass().getResource("/com/university/view/teacher_auth.fxml"));
                    stage.setTitle("Авторизация преподавателя");
                    break;
                case "studentBtn":
                    // Аналогично для студента
                    root = FXMLLoader.load(getClass().getResource("/com/university/view/student_auth.fxml"));
                    stage.setTitle("Авторизация студента");
                    break;
                case "adminBtn":
                    // Аналогично для администратора
                    root = FXMLLoader.load(getClass().getResource("/com/university/view/admin_auth.fxml"));
                    stage.setTitle("Авторизация администратора");
                    break;
                default:
                    return;
            }

            stage.setScene(new Scene(root));
            stage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}