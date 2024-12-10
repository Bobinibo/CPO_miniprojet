package miniprojet;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MiniProjet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue au Mastermind !");
        afficherRegles();

        System.out.println("\nChoisissez un mode de difficulte :");
        System.out.println("1 - Facile (12 tentatives)");
        System.out.println("2 - Moyen (10 tentatives)");
        System.out.println("3 - Expert (6 tentatives)");

        int difficulte;
        while (true) {
            try {
                System.out.print("Votre choix : ");
                difficulte = Integer.parseInt(scanner.nextLine());
                if (difficulte >= 1 && difficulte <= 3) break;
                System.out.println("Veuillez entrer un nombre entre 1 et 3.");
            } catch (NumberFormatException e) {
                System.out.println("Entree invalide. Veuillez entrer un nombre.");
            }
        }

        int nbToursMax = switch (difficulte) {
            case 1 -> 12;
            case 2 -> 10;
            case 3 -> 6;
            default -> 10;
        };

        List<Character> couleursDisponibles = Arrays.asList('R', 'B', 'G', 'Y', 'O', 'P');
        Partie partie = new Partie(4, nbToursMax, couleursDisponibles);
        partie.lancerPartie();
    }

    public static void afficherRegles() {
        System.out.println("\nRegles du jeu :");
        System.out.println("Le but du jeu est de deviner une combinaison secrete composee de couleurs.");
        System.out.println("Chaque combinaison contient un certain nombre de pions de couleurs differentes.");
        System.out.println("A chaque tentative, vous devez entrer une combinaison de la meme longueur.");
        System.out.println("Le jeu vous donnera des indices :");
        System.out.println("- Un pion noir pour chaque couleur bien placee.");
        System.out.println("- Un pion blanc pour chaque couleur correcte mais mal placee.");
        System.out.println("Le jeu s'arrete si vous trouvez la combinaison ou si vous utilisez toutes vos tentatives.");
        System.out.println("Couleurs disponibles : R (Rouge), B (Bleu), G (Vert), Y (Jaune), O (Orange), P (Rose)");
        System.out.println("Bonne chance !");
    }
}