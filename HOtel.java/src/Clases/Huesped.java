package Clases;

public class Huesped {

    //atributos//
    private String nombre;
    private String cedula;
    private String correo;
    private int edad;
    

    //constructor//
    public Huesped(String nombre, String cedula, String correo, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.edad = edad;
    }
    
    // metodos//
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
