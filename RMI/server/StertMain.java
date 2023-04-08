package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class StertMain {
    public static void main(String[] args) {
        try {
            Registry rmiRegistry = LocateRegistry.createRegistry(5050);
            rmiRegistry.rebind("RemoteServer", new RemoteClass());
            System.out.println("Remote Server Stert .....");
            
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
