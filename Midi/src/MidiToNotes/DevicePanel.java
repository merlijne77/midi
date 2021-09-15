package MidiToNotes;

import java.awt.AWTEvent;
import java.awt.FlowLayout;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DevicePanel extends JFrame implements ActionListener{
	
	Info[] infos;
	JComboBox deviceChoiceBox;
	JButton connectBtn;
	static int deviceIndex = 0;
	
	DevicePanel(MidiDevice.Info infos[]){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
	
		
		deviceChoiceBox = new JComboBox(infos);
		deviceChoiceBox.setSize(200,200);
		deviceChoiceBox.addActionListener(this);
		this.add(deviceChoiceBox);
		
		connectBtn = new JButton();
		connectBtn.setSize(200, 200);
		connectBtn.setText("ConnectS");
		connectBtn.addActionListener(this);
		this.add(connectBtn);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == connectBtn) {
			deviceIndex = deviceChoiceBox.getSelectedIndex();
			MidiConnection connect = new MidiConnection();
			connect.connect();
			
			}
	} 
		//LET OP WORDT DEZE AANGEROEPEN VOOR actionPerformed?
		public static int getSelectedDeviceIndex() {
			
			return deviceIndex;
		}
}
