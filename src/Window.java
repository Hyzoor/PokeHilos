import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Window {

    private JFrame frame;

    private void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    private void downloadImg(String imgURL) {
        URL url;
        BufferedImage img;
        try {
            url = new URL(imgURL);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*File file = new File("D:\\image\\downloaded.jpg");
        ImageIO.write(img, "jpg", file);*/

        JLabel picLabel = new JLabel(new ImageIcon(img));
        frame.add(picLabel);
        System.err.println("DESCARGAO: " + imgURL);


        Dimension d = new Dimension();

        d.setSize(400, 400);

        frame.setSize(d);


        frame.repaint(400, 400, 400, 400);
    }


    public Window() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                downloadImg("http://www.avajava.com/images/avajavalogo.jpg");

                //
                // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png
            }
        });

    }
}
