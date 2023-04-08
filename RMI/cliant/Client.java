package cliant;

import java.net.MalformedURLException;
import rmi.RemoteInterface;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    public static void main(String[] args) {
        try {
            RemoteInterface ri = (RemoteInterface) Naming.lookup("rmi://localhost:5050/RemoteServer");
            ri.remoteMethod();
            
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
