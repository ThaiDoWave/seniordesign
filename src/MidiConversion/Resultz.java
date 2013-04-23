/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MidiConversion;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Thai
 */
public class Resultz extends JFrame {

    public void createResultsFrame() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container content = getContentPane();
        setTitle("Lesson Results");
        JLabel textLabel = new JLabel(Global.inputLine);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(textLabel);
        Font bBold = new Font("segoe script", Font.ITALIC, 30);

        setSize(500, 300);
        textLabel.setFont(bBold);
        setLocationRelativeTo(null);
        show();

    }

    public void createFingerChart() throws IOException {
       
        String path = "finchart2.jpg";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        JFrame f = new JFrame();
        f.setTitle("Fingering Chart");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
