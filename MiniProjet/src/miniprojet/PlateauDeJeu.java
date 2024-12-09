/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.List;

public class PlateauDeJeu {
    private Combinaison combinaisonSecrete;
    private List<Combinaison> tentatives;

    public PlateauDeJeu(Combinaison combinaisonSecrete) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.tentatives = new ArrayList<>();
    }

    public void ajouterTentative(Combinaison tentative) {
        tentatives.add(tentative);
    }

    public List<Combinaison> getTentatives() {
        return tentatives;
    }

    public Combinaison getCombinaisonSecrete() {
        return combinaisonSecrete;
    }
}