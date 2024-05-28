package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainInterface extends Application {

    private ParqueaderoHolder parqueaderoHolder;

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        parqueaderoHolder = new ParqueaderoHolder();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        Button btnCrearParqueadero = new Button("Crear Parqueadero");
        btnCrearParqueadero.setOnAction(e -> showCreationWindow(primaryStage));
        gridPane.add(btnCrearParqueadero, 0, 0);

        Button btnAgregarCarro = new Button("Agregar Carro");
        btnAgregarCarro.setOnAction(e -> showAgregationCarWindow(primaryStage));
        gridPane.add(btnAgregarCarro, 0, 1);

        Button btnAgregarMoto = new Button("Agregar Moto");
        btnAgregarMoto.setOnAction(e -> showAgregationBikeWindow(primaryStage));
        gridPane.add(btnAgregarMoto, 0, 2);

        Button btnRetirarVehiculo = new Button("Retirar Vehiculo");
        btnRetirarVehiculo.setOnAction(e -> showRetirarView(primaryStage));
        gridPane.add(btnRetirarVehiculo, 1, 2);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inicio");
        primaryStage.show();
    }

    private void showCreationWindow(Stage primaryStage) {
        Stage stage = new Stage();
        CreationPane creationPane = new CreationPane(stage, parqueaderoHolder);
        Scene scene = new Scene(creationPane, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Crear Parqueadero");
        stage.show();
    }

    private void showAgregationCarWindow(Stage primaryStage) {
        Stage stage = new Stage();
        AgregationCarPane agregationCarPane = new AgregationCarPane(stage, parqueaderoHolder);
        Scene scene = new Scene(agregationCarPane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Agregar Carro");
        stage.show();
    }

    private void showAgregationBikeWindow(Stage primaryStage) {
        Stage stage = new Stage();
        AgregationBikePane agregationBikePane = new AgregationBikePane(stage, parqueaderoHolder);
        Scene scene = new Scene(agregationBikePane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Agregar Moto");
        stage.show();
    }

    private void showRetirarView(Stage primaryStage) {
        Stage stage = new Stage();
        RetirarPane retirarPane = new RetirarPane(stage, parqueaderoHolder);
        Scene scene = new Scene(retirarPane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Retirar Vehiculo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
