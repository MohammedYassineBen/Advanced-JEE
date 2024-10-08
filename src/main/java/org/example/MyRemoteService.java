package org.example;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {

    String hello() throws RemoteException;
    String getBooks() throws RemoteException;
    String addBook() throws RemoteException;
    String deleteBook() throws RemoteException;

    String menu() throws RemoteException;

}
