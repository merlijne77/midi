package MidiToNotes;

import javax.sound.midi.MidiDevice.Info;

import connection.CustomReceiver;

import javax.sound.midi.*;

public class MidiConnection{


	public static MidiDevice device;
	private static CstmReceiverNotes receiver;
	Info[] infos;
	DevicePanel myPanel;
	int indexSelectedDevice;
	Transmitter transmitter;
	
	//constructor whithout parameters
	public MidiConnection() {
	
	}
	//constructor with the indexnumberof Selected Device
	public MidiConnection(int indexSelectedDevice) {
		this.indexSelectedDevice = indexSelectedDevice;
	}
	public Info[] getConnectedDevices() {
		  return infos = MidiSystem.getMidiDeviceInfo();
		}

	public void connect() {
//	    try {
//		    getConnectedDevices();
//			for(int i=0;i<infos.length;i++)
//			{//print the available midi devices
//			    System.out.println(infos[i].getName() + " - " + infos[i].getDescription());
//			}
//	    	System.out.println(DevicePanel.getSelectedDeviceIndex());
//		 receiver = new CstmReceiverNotes("Heidi's receiver", MidiSystem.getMidiDevice(infos[indexSelectedDevice]));
//		 MidiSystem.getMidiDevice(infos[indexSelectedDevice]).open();
////		 System.out.println(device.isOpen());
//			 transmitter = MidiSystem.getMidiDevice(infos[indexSelectedDevice]).getTransmitter();
//			
//			
//			
//		    transmitter.setReceiver(receiver);	
//				
//		} catch(MidiUnavailableException e) {
//			System.out.print(e + " Connect a midi piano or synthesizer/keyboard");
//
//
//	    }
	    
		//TODO: Handeling exceptions
		try {
		
	    infos = getConnectedDevices();
		for(int i=0;i<infos.length;i++)
		{
		    System.out.println(infos[i].getName() + " - " + infos[i].getDescription());
		}
		device = MidiSystem.getMidiDevice(infos[DevicePanel.getSelectedDeviceIndex()]);//mijn apparaat, laatste in de lijst.
		receiver = new CstmReceiverNotes("Heidi's receiver", device);
		device.open();
		System.out.println(device.isOpen());
		Transmitter transmitter = device.getTransmitter();
	    transmitter.setReceiver(receiver);	
		} catch(MidiUnavailableException e) {
			System.out.print(e);
		}
}}