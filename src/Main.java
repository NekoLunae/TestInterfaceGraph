import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        SwingUtilities.invokeLater(() -> {
            SimpleFenetre fenetre = new SimpleFenetre();
            fenetre.setVisible(true);
        });
    }
}
