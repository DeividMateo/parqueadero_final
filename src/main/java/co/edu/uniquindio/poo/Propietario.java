package co.edu.uniquindio.poo;

public class Propietario {
    
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String celular;
    private final String correo;
    
    
    public Propietario(String nombre, String apellido, int edad, String celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public int getEdad() {
        return edad;
    }


    public String getCelular() {
        return celular;
    }


    public String getCorreo() {
        return correo;
    }

    


    

    
}
