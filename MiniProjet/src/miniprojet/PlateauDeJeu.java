/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;

public class PlateauDeJeu {
    private final Combinaison combinaisonSecrete;
    private final ArrayList<Combinaison> tentatives = new ArrayList<>();
    private final ArrayList<String> reponses = new ArrayList<>();
    private final int nbToursMax;

    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.nbToursMax = nbToursMax;
    }

    public void proposerCombinaison(Combinaison tentative) {
        tentatives.add(tentative);
        int[] resultat = combinaisonSecrete.comparer(tentative);
        reponses.add(resultat[0] + " noirs, " + resultat[1] + " blancs");
    }

    public void afficherPlateau() {
        System.out.println("Historique des tentatives :");
        for (int i = 0; i < tentatives.size(); i++) {
            System.out.println("Tentative " + (i + 1) + ": " + tentatives.get(i) + " -> " + reponses.get(i));
        }
    }

    public boolean estVictoire() {
        return !tentatives.isEmpty() && combinaisonSecrete.toString().equals(tentatives.get(tentatives.size() - 1).toString());
    }

    public boolean estDefaite() {
        return tentatives.size() >= nbToursMax;
    }
}
