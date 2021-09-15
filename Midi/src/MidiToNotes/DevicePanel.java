package MidiToNotes;

import java.awt.AWTEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Panel;

public class DevicePanel extends JFrame implements ActionListener{
	
	Info[] infos;
	JComboBox deviceChoiceBox;
	JButton connectBtn;
	static int deviceIndex = 0;
	JLabel titelFrame;
	private JLabel lblLiveMidiPlay;
	private Panel panel;
	
	DevicePanel(MidiDevice.Info infos[]){
		this.setTitle("Play midi piano to notes on screen!");
		
		getContentPane().setBackground(Color.CYAN);
		setMinimumSize(new Dimension(400, 400));
		setAlwaysOnTop(true);
		setBounds(new Rectangle(300, 300, 300, 300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{324, 46, 178, 0};
		gridBagLayout.rowHeights = new int[]{46, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblLiveMidiPlay = new JLabel("Connect a midi device to play notes on..");
		lblLiveMidiPlay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		GridBagConstraints gbc_lblLiveMidiPlay = new GridBagConstraints();
		gbc_lblLiveMidiPlay.insets = new Insets(0, 0, 5, 5);
		gbc_lblLiveMidiPlay.gridx = 0;
		gbc_lblLiveMidiPlay.gridy = 0;
		getContentPane().add(lblLiveMidiPlay, gbc_lblLiveMidiPlay);
		
		titelFrame = new JLabel();
		titelFrame.setAlignmentX(Component.RIGHT_ALIGNMENT);
		titelFrame.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		titelFrame.setText("Choose youre device: ");
		GridBagConstraints gbc_titelFrame = new GridBagConstraints();
		gbc_titelFrame.anchor = GridBagConstraints.WEST;
		gbc_titelFrame.insets = new Insets(0, 0, 5, 5);
		gbc_titelFrame.gridx = 0;
		gbc_titelFrame.gridy = 3;
		getContentPane().add(titelFrame, gbc_titelFrame);
		
		deviceChoiceBox = new JComboBox(infos);
		deviceChoiceBox.addActionListener(this);
		deviceChoiceBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		GridBagConstraints gbc_deviceChoiceBox = new GridBagConstraints();
		gbc_deviceChoiceBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_deviceChoiceBox.insets = new Insets(0, 0, 5, 5);
		gbc_deviceChoiceBox.gridx = 1;
		gbc_deviceChoiceBox.gridy = 3;
		getContentPane().add(deviceChoiceBox, gbc_deviceChoiceBox);
		
		connectBtn = new JButton();
		connectBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		connectBtn.setText("ConnectS");
		connectBtn.addActionListener(this);
		GridBagConstraints gbc_connectBtn = new GridBagConstraints();
		gbc_connectBtn.insets = new Insets(0, 0, 5, 0);
		gbc_connectBtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_connectBtn.gridx = 2;
		gbc_connectBtn.gridy = 3;
		getContentPane().add(connectBtn, gbc_connectBtn);
		
		panel = new Panel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
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


