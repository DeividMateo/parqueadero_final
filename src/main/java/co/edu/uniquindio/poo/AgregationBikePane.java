package co.edu.uniquindio.poo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgregationBikePane extends GridPane {
    public AgregationBikePane(Stage stage, ParqueaderoHolder parqueaderoHolder) {
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

        Label lblVelocidadMaxima = new Label("Velocidad Maxima del vehiculo:");
        TextField txtVeocidadMaxima = new TextField();
        add(lblVelocidadMaxima, 0, 7);
        add(txtVeocidadMaxima, 1, 7);

        Label lblTipoMoto = new Label("Tipo de Moto:");
        ComboBox<TipoMoto> cbTipoMoto = new ComboBox<>();
        cbTipoMoto.getItems().addAll(TipoMoto.values());
        add(lblTipoMoto, 0, 8);
        add(cbTipoMoto, 1, 8);

        Button btnRegistrar = new Button("Registar");
        btnRegistrar.setOnAction(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String age = txtAge.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String mail = txtMail.getText();
            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();
            String velocidadMaxima = txtVeocidadMaxima.getText();
            TipoMoto tipoMoto = cbTipoMoto.getValue();

            int edad = Integer.parseInt(age);
            double velocidad = Double.parseDouble(velocidadMaxima);
            Propietario propietario = new Propietario(nombre, apellido, edad, phoneNumber, mail);
            Vehiculo moto = new Moto(placa, modelo, propietario, velocidad, tipoMoto);
            parqueaderoHolder.getParqueadero().addVehiculo(moto);
            stage.close();
        });
        add(btnRegistrar, 1, 8);

    }
}
