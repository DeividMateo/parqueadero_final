package co.edu.uniquindio.poo;

public class Propietario {
    
    private final String nombres;
    private final String apellidos;
    private final int edad;
    private final String celular;
    private final String correo;
    
    
    public Propietario(String nombres, String apellidos, int edad, String celular, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }


    public String getApellidos() {
        return apellidos;
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
