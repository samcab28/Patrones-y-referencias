package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class Database {
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> col;

    public Database(String connectionString, String dbName, String collectionName) {
        client = MongoClients.create(connectionString);
        db = client.getDatabase(dbName);
        col = db.getCollection(collectionName);
    }

    public void eliminarDocumentos() {
        col.deleteMany(Filters.exists("_id"));
        System.out.println("Todos los documentos han sido eliminados de la colección.");
    }

    public void agregarPersona(Persona persona) {
        String nombre = persona.getNombre();
        int edad = persona.getEdad();

        // Verificar si ya existe una persona con los mismos datos
        Document existingPerson = col.find(Filters.and(
                Filters.eq("nombre", nombre),
                Filters.eq("edad", edad)
        )).first();

        if (existingPerson == null) {
            // No existe una persona con los mismos datos, se puede agregar
            Document personaDoc = new Document("nombre", nombre).append("edad", edad);
            col.insertOne(personaDoc);
        } else {
            System.out.println("La persona ya existe en la base de datos y no se ha agregado.");
        }
    }


    public void cargarPersonas(ArrayList<Persona> listaPersonas) {
        FindIterable<Document> documents = col.find();

        try (MongoCursor<Document> cursor = documents.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String nombre = document.getString("nombre");
                int edad = document.getInteger("edad");
                Persona persona = new Persona(nombre, edad);
                listaPersonas.add(persona);
            }
        }
    }



    public void cerrarConexion() {
        client.close();
    }

    public void borrarPersona(String nombre, int edad) {
        // Construir el filtro para encontrar la persona con el nombre y la edad especificados
        Bson filtro = Filters.and(
                Filters.eq("nombre", nombre),
                Filters.eq("edad", edad)
        );

        // Borrar la persona que cumple con el filtro
        DeleteResult result = col.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            System.out.println("Persona borrada con éxito de la base de datos.");
        } else {
            System.out.println("No se encontró ninguna persona con el nombre y la edad especificados.");
        }
    }

    
}
