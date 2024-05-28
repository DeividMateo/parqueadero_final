package co.edu.uniquindio.poo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgregationCarPane extends GridPane {
    public AgregationCarPane(Stage stage, ParqueaderoHolder parqueaderoHolder) {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        Label lblNombre = new Label("Nombre del propietario:");
        TextField txtNombre = new TextField();
        add(lblNombre, 0, 0);
        add(txtNombre, 1, 0);

        Label lblApellido = new Label("Apellido del propietario:");
        TextField txtApellido = new TextField();
        add(lblApellido, 0, 1);
        add(txtApellido, 1, 1);

        Label lblAge = new Label("Edad del propietario:");
        TextField txtAge = new TextField();
        add(lblAge, 0, 2);
        add(txtAge, 1, 2);

        Label lblPhoneNumber = new Label("Numero del propietario:");
        TextField txtPhoneNumber = new TextField();
        add(lblPhoneNumber, 0, 3);
        add(txtPhoneNumber, 1, 3);

        Label lblMail = new Label("Correo del propietario:");
        TextField txtMail = new TextField();
        add(lblMail, 0, 4);
        add(txtMail, 1, 4);

        Label lblPlaca = new Label("Placa del vehiculo:");
        TextField txtPlaca = new TextField();
        add(lblPlaca, 0, 5);
        add(txtPlaca, 1, 5);

        Label lblModelo = new Label("Modelo del vehiculo:");
        TextField txtModelo = new TextField();
        add(lblModelo, 0, 6);
        add(txtModelo, 1, 6);

        Button btnRegistrar = new Button("Registar");
        btnRegistrar.setOnAction(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String age = txtAge.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String mail = txtMail.getText();
            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();

            int edad = Integer.parseInt(age);
            Propietario propietario = new Propietario(nombre, apellido, edad, phoneNumber, mail);
            Vehiculo carro = new Carro(placa, modelo, propietario);
            parqueaderoHolder.getParqueadero().addVehiculo(carro);
            stage.close();
        });
        add(btnRegistrar, 1, 9);
    }
}