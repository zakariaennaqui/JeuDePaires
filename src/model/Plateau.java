package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
    private Carte[][] grille; // 4x4
    private final int lignes = 4;
    private final int colonnes = 4;
    //private final int lignes = 2;
    //private final int colonnes = 2;
    public Plateau() {
        grille = new Carte[lignes][colonnes];
        initialiserGrille();
    }

    private void initialiserGrille() {
        List<Carte> cartes = new ArrayList<>();

        // Liste des noms d'images
        String[] nomsImages = {
            "img1.png", "img2.png", "img3.png", "img4.png",
            "img5.png", "img6.png", "img7.png", "img8.png"
        };

        // Créer 8 paires de cartes (avec images)
        for (int i = 0; i < 8; i++) {
        //for (int i = 0; i < 2; i++) {
        	cartes.add(new CarteImage(i, nomsImages[i]));
            cartes.add(new CarteImage(i, nomsImages[i]));
            //cartes.add(new Carte(i, nomsImages[i]));
            //cartes.add(new Carte(i, nomsImages[i]));
        }

        // Mélanger les cartes
        Collections.shuffle(cartes);

        // Remplir la grille
        int index = 0;
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] = cartes.get(index++);
            }
        }
    }

    public Carte getCarte(int ligne, int colonne) {
        return grille[ligne][colonne];
    }

    public void retournerCarte(int ligne, int colonne) {
        Carte c = grille[ligne][colonne];
        if (!c.isTrouvee()) {
            c.setVisible(true);
        }
    }

    public void cacherCarte(int ligne, int colonne) {
        Carte c = grille[ligne][colonne];
        if (!c.isTrouvee()) {
            c.setVisible(false);
        }
    }

    public boolean verifierPaire(Carte c1, Carte c2) {
        if (c1.getId() == c2.getId()) {
            c1.setTrouvee(true);
            c2.setTrouvee(true);
            return true;
        }
        return false;
    }

    public boolean toutesLesPairesTrouvees() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (!grille[i][j].isTrouvee()) return false;
            }
        }
        return true;
    }

    public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return colonnes;
    }
}
