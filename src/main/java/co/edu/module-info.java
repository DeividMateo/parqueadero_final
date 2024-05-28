module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;

    opens co.edu.uniquindio.poo to javafx.fxml;

    exports co.edu.uniquindio.poo;

}
