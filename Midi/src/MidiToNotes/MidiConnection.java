
/**
 * returns a list with connected devices.
 * Connects the selected device transmitter to the custom receiver
 * @author heidi
 *
 */

package MidiToNotes;

import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.*;


public class MidiConnection{

	private static MidiDevice device;
	private static CstmReceiverNotes receiver;
	private static Info[] infos;
	private DevicePanel panel;
	private static Transmitter transmitter;
	
	//constructor without parameters
	public MidiConnection() {
		getConnectedDevices();
		panel = new DevicePanel(infos);
		receiver = new CstmReceiverNotes("Heidi's receiver", device);
	}
	
	/**
	 * returns the connected MidiDevices in a info[]
	 */
	public static Info[] getConnectedDevices() {
		  return infos = MidiSystem.getMidiDeviceInfo();
		}

	/**
	 * connects the custom receiver to the transmitter of the device 
	 */
	public static void connect() {
		try {
		for(int i=0;i<infos.length;i++){
		    System.out.println(infos[i].getName() + " - " + infos[i].getDescription());
		}
		device = MidiSystem.getMidiDevice(infos[DevicePanel.getSelectedDeviceIndex()]);//mijn apparaat, laatste in de lijst.
		device.open();
		System.out.println(device.isOpen());
		transmitter = device.getTransmitter();
	    transmitter.setReceiver(receiver);	
		} catch(MidiUnavailableException e) {
			System.out.print(e);
		}
	}
}