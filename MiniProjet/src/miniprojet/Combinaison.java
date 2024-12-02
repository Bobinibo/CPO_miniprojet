/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Random;

public class Combinaison {
    private final Pion[] elements;

    public Combinaison(Pion[] elements) {
        this.elements = elements;
    }

    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Random random = new Random();
        Pion[] pions = new Pion[taille];
        for (int i = 0; i < taille; i++) {
            char couleurAleatoire = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            pions[i] = new Pion(couleurAleatoire);
        }
        return new Combinaison(pions);
    }

    public int[] comparer(Combinaison autre) {
        int noirs = 0;
        int blancs = 0;

        boolean[] marquesSecrete = new boolean[elements.length];
        boolean[] marquesAutre = new boolean[elements.length];

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                noirs++;
                marquesSecrete[i] = true;
                marquesAutre[i] = true;
            }
        }

        for (int i = 0; i < elements.length; i++) {
            if (!marquesSecrete[i]) {
                for (int j = 0; j < autre.elements.length; j++) {
                    if (!marquesAutre[j] && elements[i].getCouleur() == autre.elements[j].getCouleur()) {
                        blancs++;
                        marquesSecrete[i] = true;
                        marquesAutre[j] = true;
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
            sb.append(p);
        }
        return sb.toString();
    }
}

