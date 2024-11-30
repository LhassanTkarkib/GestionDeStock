import service.implimentation.GestionServiceImpl;
import service.GestionServiceInterface;

import java.util.Scanner;

public class GestionStock {

    // Utilisation de l'interface pour permettre une flexibilité et une extensibilité
    private static GestionServiceInterface gestionService = new GestionServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            // Utilisation d'un switch pour gérer les différentes options du menu
            switch (choix) {
                case 1:
                    gestionService.ajouterProduit(scanner);
                    break;
                case 2:
                    gestionService.modifierProduit(scanner);
                    break;
                case 3:
                    gestionService.supprimerProduit(scanner);
                    break;
                case 4:
                    gestionService.afficherProduits();
                    break;
                case 5:
                    gestionService.rechercherProduit(scanner);
                    break;
                case 6:
                    gestionService.calculerValeurStock();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    // Méthode pour afficher le menu
    // Intérêt : permet à l'utilisateur de choisir une action à effectuer
    public static void printMenu() {
        System.out.println("\n=== Menu de Gestion de Stock ===");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher les produits");
        System.out.println("5. Rechercher un produit");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("0. Quitter");
        System.out.print("Choisissez une option: ");
    }
}