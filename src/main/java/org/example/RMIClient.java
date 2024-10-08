package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MyRemoteService service = (MyRemoteService) registry.lookup("MyRemoteService");

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println(service.menu());
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consommer la ligne restante

                switch (choice) {
                    case 1:
                        System.out.print("Entrez le titre du livre à ajouter : ");
                        String titre = scanner.nextLine();
                        System.out.println(service.ajouterLivre(titre));
                        break;
                    case 2:
                        System.out.print("Entrez le titre du livre à rechercher : ");
                        String titreRecherche = scanner.nextLine();
                        System.out.println(service.rechercheLivre(titreRecherche));
                        break;
                    case 3:
                        System.out.println(service.listerTousLesLivres());
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }

            scanner.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
