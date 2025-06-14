package com.university.dashboard.teacher;

import com.university.model.Exam;
import com.university.model.ExamModel;
import com.university.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherDashboardController {
    @FXML private Label welcomeLabel;
    @FXML private TableView<ExamModel> examsTable;

    private int teacherId;

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
        welcomeLabel.setText("Преподаватель ID: " + teacherId);
        loadTeacherExams();
    }

    private void loadTeacherExams() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Exam WHERE employeeId = :teacherId ORDER BY examDate";

            Query<Exam> query = session.createQuery(hql, Exam.class);
            query.setParameter("teacherId", teacherId);

            List<Exam> exams = query.list();

            List<ExamModel> examModels = exams.stream()
                    .map(exam -> new ExamModel(
                            exam.getExamDate().toLocalDate(),
                            exam.getExamType(),
                            "Группа " + exam.getGroupId(),
                            exam.getDiscipline().getDisciplineName()
                    ))
                    .collect(Collectors.toList());

            ObservableList<ExamModel> examData = FXCollections.observableArrayList(examModels);
            examsTable.setItems(examData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}