module com.captech.graphicuserinterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.captech.graphicuserinterface to javafx.fxml;
    exports com.captech.graphicuserinterface;
}