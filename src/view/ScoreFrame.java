package view;

import model.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreFrame extends JFrame {

    public ScoreFrame() {
        setTitle("Top 3 des meilleurs temps");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Integer> scores = DatabaseManager.getMeilleursTemps();
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JLabel("Top 3 Temps :", SwingConstants.CENTER));

        for (int i = 0; i < scores.size(); i++) {
            panel.add(new JLabel((i+1) + ". " + scores.get(i) + " sec", SwingConstants.CENTER));
        }

        add(panel);
    }
}
