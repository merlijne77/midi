/**
 * Custom receiver to connect to the device transmitter.
 * In the overriden send method the raw midi data is
 * transfered to a key. The key is send to the Note object.
 * Note.toString returns the note that is played.
 * @author heidi
 */


package MidiToNotes;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

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
	
    /**
     * Get the midi message. Transfer into bite array.
     * Get the key value from the bite array and send it
     * to the Note object. Note object translates the key to the music note
     * that is played. Then the note is printed in the UI
     */
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
	             System.out.print(note.toString());//print the note in the console
	             DevicePanel.notesTextview.setText(note.toString());//print the note in the UI
 } 
}
	
	public void close() {
		device.close();
		System.out.print("Device is open:" + device.isOpen());
	}
}

