package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    private List<String> livres;

    public MyRemoteServiceImpl() throws RemoteException {
        super();
        livres = new ArrayList<>();

    }

    @Override
    public String hello() throws RemoteException {
        return "Hello From the RMI Server";
    }

    @Override
    public String menu() throws RemoteException {
        return "1- Ajouter un livre\n2- Rechercher un livre\n3- Lister tous les livres\n4- Quitter";
    }

    @Override
    public String ajouterLivre(String titre) throws RemoteException {
        livres.add(titre);
        return "Livre '" + titre + "' ajouté avec succès.";
    }

    @Override
    public String rechercheLivre(String titre) throws RemoteException {
        for (String livre : livres) {
            if (livre.equalsIgnoreCase(titre)) {
                return "Le livre '" + titre + "' est disponible.";
            }
        }
        return "Le livre '" + titre + "' n'a pas été trouvé.";
    }

    @Override
    public String listerTousLesLivres() throws RemoteException {
        if (livres.isEmpty()) {
            return "Aucun livre disponible.";
        }
        return "Livres disponibles : " + String.join(", ", livres);
    }
}
