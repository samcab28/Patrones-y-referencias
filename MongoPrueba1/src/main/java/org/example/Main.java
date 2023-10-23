package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Database databaseFacade = new Database("mongodb+srv://testUser:ONY5sbOldyfHGLuP@cluster0.f8vttt6.mongodb.net/?retryWrites=true&w=majority", "SampleDB", "sampleCollection");

        // Elimina todos los documentos de la colección
        // databaseFacade.eliminarDocumentos();

        // Crear una nueva lista para cargar los datos
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("samir", 19));
        listaPersonas.add(new Persona("pamela", 20));
        listaPersonas.add(new Persona("pamela", 20));
        listaPersonas.add(new Persona("pamela", 20));
        listaPersonas.add(new Persona("pamela", 20));
        listaPersonas.add(new Persona("pamela", 20));
        listaPersonas.add(new Persona("keylor", 28));
        listaPersonas.add(new Persona("ricardo", 25));
        listaPersonas.add(new Persona("ben", 20));
        listaPersonas.add(new Persona("josue", 20));

        // Agregar personas a la base de datos
        for (Persona p : listaPersonas) {
            databaseFacade.agregarPersona(p);
        }

        listaPersonas.clear();
        // Cargar datos de la base de datos
        databaseFacade.cargarPersonas(listaPersonas);

        databaseFacade.borrarPersona("samir",19);
        // Cerrar la conexión a la base de datos
        databaseFacade.cerrarConexion();


        for (Persona p : listaPersonas) {
            System.out.println(p.toString());
        }
    }
}

