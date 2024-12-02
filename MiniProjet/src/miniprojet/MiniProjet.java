/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MiniProjet {
    public static void main(String[] args) {
        ArrayList<Character> couleursDisponibles = new ArrayList<>(Arrays.asList('R', 'B', 'G', 'Y', 'O', 'P'));
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(4, couleursDisponibles);
        System.out.println("Une combinaison secrete a ete generee. A vous de la deviner !");
        System.out.println("Les couleurs disponibles sont : R (Rouge), B (Bleu), G (Vert), Y (Jaune), O (Orange), P (Rose)");

        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);
        Scanner scanner = new Scanner(System.in);

        while (!plateau.estVictoire() && !plateau.estDefaite()) {
            System.out.print("Entrez une combinaison de 4 couleurs (exemple : RBGY) : ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() != 4 || !input.chars().allMatch(c -> couleursDisponibles.contains((char) c))) {
                System.out.println("Entree invalide. Assurez-vous que votre saisie contient exactement 4 lettres parmi : R, B, G, Y, O, P.");
                continue;
            }

            Pion[] pions = new Pion[4];
            for (int i = 0; i < 4; i++) {
                pions[i] = new Pion(input.charAt(i));
            }

            Combinaison tentative = new Combinaison(pions);
            plateau.proposerCombinaison(tentative);

            if (plateau.estVictoire()) {
                System.out.println("Felicitations ! Vous avez devine la combinaison secrete !");
            } else if (plateau.estDefaite()) {
                System.out.println("Vous avez epuise tous vos essais. La combinaison secrete etait : " + combinaisonSecrete);
            } else {
                plateau.afficherPlateau();
            }
        }
    }
}

