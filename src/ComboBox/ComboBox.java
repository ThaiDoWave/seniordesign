/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComboBox;

/**
 *
 * @author Thai
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.*;
import MidiConversion.MidiConversion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class ComboBox extends JFrame {

    private String[] playlist = {
        "Hot Cross Buns", "Old MacDonald"
    };
    private JTextField textfield1 = new JTextField("Select a Song:");
    private JComboBox comboBox = new JComboBox();
    private JButton Selection = new JButton("OK");
    private int count = 0;

    public ComboBox() {
        for (int i = 0; i < playlist.length; i++) {
            comboBox.addItem(playlist[count++]);
        }
        textfield1.setEditable(false);

        // After selecting song, it should create the conversion file in the 
        // folder and display messages in the console of successful conversion. 
        // Hitting 'OK' currently doesn't close the frame.
        Selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MidiConversion ConvertMidi = new MidiConversion();
                if (comboBox.getSelectedItem() == "Old MacDonald") {
                    System.out.println("You chose Old MacDonald");
                    try {
                        ConvertMidi.Convert("old_macdonald.mid");
                        System.out.println("Conversion Successful!");
                    } catch (Exception Exception) {
                    }
                }
                if (comboBox.getSelectedItem() == "Hot Cross Buns") {
                    System.out.println("You chose Hot Cross Buns");
                    try {
                        ConvertMidi.Convert("hotcrossbuns.mid");
                        System.out.println("Conversion Successful!");
                    } catch (Exception Exception) {
                    }
                }
            }
        });

        setLayout(new FlowLayout());
        add(textfield1);
        add(comboBox);
        add(Selection);
        textfield1.setHorizontalAlignment(JTextField.CENTER);
    }

    public static void main(String[] args) {
        setFrame(new ComboBox(), 250, 150);
    }

    public static void setFrame(final JFrame frame, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setTitle("Song Lesson");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setSize(width, height);
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
            }
        });
    }
}