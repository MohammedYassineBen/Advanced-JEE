package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    private List<Livre> livres;
    public MyRemoteServiceImpl() throws RemoteException {
        super();
        livres = new ArrayList<>();
    }

//    List<String> list = new ArrayList<String>();

    @Override
    public String hello() throws RemoteException {
        return "Welcome from Server";
    }

    @Override
    public List<Livre> getBooks() throws RemoteException {
        return livres;
    }

    @Override
    public Boolean addBook(Livre livre) throws RemoteException {
        return livres.add(livre);
    }

    @Override
    public Livre findBook(String titre) throws RemoteException {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre))
                return livre;
        }
        System.out.println("Book Not Found!");
        return null;
    }

//    @Override
//    public Boolean deleteBook(long isbn) throws RemoteException {
//
//    }

    @Override
    public StringBuilder menu() throws RemoteException {
        StringBuilder menu = new StringBuilder();
        menu.append("\t #### MENU ###: \n");
        menu.append("1. Ajouter un livre\n");
        menu.append("2. Rechercher un livre\n");
        menu.append("3. Lister tous les livres\n");
        menu.append("4. Quitter\n");
        menu.append("Choisissez une option: ");
        return menu;
    }

}
