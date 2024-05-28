package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RetirarPane extends GridPane {
    public RetirarPane(@SuppressWarnings("exports") Stage stage, ParqueaderoHolder parqueaderoHolder) {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        Label lblPoscicionI = new Label("Ingrese la poscicion en terminos i:");
        TextField txtPoscicionI = new TextField();
        add(lblPoscicionI, 0, 0);
        add(txtPoscicionI, 1, 0);

        Label lblPoscicionJ = new Label("Ingrese la poscicion en terminos de j:");
        TextField txtPoscicionJ = new TextField();
        add(lblPoscicionJ, 0, 1);
        add(txtPoscicionJ, 1, 1);

        Button btnCrear = new Button("Crear");
        btnCrear.setOnAction(e -> {
            String poscicionI = txtPoscicionI.getText();
            String poscicionJ = txtPoscicionJ.getText();

            int poscicion1 = Integer.parseInt(poscicionI);
            int poscicion2 = Integer.parseInt(poscicionJ);

            parqueaderoHolder.getParqueadero().removeVehiculoPuestoDado(poscicion1, poscicion2, LocalDateTime.now());
            stage.close();
        });
        add(btnCrear, 1, 2);

    }
}
