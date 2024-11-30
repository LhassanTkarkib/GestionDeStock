package service;

import java.util.Scanner;

public interface GestionServiceInterface {

    // Méthode pour ajouter un produit
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    void ajouterProduit(Scanner scanner);

    // Méthode pour modifier un produit existant
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    void modifierProduit(Scanner scanner);

    // Méthode pour supprimer un produit
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    void supprimerProduit(Scanner scanner);

    // Méthode pour afficher tous les produits
    // Intérêt : permet de visualiser l'ensemble des produits en stock
    void afficherProduits();

    // Méthode pour rechercher un produit par son nom
    // Utilisation d'un Scanner pour lire les entrées utilisateur
    void rechercherProduit(Scanner scanner);

    // Méthode pour calculer la valeur totale du stock
    // Intérêt : permet de connaître la valeur financière totale des produits en stock
    void calculerValeurStock();
}