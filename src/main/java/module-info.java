module com.example.regex_javadoc_assignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.regex_javadoc_assignment to javafx.fxml;
    exports com.example.regex_javadoc_assignment;
}