package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    public MyRemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String hello() throws RemoteException {
        return "Hello From the RMI Server";
    }

    @Override
    public String menu() throws RemoteException {
        List<String> list = new ArrayList<String>();
        list.add("Ajouter un livre");
        list.add("Rechercher un livre");
        list.add("Lister tous les livres");
        list.add("Quitter");

        String listString = "";
        int index = 1;
        for (String s : list)
        {
            listString += "\n"+index +"-" + s ;
            index++;
        }

        return  listString ;
    }

}