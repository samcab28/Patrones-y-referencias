package org.example;


import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb+srv://testUser:ONY5sbOldyfHGLuP@cluster0.f8vttt6.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("SampleDB");

        MongoCollection col = db.getCollection("sampleCollection");

        // Elimina todos los documentos de la colección "sampleCollection"
        //col.deleteMany(Filters.exists("_id"));
        //System.out.println("Todos los documentos han sido eliminados de la colección 'sampleCollection'.");

        ArrayList<Persona> listaPersonas = new ArrayList<>();

        //listaPersonas.add(new Persona("samir",19));
        //listaPersonas.add(new Persona("pamela",20));

        //se cargan los datos a la base de datos
        /*for(Persona p: listaPersonas){
            System.out.println(p.toString());

            Document personaDoc = new Document("nombre", p.getNombre()).append("edad", p.getEdad());
            col.insertOne(personaDoc);
        }*/

        //se borra la base de datos
        listaPersonas.clear();

        //se traen los datos de la base de datos
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

        for (Persona p : listaPersonas) {
            System.out.println(p.toString());
        }



    }
}
