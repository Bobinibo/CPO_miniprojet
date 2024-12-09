/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;

import java.util.Arrays;

public class MiniProjet {
    public static void main(String[] args) {
        var couleursDisponibles = Arrays.asList('R', 'B', 'G', 'Y', 'O', 'P');
        Partie partie = new Partie(4, 10, couleursDisponibles);
        partie.afficherRegles();
        partie.lancerPartie();
    }
}