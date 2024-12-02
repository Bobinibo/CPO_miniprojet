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
    private Pion[] elements; 
    private int taille;      

    public Combinaison(Pion[] elements) {
        this.elements = elements;
        this.taille = elements.length;
    }
    
    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Pion[] elements = new Pion[taille];
        Random random = new Random();

        for (int i = 0; i < taille; i++) {
            char couleur = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            elements[i] = new Pion(couleur);
        }

        return new Combinaison(elements);
    }

    
    public int[] comparer(Combinaison autre) {
        int noirs = 0; 
        int blancs = 0; 
        boolean[] visitésAutre = new boolean[taille];
        boolean[] visitésCette = new boolean[taille];

       
        for (int i = 0; i < taille; i++) {
            if (this.elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                noirs++;
                visitésAutre[i] = true;
                visitésCette[i] = true;
            }
        }

       
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

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pion p : elements) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
