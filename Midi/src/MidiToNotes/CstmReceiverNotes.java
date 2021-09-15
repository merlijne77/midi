package MidiToNotes;
import javax.sound.midi.MidiDevice;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import com.sun.jdi.ShortType;
import com.sun.jdi.ShortValue;

public class CstmReceiverNotes implements Receiver {
	public String name;
	public MidiDevice device;
	public int key;
	public ShortMessage sm;
	public MidiMessage message;
	
	public CstmReceiverNotes(String name, MidiDevice device) {
	    this.name = name;
	    this.device = device;
	}
	public void send(MidiMessage msg, long timeStamp) {
		message = msg;
		byte[] aMsg = msg.getMessage();//get raw midi bite data
		sm = (ShortMessage) message;
	    int channel = sm.getChannel();
	        //if note pressed
	    	if (((ShortMessage) message).getCommand() == ShortMessage.NOTE_ON) {
	        	 key = aMsg[1];
	        	//the note class extracts the note pressed from the raw midi data
	             Note note = new Note(key);
	             System.out.print(note.toString());//print the note
 } 

	}
	
	public void close() {
		device.close();
		System.out.print("Device is open:" + device.isOpen());
	}
	}

