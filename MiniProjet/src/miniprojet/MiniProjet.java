/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;

/**
 *
 * @author alois
 */
public class MiniProjet {
    public static void main(String[] args) {
        Pion pionRouge = new Pion(Pion.ROUGE);
        Pion pionBleu = new Pion(Pion.BLEU);
        Pion pionVert = new Pion(Pion.VERT);
        Pion pionJaune = new Pion(Pion.JAUNE);
        Pion pionOrange = new Pion(Pion.ORANGE);
        Pion pionMarron = new Pion(Pion.MARRON);
        Pion pionBlanc = new Pion(Pion.BLANC);
        Pion pionNoir = new Pion(Pion.NOIR);

        System.out.println("Pion Rouge : " + pionRouge);
        System.out.println("Pion Bleu : " + pionBleu);
        System.out.println("Pion Vert : " + pionVert);
        System.out.println("Pion Jaune : " + pionJaune);
        System.out.println("Pion Orange : " + pionOrange);
        System.out.println("Pion Marron : " + pionMarron);
        System.out.println("Pion Blanc : " + pionBlanc);
        System.out.println("Pion Noir : " + pionNoir);
    }
}

