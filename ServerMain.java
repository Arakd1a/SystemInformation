import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.SystemColor;

public class ServerMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerMain frame = new ServerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ServerMain.class.getResource("/images/bslogo-systemtray-16px.png")));
		setTitle("Broadcast Server");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList textNewBroadcastTitle = new JList();
		textNewBroadcastTitle.setBackground(Color.WHITE);
		textNewBroadcastTitle.setBounds(243, 36, 181, 197);
		contentPane.add(textNewBroadcastTitle);
		
		JButton btnEditBroadcast = new JButton("Edit");
		btnEditBroadcast.setBounds(243, 238, 89, 23);
		contentPane.add(btnEditBroadcast);
		
		JButton buttonDeleteBroadcast = new JButton("Delete");
		buttonDeleteBroadcast.setBounds(335, 238, 89, 23);
		contentPane.add(buttonDeleteBroadcast);
		
		JLabel lblActiveBroadcasts = new JLabel("Active Broadcasts");
		lblActiveBroadcasts.setBounds(243, 11, 181, 14);
		contentPane.add(lblActiveBroadcasts);
		
		JLabel lblNewLabel = new JLabel("Broadcast Title:");
		lblNewLabel.setBounds(10, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(109, 8, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		TextArea textNewBroadcast = new TextArea("", 3 , 100 , TextArea.SCROLLBARS_VERTICAL_ONLY);
		textNewBroadcast.setBounds(10, 37, 227, 196);
		contentPane.add(textNewBroadcast);
		
		JButton btnBroadcast = new JButton("Broadcast");
		btnBroadcast.setBounds(10, 238, 89, 23);
		contentPane.add(btnBroadcast);
	}
}
