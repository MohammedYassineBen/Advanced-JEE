package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class RMIServer {
    public static void main(String[] args) {
        try {
            MyRemoteService service = new MyRemoteServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("MyRemoteService", service);
            System.out.println("RMI Server ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
