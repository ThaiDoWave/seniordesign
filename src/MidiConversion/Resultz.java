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
        Font bBold = new Font("Times New Roman", Font.BOLD, 30);

        setSize(300, 300);
        textLabel.setFont(bBold);
        setLocationRelativeTo(null);
        show();

    }
}
