import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;


public class SimpleFenetre extends JFrame implements ActionListener {

    private JButton bouton;
    private JButton bouton2;
    private String Egg = "";

    public SimpleFenetre() {
        super();
        build();
    }

    private void build() {
        setTitle("Calculatrice");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {

        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        bouton = new JButton("Cliquez ici !");
        bouton.addActionListener(this);
        buttonsPanel.add(bouton);

        bouton2 = new JButton("Ou là !");
        bouton2.addActionListener(this);
        buttonsPanel.add(bouton2);

        panel.add(buttonsPanel, BorderLayout.CENTER);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Clic");
        Object source = e.getSource();

        if(source == bouton){
            Egg += "G";
            System.out.println("Vous avez cliqué ici.");
        } else if (source == bouton2){
            Egg += "D";
            System.out.println("Vous avez cliqué là");
        }

        if (Egg.endsWith("GDDG")){
            AddEgg();
            System.out.println("^^ Félicitaion, vous avez trouvé l'easter egg ! ^^");
        } else {
            System.out.println(Egg);
        }

    }

    private void AddEgg() {
        JLabel eggbel = new JLabel("easter egg trouvé");
        eggbel.setForeground(Color.RED);
        eggbel.setFont(new Font("Comic sans ms", Font.BOLD, 16));

        // Ajout en bas avec BorderLayout (pour cela, il faut modifier le layout de la JFrame)
        // Ou simplement dans le panel principal :
        getContentPane().add(eggbel, BorderLayout.SOUTH);

        // Changer l’icône
        ImageIcon EggCon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/2.png")));
        setIconImage(EggCon.getImage());

        // Revalidation et repaint pour mettre à jour l’affichage
        this.revalidate();
        this.repaint();

    }



}