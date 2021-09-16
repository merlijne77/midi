/**
 * the UI where user can choose a device and connect.
 * The played note will be shown on the panel.
 * @author heidi
 */


package MidiToNotes;

import java.awt.Font;
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
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class DevicePanel extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Info[] infos;
	private JComboBox<Object> deviceChoiceBox;
	private JButton connectBtn;
	private static int deviceIndex = 0;
	private JLabel tipChooseYoureDevice;
	private JLabel tipConnectDevice;
	static JTextPane notesTextview;
	
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
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		tipConnectDevice = new JLabel("Connect a midi piano/keyboard device.");
		tipConnectDevice.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		GridBagConstraints gbc_lblLiveMidiPlay = new GridBagConstraints();
		gbc_lblLiveMidiPlay.insets = new Insets(0, 0, 5, 5);
		gbc_lblLiveMidiPlay.gridx = 0;
		gbc_lblLiveMidiPlay.gridy = 0;
		getContentPane().add(tipConnectDevice, gbc_lblLiveMidiPlay);
		
		//Tip Choose youre device
		tipChooseYoureDevice = new JLabel();
		tipChooseYoureDevice.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tipChooseYoureDevice.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		tipChooseYoureDevice.setText("Choose youre device: ");
		GridBagConstraints gbc_titelFrame = new GridBagConstraints();
		gbc_titelFrame.anchor = GridBagConstraints.WEST;
		gbc_titelFrame.insets = new Insets(0, 0, 5, 5);
		gbc_titelFrame.gridx = 0;
		gbc_titelFrame.gridy = 3;
		getContentPane().add(tipChooseYoureDevice, gbc_titelFrame);
		
		//Box with a list of connected MidiDevecis.
		deviceChoiceBox = new JComboBox<Object>(infos);
		deviceChoiceBox.addActionListener(this);
		deviceChoiceBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		GridBagConstraints gbc_deviceChoiceBox = new GridBagConstraints();
		gbc_deviceChoiceBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_deviceChoiceBox.insets = new Insets(0, 0, 5, 5);
		gbc_deviceChoiceBox.gridx = 1;
		gbc_deviceChoiceBox.gridy = 3;
		getContentPane().add(deviceChoiceBox, gbc_deviceChoiceBox);
		
		//button to connect the chosen mididevice
		connectBtn = new JButton();
		connectBtn.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		connectBtn.setText("Connect");
		connectBtn.addActionListener(this);
		GridBagConstraints gbc_connectBtn = new GridBagConstraints();
		gbc_connectBtn.insets = new Insets(0, 0, 5, 0);
		gbc_connectBtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_connectBtn.gridx = 2;
		gbc_connectBtn.gridy = 3;
		getContentPane().add(connectBtn, gbc_connectBtn);
		
		//Showes the note played by the midi device
		notesTextview = new JTextPane();
		StyledDocument doc = notesTextview.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		notesTextview.setFont(new Font(Font.SERIF, Font.BOLD, 99));
		notesTextview.setText("c");
		notesTextview.setBackground(Color.CYAN);
		GridBagConstraints gbc_txtpnC = new GridBagConstraints();
		gbc_txtpnC.gridwidth = 3;
		gbc_txtpnC.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnC.gridx = 0;
		gbc_txtpnC.gridy = 5;
		getContentPane().add(notesTextview, gbc_txtpnC);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == connectBtn) {
			deviceIndex = deviceChoiceBox.getSelectedIndex();
			MidiConnection.connect();
			}
	} 
	
		public static int getSelectedDeviceIndex() {
			return deviceIndex;
		}
	}

