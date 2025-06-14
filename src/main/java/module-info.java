module org.example.university {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;

    // Открываем необходимые пакеты для FXML
    opens com.university.auth to javafx.fxml;
    opens com.university to javafx.fxml;

    // Экспортируем пакеты
    exports com.university;
    exports com.university.auth;
}