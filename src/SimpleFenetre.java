import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class SimpleFenetre extends JFrame {

    private JButton bouton;
    private JButton bouton2;
    private StringBuilder eggSequence = new StringBuilder();

    private JLabel eggLabel;

    public SimpleFenetre() {
        super("Calculatrice");
        build();
    }

    private void build() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel des boutons
        JPanel buttonsPanel = new JPanel(new FlowLayout());

        bouton = new JButton("Cliquez ici !");
        bouton.addActionListener(e -> handleClick("G", "Vous avez cliqué ici."));
        buttonsPanel.add(bouton);

        bouton2 = new JButton("Ou là !");
        bouton2.addActionListener(e -> handleClick("D", "Vous avez cliqué là."));
        buttonsPanel.add(bouton2);

        panel.add(buttonsPanel, BorderLayout.CENTER);

        // Label pour l’Easter Egg
        eggLabel = new JLabel("", SwingConstants.CENTER);
        eggLabel.setForeground(Color.RED);
        eggLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(eggLabel, BorderLayout.SOUTH);

        return panel;
    }

    private void handleClick(String code, String message) {
        eggSequence.append(code);
        System.out.println(message);
        System.out.println("Sequence actuelle : " + eggSequence);

        if (eggSequence.toString().endsWith("GDDG")) {
            showEgg();
        }
    }

    private void showEgg() {
        eggLabel.setText("^^ Félicitations, vous avez trouvé l'easter egg ! ^^");

        // Changer l’icône si disponible
        URL iconURL = getClass().getResource("/img/2.png");
        if (iconURL != null) {
            ImageIcon eggIcon = new ImageIcon(iconURL);
            setIconImage(eggIcon.getImage());
        }

        // Mise à jour visuelle
        revalidate();
        repaint();
    }
}
