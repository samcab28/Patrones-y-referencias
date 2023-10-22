package model;

public class Conexion {

    private static Conexion instancia;

    private Conexion(){

    }

    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public void Conectar(){
        System.out.println("conectado a la BD");
    }

    public void Desconectar(){
        System.out.println("desconectado de la BD");
    }

}
