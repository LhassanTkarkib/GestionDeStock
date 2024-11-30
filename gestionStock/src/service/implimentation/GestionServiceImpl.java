package service.implimentation;

import model.Produit;
import service.GestionServiceInterface;

import java.util.Scanner;

public class GestionServiceImpl implements GestionServiceInterface {

    // Tableau pour stocker les produits
    private static Produit[] produits = new Produit[100];
    private static int produitCount = 0;

    // Méthode pour ajouter un produit
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    @Override
    public void ajouterProduit(Scanner scanner) {
        if (produitCount >= 100) {
            System.out.println("Le stock est plein !");
            return;
        }

        System.out.print("Code: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        if (chercherProduitParCode(code) != -1) {
            System.out.println("Le code du produit doit être unique.");
            return;
        }

        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Quantité: ");
        int quantite = scanner.nextInt();
        System.out.print("Prix: ");
        double prix = scanner.nextDouble();

        produits[produitCount++] = new Produit(code, nom, quantite, prix);
        System.out.println("Produit ajouté avec succès !");
    }

    // Méthode pour modifier un produit existant
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    @Override
    public void modifierProduit(Scanner scanner) {
        System.out.print("Entrez le code du produit à modifier: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
        int index = chercherProduitParCode(code);

        if (index == -1) {
            System.out.println("Produit introuvable.");
            return;
        }

        System.out.print("Nouveau nom: ");
        String nouveauNom = scanner.nextLine();
        System.out.print("Nouvelle quantité: ");
        int nouvelleQuantite = scanner.nextInt();
        System.out.print("Nouveau prix: ");
        double nouveauPrix = scanner.nextDouble();

        produits[index].setNom(nouveauNom);
        produits[index].setQuantite(nouvelleQuantite);
        produits[index].setPrix(nouveauPrix);

        System.out.println("Produit modifié avec succès !");
    }

    // Méthode pour supprimer un produit
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    @Override
    public void supprimerProduit(Scanner scanner) {
        System.out.print("Entrez le code du produit à supprimer: ");
        int code = scanner.nextInt();
        int index = chercherProduitParCode(code);

        if (index == -1) {
            System.out.println("Produit introuvable.");
            return;
        }

        for (int i = index; i < produitCount - 1; i++) {
            produits[i] = produits[i + 1];
        }
        produits[--produitCount] = null;
        System.out.println("Produit supprimé avec succès !");
    }

    // Méthode pour afficher tous les produits
    // Intérêt : permet de visualiser l'ensemble des produits en stock
    @Override
    public void afficherProduits() {
        if (produitCount == 0) {
            System.out.println("Aucun produit en stock.");
            return;
        }
        for (int i = 0; i < produitCount; i++) {
            System.out.println(produits[i]);
        }
    }

    // Méthode pour rechercher un produit par son nom
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    @Override
    public void rechercherProduit(Scanner scanner) {
        System.out.print("Entrez le nom du produit à rechercher: ");
        String nom = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < produitCount; i++) {
            if (produits[i].getNom().equalsIgnoreCase(nom)) {
                System.out.println(produits[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Produit introuvable.");
        }
    }

    // Méthode pour calculer la valeur totale du stock
    // Intérêt : permet de connaître la valeur financière totale des produits en stock
    @Override
    public void calculerValeurStock() {
        double valeurTotale = 0;
        for (int i = 0; i < produitCount; i++) {
            valeurTotale += produits[i].calculerValeur();
        }
        System.out.println("Valeur totale du stock : " + valeurTotale);
    }

    // Méthode pour chercher un produit par son code
    // Intérêt : permet de trouver l'index d'un produit dans le tableau
    private int chercherProduitParCode(int code) {
        for (int i = 0; i < produitCount; i++) {
            if (produits[i].getCode() == code) {
                return i;
            }
        }
        return -1;
    }
}