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
        livres.add("Clean Code: A Handbook of Agile Software de Jamal  ");
        livres.add("Introduction to the Theory of Computation de Hakim ");

        livres.add("Artificial Intelligence: A Modern Approach de Karim Karimi");
        livres.add("The Pragmatic Programmer: Your Journey to Mastery de Mohammed yassine Benaouija e");

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
