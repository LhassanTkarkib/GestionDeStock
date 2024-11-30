package model;

public class Produit {

    // Attributs privés pour encapsuler les données
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur avec tous les attributs pour initialiser un produit avec des valeurs spécifiques
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur par défaut pour initialiser un produit avec des valeurs par défaut
    public Produit() {
        this(0, "", 0, 0.0);
    }

    // Getters et setters pour accéder et modifier les attributs privés
    // Utilisation des getters et setters permet de contrôler l'accès aux attributs et de valider les données si nécessaire
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode pour calculer la valeur totale du produit en stock
    // Intérêt : permet de connaître la valeur financière du stock de ce produit
    public double calculerValeur() {
        return quantite * prix;
    }

    // Méthode toString pour afficher les détails du produit sous forme de chaîne de caractères
    // Intérêt : facilite le débogage et l'affichage des informations du produit
    @Override
    public String toString() {
        return "model.Produit [Code: " + code + ", Nom: " + nom +
                ", Quantité: " + quantite + ", Prix: " + prix + "]";
    }
}