/*package controller;

import model.Carte;
import model.DatabaseManager;
import model.Plateau;
import view.JeuFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JeuController {
    private JeuFrame vue;
    private Plateau plateau;
    private JButton[][] boutons;
    private Carte premiereCarte = null;
    private Carte deuxiemeCarte = null;
    private int essaisRestants = 3;
    private int secondes = 0;
    private Timer timer;

    public JeuController(JeuFrame vue) {
        this.vue = vue;
        this.plateau = vue.getPlateau();
        this.boutons = vue.getBoutons();
        initialiserActions();
        demarrerChrono();
    }

    private void initialiserActions() {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                int ligne = i;
                int colonne = j;
                boutons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gererClic(ligne, colonne);
                    }
                });
            }
        }
    }

    private void gererClic(int ligne, int colonne) {
        Carte carte = plateau.getCarte(ligne, colonne);
        if (carte.isVisible() || carte.isTrouvee()) return;

        plateau.retournerCarte(ligne, colonne);
        JButton bouton = boutons[ligne][colonne];
        bouton.setIcon(carte.getIcon());
        bouton.setEnabled(false);

        if (premiereCarte == null) {
            premiereCarte = carte;
        } else if (deuxiemeCarte == null) {
            deuxiemeCarte = carte;
            verifierPaire();
        }
    }

    private void verifierPaire() {
        if (plateau.verifierPaire(premiereCarte, deuxiemeCarte)) {
            reinitialiserSelection();
            verifierFin();
        } else {
            essaisRestants--;
            vue.getEssaisLabel().setText("Essais restants : " + essaisRestants);

            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    cacherCarte(premiereCarte);
                    cacherCarte(deuxiemeCarte);
                    miseAJourBoutons();
                    reinitialiserSelection();
                    verifierFin();
                }
            }, 1000);
        }
    }

    private void cacherCarte(Carte c) {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                if (plateau.getCarte(i, j) == c) {
                    plateau.cacherCarte(i, j);
                }
            }
        }
    }

    private void miseAJourBoutons() {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                Carte c = plateau.getCarte(i, j);
                JButton bouton = boutons[i][j];
                if (c.isVisible() || c.isTrouvee()) {
                    bouton.setIcon(c.getIcon());
                    bouton.setEnabled(false);
                } else {
                    bouton.setIcon(null);
                    bouton.setEnabled(true);
                }
            }
        }
    }

    private void reinitialiserSelection() {
        premiereCarte = null;
        deuxiemeCarte = null;
    }

    private void verifierFin() {
        if (plateau.toutesLesPairesTrouvees()) {
            arreterChrono();

            int temps = secondes;
            List<Integer> meilleurs = DatabaseManager.getMeilleursTemps();
            boolean dansTop3 = meilleurs.size() < 3 || temps < meilleurs.get(meilleurs.size() - 1);

            if (dansTop3) {
                String nom = JOptionPane.showInputDialog(vue, "Bravo ! Entrez votre nom :");
                if (nom != null && !nom.isEmpty()) {
                    DatabaseManager.insererScore(nom, temps);
                }
            }

            JOptionPane.showMessageDialog(vue, "Félicitations ! Temps : " + temps + " secondes");
        } else if (essaisRestants == 0) {
            arreterChrono();
            JOptionPane.showMessageDialog(vue, "Dommage ! Vous avez perdu !");
        }
    }

    private void demarrerChrono() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondes++;
                SwingUtilities.invokeLater(() -> {
                    vue.getChronoLabel().setText("Temps : " + secondes + " sec");
                });
            }
        }, 1000, 1000);
    }

    private void arreterChrono() {
        if (timer != null) {
            timer.cancel();
        }
    }
}*/


package controller;

import model.Carte;
import model.DatabaseManager;
import model.Plateau;
import view.JeuFrame;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JeuController {
    private JeuFrame vue;
    private Plateau plateau;
    private JLabel[][] labels;
    private Carte premiereCarte = null;
    private Carte deuxiemeCarte = null;
    private int essaisRestants = 3;
    private int secondes = 0;
    private Timer timer;

    public JeuController(JeuFrame vue) {
        this.vue = vue;
        this.plateau = vue.getPlateau();
        this.labels = vue.getLabels();
        initialiserActions();
        demarrerChrono();
    }

    private void initialiserActions() {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                int ligne = i;
                int colonne = j;
                labels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        gererClic(ligne, colonne);
                    }
                });
            }
        }
    }

    private void gererClic(int ligne, int colonne) {
        Carte carte = plateau.getCarte(ligne, colonne);
        if (carte.isVisible() || carte.isTrouvee()) return;

        plateau.retournerCarte(ligne, colonne);
        JLabel label = labels[ligne][colonne];
        label.setIcon(carte.getIcon());

        if (premiereCarte == null) {
            premiereCarte = carte;
        } else if (deuxiemeCarte == null) {
            deuxiemeCarte = carte;
            verifierPaire();
        }
    }

    private void verifierPaire() {
        if (plateau.verifierPaire(premiereCarte, deuxiemeCarte)) {
            reinitialiserSelection();
            verifierFin();
        } else {
            essaisRestants--;
            vue.getEssaisLabel().setText("Essais restants : " + essaisRestants);

            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    cacherCarte(premiereCarte);
                    cacherCarte(deuxiemeCarte);
                    miseAJourLabels();
                    reinitialiserSelection();
                    verifierFin();
                }
            }, 1000);
        }
    }

    private void cacherCarte(Carte c) {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                if (plateau.getCarte(i, j) == c) {
                    plateau.cacherCarte(i, j);
                }
            }
        }
    }

    private void miseAJourLabels() {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                Carte c = plateau.getCarte(i, j);
                JLabel label = labels[i][j];
                if (c.isVisible() || c.isTrouvee()) {
                    label.setIcon(c.getIcon());
                } else {
                    label.setIcon(null);
                }
            }
        }
    }

    private void reinitialiserSelection() {
        premiereCarte = null;
        deuxiemeCarte = null;
    }

    private void verifierFin() {
        if (plateau.toutesLesPairesTrouvees()) {
            arreterChrono();

            int temps = secondes;
            List<Integer> meilleurs = DatabaseManager.getMeilleursTemps();
            boolean dansTop3 = meilleurs.size() < 3 || temps < meilleurs.get(meilleurs.size() - 1);

            if (dansTop3) {
                String nom = JOptionPane.showInputDialog(vue, "Bravo ! Entrez votre nom :");
                if (nom != null && !nom.isEmpty()) {
                    DatabaseManager.insererScore(nom, temps);
                }
            }

            JOptionPane.showMessageDialog(vue, "Félicitations ! Temps : " + temps + " secondes");
        } else if (essaisRestants == 0) {
            arreterChrono();
            JOptionPane.showMessageDialog(vue, "Dommage ! Vous avez perdu !");
        }
    }

    private void demarrerChrono() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondes++;
                SwingUtilities.invokeLater(() -> {
                    vue.getChronoLabel().setText("Temps : " + secondes + " sec");
                });
            }
        }, 1000, 1000);
    }

    private void arreterChrono() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
