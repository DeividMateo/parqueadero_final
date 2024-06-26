package co.edu.uniquindio.poo;


public abstract class Vehiculo {

    private final String placa;
    private final String modelo;
    private final Propietario propietario;

    /**
     * Método constructor de la clase Vehiculo
     * 
     * @param placa       valor de la placa del vehiculo
     * @param modelo      valor del modelo del vehiculo
     * @param propietario valor del propietario del vehiculo
     */
    public Vehiculo(String placa, String modelo, Propietario propietario) {
        assert placa != null && !placa.isBlank() : "Error la placa no puede ser nula o vacia";
        assert modelo != null && !modelo.isBlank() : "Error el modelo no puede ser nulo o vacio";
        assert propietario != null : "Error el propietario no puede ser nulo o vacio";
        
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /**
     * Método para obtener la placa del vehiculo
     * 
     * @return placa del vehiculo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Método para obtener el modelo del vehiculo
     * 
     * @return modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método para obtener el propietario del vehiculo
     * 
     * @return propietario del vehiculo
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Método abstracto para obtener la tarifa de un vehiculo pero que sobrescriben
     * las clases hijas a su manera.
     */
    public abstract double getTarifa();

    /**
     * Método para cambiar la tarifa de un vehiculo pero que sobrescriben las clases
     * hijas a su manera.
     */
    public abstract void setTarifa(double tarifa);

}
