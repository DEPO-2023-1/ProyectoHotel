public class Otro {
    

    //atributos//
    private String Nombre;
    private double precio;

    //constructor//
    public Otro (String Nombre, double precio){
        Nombre=this.Nombre;
        precio=this.precio;
    }
    public String getNombre() {
        return Nombre;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
