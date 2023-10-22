package org.example;

import model.Conexion;

public class Main {
    public static void main(String[] args) {
        //Conexion c = new Conexion();
        Conexion c = Conexion.getInstancia();
        c.Conectar();
        c.Desconectar();

        boolean rpta = c instanceof Conexion;
        System.out.println(rpta);
    }
}