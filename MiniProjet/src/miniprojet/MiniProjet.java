/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;
import java.util.ArrayList;
/**
 *
 * @author alois
 */

public class MiniProjet {
    public static void main(String[] args) {
        // Couleurs disponibles pour les pions
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R'); // Rouge
        couleursDisponibles.add('B'); // Bleu
        couleursDisponibles.add('G'); // Vert
        couleursDisponibles.add('Y'); // Jaune
        couleursDisponibles.add('O'); // Orange
        couleursDisponibles.add('P'); // Violet

        // Génération d'une combinaison aléatoire
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(4, couleursDisponibles);
        System.out.println("Combinaison secrète générée : " + combinaisonSecrete);

        // Création d'une combinaison proposée
        Pion[] pionsProposes = {new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')};
        Combinaison combinaisonProposee = new Combinaison(pionsProposes);
        System.out.println("Combinaison proposée : " + combinaisonProposee);

        // Comparaison des combinaisons
        int[] resultats = combinaisonSecrete.comparer(combinaisonProposee);
        System.out.println("Bien placés (noirs) : " + resultats[0]);
        System.out.println("Mal placés (blancs) : " + resultats[1]);
    }
}


