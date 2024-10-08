package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {
    String hello() throws RemoteException;
    String menu() throws RemoteException;
    String ajouterLivre(String titre) throws RemoteException;
    String rechercheLivre(String titre) throws RemoteException;
    String listerTousLesLivres() throws RemoteException;
}
