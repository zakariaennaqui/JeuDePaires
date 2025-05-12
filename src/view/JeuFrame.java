/*package view;

import model.Carte;
import model.Plateau;

import javax.swing.*;
import java.awt.*;

public class JeuFrame extends JFrame {
    private Plateau plateau;
    private JButton[][] boutons;
    private JLabel essaisLabel;
    private JLabel chronoLabel;
    private JButton btnScores; // Ajouté

    public JeuFrame() {
        plateau = new Plateau();
        boutons = new JButton[plateau.getLignes()][plateau.getColonnes()];

        setTitle("Jeu de Paires");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Haut : infos + bouton Scores
        JPanel infoPanel = new JPanel(new GridLayout(1, 3)); // passage à 3 colonnes
        essaisLabel = new JLabel("Essais restants : 3");
        chronoLabel = new JLabel("Temps : 0 sec");
        btnScores = new JButton("Scores");

        // Action bouton Scores
        btnScores.addActionListener(e -> {
            ScoreFrame scores = new ScoreFrame();
            scores.setVisible(true);
        });

        infoPanel.add(essaisLabel);
        infoPanel.add(chronoLabel);
        infoPanel.add(btnScores); // Ajouté

        // Centre : grille 4x4
        JPanel grillePanel = new JPanel(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                JButton bouton = new JButton();
                bouton.setPreferredSize(new Dimension(80, 80));
                bouton.setFont(new Font("Arial", Font.BOLD, 16));
                bouton.setBackground(Color.LIGHT_GRAY);
                grillePanel.add(bouton);
                boutons[i][j] = bouton;
            }
        }

        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(grillePanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    // Méthodes d'accès
    public JButton[][] getBoutons() {
        return boutons;
    }

    public JLabel getEssaisLabel() {
        return essaisLabel;
    }

    public JLabel getChronoLabel() {
        return chronoLabel;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}*/


package view;

import model.Plateau;

import javax.swing.*;
import java.awt.*;

public class JeuFrame extends JFrame {
    private Plateau plateau;
    private JLabel[][] labels;
    private JLabel essaisLabel;
    private JLabel chronoLabel;
    private JButton btnScores;

    public JeuFrame() {
        plateau = new Plateau();
        labels = new JLabel[plateau.getLignes()][plateau.getColonnes()];

        setTitle("Jeu de Paires");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel infoPanel = new JPanel(new GridLayout(1, 3));
        essaisLabel = new JLabel("Essais restants : 3");
        chronoLabel = new JLabel("Temps : 0 sec");
        btnScores = new JButton("Scores");

        btnScores.addActionListener(e -> {
            ScoreFrame scores = new ScoreFrame();
            scores.setVisible(true);
        });

        infoPanel.add(essaisLabel);
        infoPanel.add(chronoLabel);
        infoPanel.add(btnScores);

        JPanel grillePanel = new JPanel(new GridLayout(4, 4, 5, 5));
        //JPanel grillePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(80, 80));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(Color.LIGHT_GRAY);
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                grillePanel.add(label);
                labels[i][j] = label;
            }
        }

        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(grillePanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    public JLabel[][] getLabels() {
        return labels;
    }

    public JLabel getEssaisLabel() {
        return essaisLabel;
    }

    public JLabel getChronoLabel() {
        return chronoLabel;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}


