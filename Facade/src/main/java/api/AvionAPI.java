package api;

public class AvionAPI {

    public void buscarVuelos(String fechaIda, String fechaVuelta, String origen, String destino){
        System.out.println("====================");
        System.out.println("vuelos encontrados para: " + destino +" desde: " + origen);
        System.out.println("fecha ida: " + fechaIda + " fecha vuelta: " + fechaVuelta);
        System.out.println("====================");
    }
}
