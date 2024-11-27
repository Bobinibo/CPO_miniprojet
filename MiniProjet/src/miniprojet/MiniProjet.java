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
      
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R'); 
        couleursDisponibles.add('B'); 
        couleursDisponibles.add('G'); 
        couleursDisponibles.add('Y'); 
        couleursDisponibles.add('O'); 
        couleursDisponibles.add('P'); 

        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(4, couleursDisponibles);
        System.out.println("Combinaison secrète générée : " + combinaisonSecrete);

        Pion[] pionsProposes = {new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')};
        Combinaison combinaisonProposee = new Combinaison(pionsProposes);
        System.out.println("Combinaison proposée : " + combinaisonProposee);

        int[] resultats = combinaisonSecrete.comparer(combinaisonProposee);
        System.out.println("Bien placés (noirs) : " + resultats[0]);
        System.out.println("Mal placés (blancs) : " + resultats[1]);
    }
}


