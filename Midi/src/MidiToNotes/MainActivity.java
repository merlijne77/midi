package MidiToNotes;

public class MainActivity {

	public static void main(String[] args) {
		MidiConnection connection = new MidiConnection();
		DevicePanel panel = new DevicePanel(connection.getConnectedDevices());
		
		
		

	}

}
