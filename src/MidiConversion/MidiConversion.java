/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MidiConversion;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MidiConversion {

    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "Cs", "D", "Ds", "E", "F", "Fs", "G", "Gs", "A", "As", "B"};
    public static final String[][] song = new String[100][2];
    
    public static void main(String[] args) throws Exception {
    	
        // THIS IS WHERE YOU PUT THE SONG
    	Sequence sequence = MidiSystem.getSequence(new File("hotcrossbuns.mid"));
    	PrintWriter out = new PrintWriter(new FileWriter("out.h")); 

        long noteOn = 0;
        long noteOff = 0;
        String noteLength;
        int noteNumber = 0;
        
        // note: this code does not work for multi-track songs
        for (Track track :  sequence.getTracks()) {
        	 
        	 // this is the real track
             if(track.size() > 20){
            	 for (int i=0; i < track.size(); i++) { 
            		 MidiEvent event = track.get(i);
            		 MidiMessage message = event.getMessage();
            		 
            		 // parse the song 
            		 if (message instanceof ShortMessage) {
            			 ShortMessage sm = (ShortMessage) message;
            			 
            			 // calculates rests - if the value is 0, we effectively do not rest
            			 if (sm.getCommand() == NOTE_ON) {
            				 noteOn = event.getTick();
            				 song[noteNumber][0] = "REST";
            				 song[noteNumber][1] = String.valueOf(noteOn - noteOff);
            				 noteNumber++;
            			 } 
            			 
            			 // retrieves notes and their durations
            			 else if (sm.getCommand() == NOTE_OFF) {
            				 int key = sm.getData1();
            				 int octave = (key / 12)-2;
            				 Integer.toString(octave);
            				 int note = key % 12;
            				 String noteName = NOTE_NAMES[note];
            				 noteOff = event.getTick();
            				 noteLength = String.valueOf(noteOff - noteOn);
            				 song[noteNumber][0] = noteName + octave;
            				 song[noteNumber][1] = noteLength;
            				 noteNumber++;
            			 } 
            		 } 
            	 }
            	
            	 out.print("int song[" + (noteNumber + 1) + "][2] = {");
            	 for(int j = 0; j < noteNumber; j++){
            		 out.print("{" + song[j][0] + "," + song[j][1] + "},");
            	 }
            	 out.print("{END,0}};");
            	 out.close();
            }
        }

    }
}
