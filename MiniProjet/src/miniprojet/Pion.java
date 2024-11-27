/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

/**
 *
 * @author alois
 */

public class Pion {
    public static final char ROUGE = 'R';
    public static final char BLEU = 'B';
    public static final char VERT = 'V';
    public static final char JAUNE = 'J';
    public static final char ORANGE = 'O';
    public static final char MARRON = 'M';
    public static final char BLANC = 'W';
    public static final char NOIR = 'N';

    private char couleur; 

    public Pion(char couleur) {
        this.couleur = couleur;
    }

    // Getter pour la couleur
    public char getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return String.valueOf(couleur);
    }
}
