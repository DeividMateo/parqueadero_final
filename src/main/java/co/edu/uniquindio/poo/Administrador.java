package co.edu.uniquindio.poo;

public class Administrador extends Propietario{

    public Administrador(String nombre, String apellido, int edad, String celular, String correo){
        super(nombre, apellido, edad, celular, correo);

    }

    public void  cambiarTarifa ( Vehiculo vehiculo, double tarifa){

        assert tarifa >0: "La tarifa tiene que ser mayor a cero";
        vehiculo.setTarifa(tarifa); 
    }
    
}
