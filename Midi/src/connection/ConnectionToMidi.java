package connection;

import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.*;

public class ConnectionToMidi{


	private static MidiDevice device;
	public static CustomReceiver receiver;
	
	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
		
		//TODO: Handeling exceptions
		try {
		Info[] infos = MidiSystem.getMidiDeviceInfo();
	
		for(int i=0;i<infos.length;i++)
		{
		    System.out.println(infos[i].getName() + " - " + infos[i].getDescription());
		}
		device = MidiSystem.getMidiDevice(infos[infos.length-1]);//mijn apparaat, laatste in de lijst.
		receiver = new CustomReceiver("Heidi's receiver", device);
		device.open();
		System.out.println(device.isOpen());
		Transmitter transmitter = device.getTransmitter();
	    transmitter.setReceiver(receiver);	
			
	} catch(MidiUnavailableException e) {
		System.out.print(e + " Midi is unavailable. Due to a unknown problem..");
	}

}}
