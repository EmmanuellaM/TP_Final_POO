module com.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.junit.jupiter.api;
    requires jdk.incubator.vector;

    opens com.polytechnique to javafx.fxml;
    opens com.polytechnique.Entités to com.fasterxml.jackson.databind;

    exports com.polytechnique;
}
