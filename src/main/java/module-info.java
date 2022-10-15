module com.example.shapespaint {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.shapespaint to javafx.fxml;
    exports com.example.shapespaint;
}