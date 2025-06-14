package com.university.auth;

import com.university.model.UniversityEmployee;
import com.university.dashboard.teacher.TeacherDashboardController;
import com.university.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;

public class TeacherAuthController {
    @FXML private TextField fullnameField;
    @FXML private TextField phoneField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String fullname = fullnameField.getText().trim();
        String phone = phoneField.getText().trim();

        if (fullname.isEmpty() || phone.isEmpty()) {
            errorLabel.setText("Заполните все поля!");
            return;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM UniversityEmployee WHERE fullname = :fullname AND phone = :phone AND position = :position";

            Query<UniversityEmployee> query = session.createQuery(hql, UniversityEmployee.class);
            query.setParameter("fullname", fullname);
            query.setParameter("phone", phone);
            query.setParameter("position", "Преподаватель");

            UniversityEmployee employee = query.uniqueResult();

            if (employee != null) {
                openTeacherDashboard(employee.getEmployeeId());
            } else {
                errorLabel.setText("Преподаватель не найден или данные неверны");
            }
        } catch (Exception e) {
            errorLabel.setText("Ошибка базы данных: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void openTeacherDashboard(int teacherId) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/university/dashboard/teacher_dashboard.fxml")
            );
            Parent root = loader.load();

            TeacherDashboardController controller = loader.getController();
            controller.setTeacherId(teacherId);

            Stage stage = (Stage) fullnameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Панель преподавателя");
            stage.show();
        } catch (IOException e) {
            System.err.println("Ошибка загрузки FXML:");
            e.printStackTrace();
        }
    }
}