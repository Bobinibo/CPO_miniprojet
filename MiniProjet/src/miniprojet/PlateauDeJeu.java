/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;

public class PlateauDeJeu {
    private Combinaison combinaisonSecrete;
    private ArrayList<Combinaison> tentatives;
    private ArrayList<String> reponses;
    private int nbToursMax;

    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.nbToursMax = nbToursMax;
        this.tentatives = new ArrayList<>();
        this.reponses = new ArrayList<>();
    }

    public void proposerCombinaison(Combinaison tentative) {
        tentatives.add(tentative);
        int[] indices = combinaisonSecrete.comparer(tentative);
        reponses.add(indices[0] + " noirs, " + indices[1] + " blancs");
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
