package co.edu.uniquindio.poo;

public class Propietario {
    
    private final String nombres;
    private final String apellidos;
    private final int edad;
    private final String celular;
    private final String correo;
    
    
    public Propietario(String nombre, String apellido, int edad, String celular, String correo) {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede estar en blanco ni ser null";
        assert apellido != null && !nombre.isBlank() : "El apellido no puede estar en blanco ni ser null";
        assert  edad >= 18 : "La edad debe ser mayor que 0";
        assert celular != null && !nombre.isBlank() : "El celular no puede estar en blanco ni ser null";
        assert correo != null && correo.contains("@") : "El correo electrónico debe contener el símbolo @";
        this.nombre = nombre;
        this.apellido = apellido;
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
