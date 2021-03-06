/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.MuZikGui2;

import PlayMidi.PlayMidi;
import MidiConversion.SerialTest;
import ComboBox.ComboBox;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import MidiConversion.Global;
import MidiConversion.Resultz;

/**
 *
 * @author Thai
 */
public class MuZikUI extends javax.swing.JFrame {

    /**
     * Creates new form MuZikUI
     */
    public MuZikUI() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bRP = new javax.swing.JButton();
        bSL = new javax.swing.JButton();
        FingeringChart = new javax.swing.JButton();
        About = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Options = new javax.swing.JMenu();
        RP = new javax.swing.JMenuItem();
        SL = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MuZik Learning Application");
        getContentPane().setLayout(null);

        bRP.setFont(new java.awt.Font("Mangal", 0, 20)); // NOI18N
        bRP.setText("Record / Playback");
        bRP.setToolTipText("<html>Allows the user to record their playing, giving the options <br>\nto save their recording as a WAV file and/or play the recording.");
        bRP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRPActionPerformed(evt);
            }
        });
        getContentPane().add(bRP);
        bRP.setBounds(390, 80, 240, 70);

        bSL.setFont(new java.awt.Font("Mangal", 0, 20)); // NOI18N
        bSL.setText("Song Lessons");
        bSL.setToolTipText("<html>Allows the user to choose a song to learn through<br> LED step-by-step guidance on the eRecorder flute.");
        bSL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSLActionPerformed(evt);
            }
        });
        getContentPane().add(bSL);
        bSL.setBounds(390, 170, 240, 70);

        FingeringChart.setFont(new java.awt.Font("Mangal", 1, 11)); // NOI18N
        FingeringChart.setLabel("Fingering Chart");
        FingeringChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FingeringChartActionPerformed(evt);
            }
        });
        getContentPane().add(FingeringChart);
        FingeringChart.setBounds(390, 260, 240, 40);

        About.setFont(new java.awt.Font("Mangal", 1, 11)); // NOI18N
        About.setLabel("About");
        getContentPane().add(About);
        About.setBounds(390, 310, 240, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/MuZikGui2/treble.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -140, 800, 680);

        File.setText("File");

        New.setText("New Project. . .");
        File.add(New);

        Open.setText("Open Project. . .");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        jMenuBar1.add(File);

        Edit.setText("Edit");
        jMenuBar1.add(Edit);

        Options.setText("Options");

        RP.setText("Record / Playback");
        RP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPActionPerformed(evt);
            }
        });
        Options.add(RP);

        SL.setText("Song Lessons");
        SL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLActionPerformed(evt);
            }
        });
        Options.add(SL);

        jMenuBar1.add(Options);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(714, 458));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This allows the button to be pressed, and the recording option pops up.
     * MUST MAKE NEW PACKAGE TO USE METHODS FROM OTHER CLASSES...
     */
    private void bRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRPActionPerformed
        JFrame RecordPlayback = new PlayMidi();
        RecordPlayback.setLocationRelativeTo(null);
        // RecordPlayback.pack();
        RecordPlayback.show();
        // RecordPlayback.setLocation(35,225);
        RecordPlayback.setSize(300, 300);
        RecordPlayback.setLocationRelativeTo(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_bRPActionPerformed

    private void bSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSLActionPerformed
        ComboBox SongLesson = new ComboBox();
        ComboBox SongFrame = new ComboBox();
        SongLesson.setFrame(SongFrame, 250, 150);

    }//GEN-LAST:event_bSLActionPerformed

    private void RPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPActionPerformed
        JFrame RecordPlayback = new PlayMidi();
        RecordPlayback.setLocationRelativeTo(null);
        // RecordPlayback.pack();
        RecordPlayback.show();
        // RecordPlayback.setLocation(35,225);
        RecordPlayback.setSize(300, 300);
        RecordPlayback.setLocationRelativeTo(null);
    }//GEN-LAST:event_RPActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpenActionPerformed

    private void SLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLActionPerformed
        ComboBox SongLesson = new ComboBox();
        ComboBox SongFrame = new ComboBox();
        SongLesson.setFrame(SongFrame, 250, 150);
    }//GEN-LAST:event_SLActionPerformed

    private void FingeringChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FingeringChartActionPerformed
        Resultz pokemon = new Resultz();
        try{
        pokemon.createFingerChart();
        }
        catch(Exception e){};
    }//GEN-LAST:event_FingeringChartActionPerformed

    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {

        SerialTest main = new SerialTest();
        main.initialize();
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException ie) {
                }
            }
        };
        t.start();
        System.out.println("Started");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MuZikUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuZikUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuZikUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuZikUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MuZikUI GUI = new MuZikUI();
                GUI.setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton About;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JButton FingeringChart;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenu Options;
    private javax.swing.JMenuItem RP;
    private javax.swing.JMenuItem SL;
    private javax.swing.JButton bRP;
    private javax.swing.JButton bSL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
