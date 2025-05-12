package view;

import controller.JeuController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JeuFrame jeu = new JeuFrame();
            new JeuController(jeu); // Connexion du contrôleur
            jeu.setVisible(true);
        });
    }
}
