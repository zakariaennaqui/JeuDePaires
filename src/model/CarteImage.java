package model;

import javax.swing.*;
import java.awt.*;

public class CarteImage extends Carte {
    private ImageIcon icon;

    public CarteImage(int id, String cheminImage) {
        super(id);
        // Charger l'image et la redimensionner à 80x80
        ImageIcon original = new ImageIcon(getClass().getResource("/images/" + cheminImage));
        Image img = original.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        this.icon = new ImageIcon(img);
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }
}
