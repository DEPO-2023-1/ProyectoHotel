package Clases;
public abstract class Usuario{

    String contrasena;
    String login;

    public Usuario(String contrasena, String login){
        this.contrasena = contrasena;
        this.login = login;
    }


    public String getLogin(){
    	return this.login;
    }

    public String getcontrasena(){
    	return this.contrasena;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }


}