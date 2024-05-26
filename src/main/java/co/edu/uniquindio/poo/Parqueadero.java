package co.edu.uniquindio.poo;

import java.util.Collection;

public class Parqueadero {
    private final String nombre;
    private int  numeroPuestos;
    private Collection<Registro> registros;
    private Collection<Vehiculo> vehiculos;

    public Parqueadero(String nombre, Int numeroPuestos){

        assert nombre != null && !nombre.isBlank()
        assert numeroPuestos > 0, "El numero de puestos tiene que ser mayor que cero";
    }

}
