package PlayMidi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class PlayMidi extends JFrame {

  protected boolean running;
  ByteArrayOutputStream out;
  Runnable currentRunner; 

  public PlayMidi() {
    super("Record / Playback");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    Container content = getContentPane();
    
    Font bBold = new Font("Times New Roman", Font.BOLD, 50);

    final JButton capture = new JButton("Record");
    final JButton stop = new JButton("Stop");
    final JButton play = new JButton("Play");
    final JButton save = new JButton("Save"); 

    capture.setFont(bBold);
    stop.setFont(bBold);
    play.setFont(bBold);
    save.setFont(bBold);
    
    capture.setEnabled(true);
    stop.setEnabled(false);
    play.setEnabled(false);
    save.setEnabled(false);

    ActionListener captureListener = 
        new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        capture.setEnabled(false);
        stop.setEnabled(true);
        play.setEnabled(false);
        save.setEnabled(false);
        captureAudio();
      }
    };
    capture.addActionListener(captureListener);
    content.add(capture, BorderLayout.NORTH);

    ActionListener stopListener = 
        new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        capture.setEnabled(true);
        stop.setEnabled(false);
        play.setEnabled(true);
        save.setEnabled(true);
        running = false;
      }
    };
    stop.addActionListener(stopListener);
    content.add(stop, BorderLayout.SOUTH);

    ActionListener playListener = 
        new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        playAudio();
      }
    };
    play.addActionListener(playListener);
    content.add(play, BorderLayout.EAST);
    
     ActionListener saveListener = 
        new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        capture.setEnabled(true);
        stop.setEnabled(false);
        play.setEnabled(true);
        save.setEnabled(false);
          try {
              saveAudio();
          } catch (FileNotFoundException ex) {
              Logger.getLogger(PlayMidi.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(PlayMidi.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    };
    save.addActionListener(saveListener);
    content.add(save, BorderLayout.WEST);
  }

  private void captureAudio() {
    try {
      final AudioFormat format = getFormat();
      DataLine.Info info = new DataLine.Info(
        TargetDataLine.class, format);
      final TargetDataLine line = (TargetDataLine)
        AudioSystem.getLine(info);
      line.open(format);
      line.start();
      Runnable runner = new Runnable() {
        int bufferSize = (int)format.getSampleRate() 
          * format.getFrameSize();
        byte buffer[] = new byte[bufferSize];
 
        public void run() {
          out = new ByteArrayOutputStream();
          running = true;
          try {
            while (running) {
              int count = 
                line.read(buffer, 0, buffer.length);
              if (count > 0) {
                out.write(buffer, 0, count);
              }
            }
            out.close();
          } catch (IOException e) {
            System.err.println("I/O problems: " + e);
            System.exit(-1);
          }
        }
      };
      Thread captureThread = new Thread(runner);
      captureThread.start();
    } catch (LineUnavailableException e) {
      System.err.println("Line unavailable: " + e);
      System.exit(-2);
    }
  }

  private void playAudio() {
    try {
      byte audio[] = out.toByteArray();
      InputStream input = 
        new ByteArrayInputStream(audio);
      final AudioFormat format = getFormat();
      final AudioInputStream ais = 
        new AudioInputStream(input, format, 
        audio.length / format.getFrameSize());
      DataLine.Info info = new DataLine.Info(
        SourceDataLine.class, format);
      final SourceDataLine line = (SourceDataLine)
        AudioSystem.getLine(info);
      line.open(format);
      line.start();

      Runnable runner = new Runnable() {
        int bufferSize = (int) format.getSampleRate() 
          * format.getFrameSize();
        byte buffer[] = new byte[bufferSize];
 
        public void run() {
          try {
            int count;
            while ((count = ais.read(
                buffer, 0, buffer.length)) != -1) {
              if (count > 0) {
                line.write(buffer, 0, count);
              }
            }
            line.drain();
            line.close();
          } catch (IOException e) {
            System.err.println("I/O problems: " + e);
            System.exit(-3);
          }
        }
      };
      currentRunner=runner; 
      Thread playThread = new Thread(runner);
      playThread.start();
    } 
    catch (LineUnavailableException e) {
      System.err.println("Line unavailable: " + e);
      System.exit(-4);
    } 
  }

   private void saveAudio() throws FileNotFoundException, IOException {
       
   byte audio[] = out.toByteArray();
      InputStream b_in = 
        new ByteArrayInputStream(audio);
      
       AudioFormat format = getFormat();
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(
                "src/my/MuZikGui2/file.wav"));
        dos.write(audio);
        //AudioFormat format = new AudioFormat(8000f, 16, 1, true, false);
        AudioInputStream stream = new AudioInputStream(b_in, format,
                audio.length);
        File file = new File("src/my/MuZikGui2/file.wav");
        AudioSystem.write(stream, AudioFileFormat.Type.WAVE, file);
      
     
      
   
   }
  
  private AudioFormat getFormat() {
    float sampleRate = 8000;
    int sampleSizeInBits = 8;
    int channels = 1;
    boolean signed = true;
    boolean bigEndian = true;
    return new AudioFormat(sampleRate, 
      sampleSizeInBits, channels, signed, bigEndian);
  }
public static void closing(){
System.exit(0);
}
  
  public static void main(String args[]) {
    JFrame frame = new PlayMidi();
    frame.pack();
    frame.show();
  }
}