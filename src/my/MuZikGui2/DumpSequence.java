/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.MuZikGui2;
 /**/
import java.io.*; 

import javax.sound.midi.MidiSystem;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.SysexMessage;
import javax.sound.midi.Receiver;




/**	<titleabbrev>DumpSequence</titleabbrev>
	<title>Displaying the content of a MIDI file</title>

	<formalpara><title>Purpose</title>
	<para>Dumps the decoded content of a MIDI file to the console.</para>
	</formalpara>

	<formalpara><title>Usage</title>
	<para>
	<cmdsynopsis><command>java DumpSequence</command>
	<arg choice="plain"><replaceable class="parameter">midifile</replaceable></arg>
	</cmdsynopsis>
	</para></formalpara>

	<formalpara><title>Parameters</title>
	<variablelist>
	<varlistentry>
	<term><replaceable class="parameter">midifile</replaceable></term>
	<listitem><para>the filename of the MIDI file that should be displayed</para></listitem>
	</varlistentry>
	</variablelist>
	</formalpara>

	<formalpara><title>Bugs, limitations</title>
	<para>Meta and system common events are not displayed in detail.</para>
	</formalpara>

	<formalpara><title>Source code</title>
	<para>
	<ulink url="DumpSequence.java.html">DumpSequence.java</ulink>,
	<ulink url="DumpReceiver.java.html">DumpReceiver.java</ulink>
	</para>
	</formalpara>

*/
public class DumpSequence 
{
	private static String[]	sm_astrKeyNames = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        private static FileOutputStream outStr; 
        private static Receiver sm_receiver ; 
        
        
        
	

               


	public static void main(String[] args) throws FileNotFoundException 
	{
		/*
		 *	We check that there is exactely one command-line
		 *	argument. If not, we display the usage message and
		 *	exit.
		 
		if (args.length != 1)
		{
			out("DumpSequence: usage:");
			out("\tjava DumpSequence <midifile>");
			System.exit(1);
		}
		/*
		 *	Now, that we're shure there is an argument, we take it as
		 *	the filename of the soundfile we want to play.
		 */
                
		String fileName = "whatever.txt";
final boolean append = true, autoflush = true;
PrintStream printStream = new PrintStream(new FileOutputStream(fileName, append),
                                    autoflush);

                  System.setOut(printStream);
                 String	strFilename = "src/my/MuZikGui2/eagles-hotelcalifornia.mid";
		File	midiFile = new File(strFilename);

		/*
		 *	We try to get a Sequence object, which the content
		 *	of the MIDI file.
		 */
		Sequence	sequence = null;
		try
		{
			sequence = MidiSystem.getSequence(midiFile);
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		/*
		 *	And now, we output the data.
		 */
		if (sequence == null)
		{
			out("Cannot retrieve Sequence.");
		}
		else
		{
			out("---------------------------------------------------------------------------");
			out("File: " + strFilename);
			out("---------------------------------------------------------------------------");
			out("Length: " + sequence.getTickLength() + " ticks");
			out("Duration: " + sequence.getMicrosecondLength() + " microseconds");
			out("---------------------------------------------------------------------------");
			float	fDivisionType = sequence.getDivisionType();
			String	strDivisionType = null;
			if (fDivisionType == Sequence.PPQ)
			{
				strDivisionType = "PPQ";
			}
			else if (fDivisionType == Sequence.SMPTE_24)
			{
				strDivisionType = "SMPTE, 24 frames per second";
			}
			else if (fDivisionType == Sequence.SMPTE_25)
			{
				strDivisionType = "SMPTE, 25 frames per second";
			}
			else if (fDivisionType == Sequence.SMPTE_30DROP)
			{
				strDivisionType = "SMPTE, 29.97 frames per second";
			}
			else if (fDivisionType == Sequence.SMPTE_30)
			{
				strDivisionType = "SMPTE, 30 frames per second";
			}

			out("DivisionType: " + strDivisionType);

			String	strResolutionType = null;
			if (sequence.getDivisionType() == Sequence.PPQ)
			{
				strResolutionType = " ticks per beat";
			}
			else
			{
				strResolutionType = " ticks per frame";
			}
			out("Resolution: " + sequence.getResolution() + strResolutionType);
			out("---------------------------------------------------------------------------");
			Track[]	tracks = sequence.getTracks();
			for (int nTrack = 0; nTrack < tracks.length; nTrack++)
			{
				out("Track " + nTrack + ":");
				out("-----------------------");
				Track	track = tracks[nTrack];
				for (int nEvent = 0; nEvent < track.size(); nEvent++)
				{
					MidiEvent	event = track.get(nEvent);
					output(event);
				}
				out("---------------------------------------------------------------------------");
			}
			// TODO: getPatchList()
		}
                       

	}


	public static void output(MidiEvent event)
	{
		OutputStream hello= new OutputStream(); 
                hello.myMethod(); 
                PrintStream printStream = new PrintStream(outStr,true); 
                                
                
                sm_receiver = new DumpReceiver(printStream, true); 
                MidiMessage	message = event.getMessage();
		long		lTicks = event.getTick();
		sm_receiver.send(message, lTicks);
	}



	private static void out(String strMessage)
	{
            
            System.out.println(strMessage);
	}
       
        private static class OutputStream {
    
             public void myMethod() {
              String file = "whatever.txt"; /* need to change to change file name*/ 
               try {
                   outStr= new FileOutputStream(file, true); 
               } catch(FileNotFoundException fnfe) { 
                  System.out.println(fnfe.getMessage());
               } 
            }
        }
}
        


