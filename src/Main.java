//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Entrée with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){//On crée une nouvelle instance de notre JDialog
                SimpleFenetre fenetre = new SimpleFenetre();
                fenetre.setVisible(true);//On la rend visible
            }
        });
    }
}

