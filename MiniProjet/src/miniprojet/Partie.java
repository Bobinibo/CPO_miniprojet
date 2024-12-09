/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package miniprojet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie {
    private PlateauDeJeu plateau;
    private List<Character> couleursDisponibles;

    public Partie(int tailleCombinaison, int nbToursMax, List<Character> couleursDisponibles) {
        this.couleursDisponibles = couleursDisponibles;
        List<Pion> combinaisonSecrete = new ArrayList<>();
        for (int i = 0; i < tailleCombinaison; i++) {
            char couleur = couleursDisponibles.get((int) (Math.random() * couleursDisponibles.size()));
            combinaisonSecrete.add(new Pion(couleur));
        }
        this.plateau = new PlateauDeJeu(new Combinaison(combinaisonSecrete));
    }

    public void afficherRegles() {
        System.out.println("Bienvenue au Mastermind !");
        System.out.println("Essayez de deviner la combinaison secrete de 4 couleurs en 12 essais maximum.");
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Entrez votre tentative (ex: RGBY) :");
            String tentativeStr = scanner.nextLine().toUpperCase();
            List<Pion> pions = new ArrayList<>();
            for (char c : tentativeStr.toCharArray()) {
                if (!couleursDisponibles.contains(c)) {
                    System.out.println("Couleur invalide. Reessayez.");
                    continue;
                }
                pions.add(new Pion(c));
            }
            Combinaison tentative = new Combinaison(pions);
            plateau.ajouterTentative(tentative);
            System.out.println("Tentative ajoutee : " + tentativeStr);
        }
    }
}