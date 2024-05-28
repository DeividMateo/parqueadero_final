package co.edu.uniquindio.poo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreationPane extends GridPane {
    public CreationPane(@SuppressWarnings("exports") Stage stage, ParqueaderoHolder parqueaderoHolder) {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        Label lblNombre = new Label("Nombre Parqueadero:");
        TextField txtNombre = new TextField();
        add(lblNombre, 0, 0);
        add(txtNombre, 1, 0);

        Label lblNumeroPuestos = new Label("Numero Puestos:");
        TextField txtNumeroPuestos = new TextField();
        add(lblNumeroPuestos, 0, 1);
        add(txtNumeroPuestos, 1, 1);

        Button btnCrear = new Button("Crear");
        btnCrear.setOnAction(e -> {
            String nombre = txtNombre.getText();
            String puestos = txtNumeroPuestos.getText();
            if (!puestos.matches("\\d+")) {
                System.out.println("El número de puestos debe ser un número entero.");
                return;
            }
            int numeroPuestos = Integer.parseInt(puestos);
            Parqueadero parqueadero = new Parqueadero(nombre, numeroPuestos);
            parqueaderoHolder.setParqueadero(parqueadero);
            parqueadero.crearPuestos(numeroPuestos);
            System.out.println("Parqueadero creado: " + parqueadero.getNombre() + " con "
                    + parqueadero.getNumeroPuestos() + " puestos.");
            stage.close();
        });
        add(btnCrear, 1, 2);
    }
}
