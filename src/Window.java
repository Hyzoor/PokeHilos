import javax.swing.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;


public class Window extends JFrame{


    public Window() {
        createAndShowGUI();
    }

    public void addImage(BufferedImage img) {
        this.add(new JLabel(new ImageIcon(img)));
        redraw();
    }

    private void createAndShowGUI() {
        this.setTitle("PokeSprites");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(1280, 1024);
        redraw();
    }

    private void redraw() {
        this.repaint();
        this.revalidate();
    }

}
