package miniprojet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie {
    private PlateauDeJeu plateau;
    private List<Character> couleursDisponibles;
    private int nbToursMax;

    public Partie(int tailleCombinaison, int nbToursMax, List<Character> couleursDisponibles) {
        this.couleursDisponibles = couleursDisponibles;
        this.nbToursMax = nbToursMax;

        List<Pion> combinaisonSecrete = new ArrayList<>();
        for (int i = 0; i < tailleCombinaison; i++) {
            char couleur = couleursDisponibles.get((int) (Math.random() * couleursDisponibles.size()));
            combinaisonSecrete.add(new Pion(couleur));
        }

        this.plateau = new PlateauDeJeu(new Combinaison(combinaisonSecrete));
    }

    public void afficherRegles() {
        System.out.println("Bienvenue au Mastermind !");
        System.out.println("Le but du jeu est de deviner une combinaison secrete composee de couleurs.");
        System.out.println("Chaque combinaison contient un certain nombre de pions de couleurs differentes.");
        System.out.println("A chaque tentative, vous devez entrer une combinaison de la meme longueur.");
        System.out.println("Le jeu vous donnera des indices :");
        System.out.println("- Un pion noir pour chaque couleur bien placee.");
        System.out.println("- Un pion blanc pour chaque couleur correcte mais mal placee.");
        System.out.println("Le jeu s'arrete si vous trouvez la combinaison ou si vous utilisez toutes vos tentatives.");
        System.out.println("Couleurs disponibles : " + couleursDisponibles);
        System.out.println("Bonne chance !");
    }

    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        int toursRestants = nbToursMax;

        while (toursRestants > 0) {
            System.out.println("\nTentatives restantes : " + toursRestants);
            System.out.println("Entrez votre tentative (ex: RGBY) :");
            String tentativeStr = scanner.nextLine().toUpperCase();

            List<Pion> pions = new ArrayList<>();
            boolean valid = true;
            for (char c : tentativeStr.toCharArray()) {
                if (!couleursDisponibles.contains(c)) {
                    System.out.println("Couleur invalide : " + c + ". Reessayez.");
                    valid = false;
                    break;
                }
                pions.add(new Pion(c));
            }
            if (!valid || pions.size() != plateau.getCombinaisonSecrete().getPions().size()) {
                System.out.println("Votre tentative doit contenir exactement " +
                                   plateau.getCombinaisonSecrete().getPions().size() + " couleurs.");
                continue;
            }

            Combinaison tentative = new Combinaison(pions);
            plateau.ajouterTentative(tentative);
            afficherIndices(tentative);

            if (verifierVictoire(tentative)) {
                System.out.println("Felicitations ! Vous avez trouve la combinaison secrete !");
                return;
            }

            toursRestants--;
        }

        System.out.println("\nDommage, vous avez utilise toutes vos tentatives !");
        System.out.println("La combinaison secrete etait : " + afficherCombinaison(plateau.getCombinaisonSecrete()));
    }

    private void afficherIndices(Combinaison tentative) {
        Combinaison secrete = plateau.getCombinaisonSecrete();
        int noirs = 0, blancs = 0;

        boolean[] secreteUtilisee = new boolean[secrete.getPions().size()];
        boolean[] tentativeUtilisee = new boolean[tentative.getPions().size()];

        for (int i = 0; i < secrete.getPions().size(); i++) {
            if (secrete.getPions().get(i).getCouleur() == tentative.getPions().get(i).getCouleur()) {
                noirs++;
                secreteUtilisee[i] = true;
                tentativeUtilisee[i] = true;
            }
        }

        for (int i = 0; i < tentative.getPions().size(); i++) {
            if (!tentativeUtilisee[i]) {
                for (int j = 0; j < secrete.getPions().size(); j++) {
                    if (!secreteUtilisee[j] &&
                        tentative.getPions().get(i).getCouleur() == secrete.getPions().get(j).getCouleur()) {
                        blancs++;
                        secreteUtilisee[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println("Indices : " + noirs + " noir(s), " + blancs + " blanc(s).");
    }

    private boolean verifierVictoire(Combinaison tentative) {
        Combinaison secrete = plateau.getCombinaisonSecrete();
        for (int i = 0; i < secrete.getPions().size(); i++) {
            if (secrete.getPions().get(i).getCouleur() != tentative.getPions().get(i).getCouleur()) {
                return false;
            }
        }
        return true;
    }

    private String afficherCombinaison(Combinaison combinaison) {
        StringBuilder sb = new StringBuilder();
        for (Pion p : combinaison.getPions()) {
            sb.append(p.getCouleur()).append(" ");
        }
        return sb.toString().trim();
    }
}
