/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.rmi.server.UnicastRemoteObject;
import rmi.RemoteInterface;
import java.rmi.RemoteException;

/**
 *
 * @author lahir
 */
public class RemoteClass extends UnicastRemoteObject implements RemoteInterface {
    
    public RemoteClass() throws RemoteException {}

    @Override
    public void remoteMethod() throws RemoteException {
        System.out.println("Client called this method");
    }
}
