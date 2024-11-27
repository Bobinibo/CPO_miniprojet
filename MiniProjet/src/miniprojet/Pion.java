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
    private char couleur; // Couleur du pion, représentée par un caractère (ex. 'R', 'B', etc.)

    // Constructeur qui initialise un pion avec une couleur donnée
    public Pion(char couleur) {
        this.couleur = couleur;
    }

    // Méthode pour récupérer la couleur du pion
    public char getCouleur() {
        return couleur;
    }

    // Méthode pour représenter le pion sous forme textuelle
    @Override
    public String toString() {
        return String.valueOf(couleur);
    }
}
