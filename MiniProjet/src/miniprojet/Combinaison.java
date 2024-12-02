/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Combinaison {
    private Pion[] elements;
    private int taille;

    public Combinaison(Pion[] elements) {
        this.elements = elements;
        this.taille = elements.length;
    }

    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Random random = new Random();
        Pion[] elements = new Pion[taille];
        for (int i = 0; i < taille; i++) {
            char couleur = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            elements[i] = new Pion(couleur);
        }
        return new Combinaison(elements);
    }

    public int[] comparer(Combinaison autre) {
        int noirs = 0;
        int blancs = 0;
        boolean[] verifieAutre = new boolean[taille];
        boolean[] verifieCourant = new boolean[taille];

        for (int i = 0; i < taille; i++) {
            if (elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                noirs++;
                verifieCourant[i] = true;
                verifieAutre[i] = true;
            }
        }

        for (int i = 0; i < taille; i++) {
            if (!verifieCourant[i]) {
                for (int j = 0; j < taille; j++) {
                    if (!verifieAutre[j] && elements[i].getCouleur() == autre.elements[j].getCouleur()) {
                        blancs++;
                        verifieAutre[j] = true;
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
        for (Pion pion : elements) {
            sb.append(pion);
        }
        return sb.toString();
    }
}
