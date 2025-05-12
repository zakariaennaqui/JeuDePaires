package model;

import javax.swing.*;

public abstract class Carte {
    private int id;
    private boolean visible;
    private boolean trouvee;

    public Carte(int id) {
        this.id = id;
        this.visible = false;
        this.trouvee = false;
    }

    public int getId() {
        return id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isTrouvee() {
        return trouvee;
    }

    public void setTrouvee(boolean trouvee) {
        this.trouvee = trouvee;
    }

    // Méthode abstraite à implémenter dans les sous-classes
    public abstract ImageIcon getIcon();

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", visible=" + visible +
                ", trouvee=" + trouvee +
                '}';
    }
}


/*package model;

import javax.swing.*;

public class Carte {
    private int id;
    private ImageIcon icon;
    private boolean visible;
    private boolean trouvee;

    public Carte(int id, String cheminImage) {
        this.id = id;
        this.icon = new ImageIcon(getClass().getResource("/images/" + cheminImage));
        this.visible = false;
        this.trouvee = false;
    }

    public int getId() {
        return id;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isTrouvee() {
        return trouvee;
    }

    public void setTrouvee(boolean trouvee) {
        this.trouvee = trouvee;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", visible=" + visible +
                ", trouvee=" + trouvee +
                '}';
    }
}
*/



