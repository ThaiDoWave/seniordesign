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
        bPPE = new javax.swing.JButton();
        bSL = new javax.swing.JButton();
        bSS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Options = new javax.swing.JMenu();
        RP = new javax.swing.JMenuItem();
        PPE = new javax.swing.JMenuItem();
        SL = new javax.swing.JMenuItem();
        SS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MuZik Learning Application");
        getContentPane().setLayout(null);

        bRP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bRP.setText("Record / Playback");
        bRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRPActionPerformed(evt);
            }
        });
        getContentPane().add(bRP);
        bRP.setBounds(250, 30, 200, 40);

        bPPE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bPPE.setText("Post-Play Evaluation");
        bPPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPPEActionPerformed(evt);
            }
        });
        getContentPane().add(bPPE);
        bPPE.setBounds(490, 30, 200, 40);

        bSL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bSL.setText("Song Lessons");
        bSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSLActionPerformed(evt);
            }
        });
        getContentPane().add(bSL);
        bSL.setBounds(250, 90, 200, 40);

        bSS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bSS.setText("Song Sharing");
        bSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSSActionPerformed(evt);
            }
        });
        getContentPane().add(bSS);
        bSS.setBounds(490, 90, 200, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/MuZikGui2/MuzikInterfaceUpdated.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -40, 800, 680);

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

        PPE.setText("Post-Play Evaluation");
        Options.add(PPE);

        SL.setText("Song Lessons");
        SL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLActionPerformed(evt);
            }
        });
        Options.add(SL);

        SS.setText("Song Sharing");
        SS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSActionPerformed(evt);
            }
        });
        Options.add(SS);

        jMenuBar1.add(Options);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(816, 638));
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

    private void bPPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPPEActionPerformed
    }//GEN-LAST:event_bPPEActionPerformed

    private void bSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSLActionPerformed
        ComboBox SongLesson = new ComboBox();
        ComboBox SongFrame = new ComboBox();
        SongLesson.setFrame(SongFrame, 250, 150);

    }//GEN-LAST:event_bSLActionPerformed

    private void bSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSSActionPerformed

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

    private void SSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SSActionPerformed

    private void SLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLActionPerformed
        ComboBox SongLesson = new ComboBox();
        ComboBox SongFrame = new ComboBox();
        SongLesson.setFrame(SongFrame, 250, 150);
    }//GEN-LAST:event_SLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        SerialTest main = new SerialTest();
		main.initialize();
		Thread t=new Thread() {
			public void run() {
				//the following line will keep this app alive for 1000 seconds,
				//waiting for events to occur and responding to them (printing incoming messages to console).
				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
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
                new MuZikUI().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenu Options;
    private javax.swing.JMenuItem PPE;
    private javax.swing.JMenuItem RP;
    private javax.swing.JMenuItem SL;
    private javax.swing.JMenuItem SS;
    private javax.swing.JButton bPPE;
    private javax.swing.JButton bRP;
    private javax.swing.JButton bSL;
    private javax.swing.JButton bSS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
