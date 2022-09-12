module com.markurion.tus_java_ondrive_helper {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.json;


    opens com.markurion.tus_java_ondrive_helper to javafx.fxml;
    exports com.markurion.tus_java_ondrive_helper;
}