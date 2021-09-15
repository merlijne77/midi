package MidiToNotes;

import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.*;

public class MidiConnection{


	private static MidiDevice device;
	private static CstmReceiverNotes receiver;
	
	public static void main(String[] args){
	
		try {
		Info[] infos = MidiSystem.getMidiDeviceInfo();//get the available midi devices
	
		for(int i=0;i<infos.length;i++)
		{//print the available midi devices
		    System.out.println(infos[i].getName() + " - " + infos[i].getDescription());
		}
		device = MidiSystem.getMidiDevice(infos[infos.length-1]);//TODO: MAKE GUI CHOOSE DEVICE
		receiver = new CstmReceiverNotes("Heidi's receiver", device);
		device.open();
		System.out.println(device.isOpen());
		Transmitter transmitter = device.getTransmitter();
	    transmitter.setReceiver(receiver);	
			
	} catch(MidiUnavailableException e) {
		System.out.print(e + " Midi is unavailable. Due to a unknown problem..");
	}
	}
}
