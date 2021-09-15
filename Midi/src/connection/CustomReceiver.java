package connection;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

public class CustomReceiver implements Receiver {
	public String name;
	public MidiDevice device;
	
	public CustomReceiver(String name, MidiDevice device) {
	    this.name = name;
	    this.device = device;
	}
	public void send(MidiMessage msg, long timeStamp) {
	    System.out.println(msg);

	    }
	
	
	public void close() {
		device.close();
		System.out.print("Device is open:" + device.isOpen());
	}
	}



