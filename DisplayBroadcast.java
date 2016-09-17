import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class DisplayBroadcast extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField textDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayBroadcast frame = new DisplayBroadcast();
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
	public DisplayBroadcast() {
		setResizable(false);
		setTitle("Display Broadcast");
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DisplayBroadcast.class.getResource("/images/bslogo-systemtray-16px.png")));
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 290);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Broadcast Name:");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTitle.setBounds(10, 11, 95, 14);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("Arial", Font.PLAIN, 11));
		textTitle.setEditable(false);
		textTitle.setBounds(98, 8, 139, 20);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		TextArea textBroadcast = new TextArea("", 3 , 100 , TextArea.SCROLLBARS_VERTICAL_ONLY);
		textBroadcast.setFont(new Font("Arial", Font.PLAIN, 11));
		textBroadcast.setEditable(false);
		textBroadcast.setBounds(10, 34, 335, 207);
		contentPane.add(textBroadcast);
		
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDate.setBounds(247, 11, 25, 14);
		contentPane.add(lblDate);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Arial", Font.PLAIN, 11));
		textDate.setEditable(false);
		textDate.setColumns(10);
		textDate.setBounds(282, 8, 63, 20);
		contentPane.add(textDate);
	}
}
