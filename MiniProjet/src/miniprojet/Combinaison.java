/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

/**
 *
 * @author lilou
 */
import java.util.ArrayList;
import java.util.Random;

public class Combinaison {
    private Pion[] elements; // Tableau de pions représentant la combinaison
    private int taille;      // Taille de la combinaison

    // Constructeur pour initialiser une combinaison à partir d'un tableau de pions
    public Combinaison(Pion[] elements) {
        this.elements = elements;
        this.taille = elements.length;
    }

    // Génère une combinaison aléatoire
    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Pion[] elements = new Pion[taille];
        Random random = new Random();

        for (int i = 0; i < taille; i++) {
            char couleur = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            elements[i] = new Pion(couleur);
        }

        return new Combinaison(elements);
    }

    // Compare cette combinaison avec une autre et retourne le nombre de pions bien et mal placés
    public int[] comparer(Combinaison autre) {
        int noirs = 0; // Bien placés
        int blancs = 0; // Mal placés
        boolean[] visitésAutre = new boolean[taille];
        boolean[] visitésCette = new boolean[taille];

        // Étape 1 : Calcul des bien placés (noirs)
        for (int i = 0; i < taille; i++) {
            if (this.elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                noirs++;
                visitésAutre[i] = true;
                visitésCette[i] = true;
            }
        }

        // Étape 2 : Calcul des mal placés (blancs)
        for (int i = 0; i < taille; i++) {
            if (!visitésCette[i]) {
                for (int j = 0; j < taille; j++) {
                    if (!visitésAutre[j] && this.elements[i].getCouleur() == autre.elements[j].getCouleur()) {
                        blancs++;
                        visitésAutre[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{noirs, blancs};
    }

    // Méthode pour afficher la combinaison sous forme textuelle
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pion p : elements) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
