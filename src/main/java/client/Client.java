package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import desktopadmin.action.Crud;
 
public class Client {
 
    // Host or IP of Server
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;
 
    public static void main(String[] args) throws Exception {
 
        // Search the registry in the specific Host, Port.
        registry = LocateRegistry.getRegistry(HOST, PORT);
 
        // Lookup WeatherService in the Registry.
        Crud service = (Crud) registry
                .lookup(Crud.class.getSimpleName());
 

        System.out.println(service.getName());
    }
}