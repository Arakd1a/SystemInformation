
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.File;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class SystemPropWindow extends JFrame {

	static File cDrive = new File("c:");
	static File dDrive = new File("d:");
	static String computerName = null;
	static String ipAddress = null;
	static String osName = null;
	static String osVersion = null;
	static String userName = null;
	static long discTotalC = 0;
	static long discFreeC = 0;
	static long discTotalD = 0;
	static long discFreeD = 0;
	static boolean isInternetReachable = false;
	static String connectionStatus = null;
	static SystemPropWindow Propframe = new SystemPropWindow();

	private JPanel contentPane;
	private JTextField textComputerName;
	private JTextField textIpAddress;
	private JTextField textLoggedOnuser;
	private JLabel lblOsName;
	private JTextField textOsName;
	private JLabel lblOsVersion;
	private JTextField textOSVersion;
	public static JTextField textConnectionStatus;
	public static JCheckBox chckbxPing;
	
	

	public static void OpenSystemPropWindow() {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				if (AccessControl.AllowNewSystemPropWindow == true) {
					SystemPropWindow frame = new SystemPropWindow();
					frame.setVisible(true);
					AccessControl.OffAllowNewSystemPropWindow();
				} else {
					System.out.println("already open jackass");
				}

			}
		});

	}

	public SystemPropWindow() {

		setFont(new Font("SansSerif", Font.PLAIN, 12));

		computerName = GetProp.computerName(computerName);
		ipAddress = GetProp.ipAddress(ipAddress);
		osName = GetProp.osName(osName);
		osVersion = GetProp.osVersion(osVersion);
		userName = GetProp.userName(userName);
		setTitle("System Info");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SystemPropWindow.class.getResource("/images/bslogo-systemtray-32px.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 290);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblComputername = new JLabel("Computer Name:");
		lblComputername.setFont(new Font("Arial", Font.PLAIN, 11));
		lblComputername.setToolTipText("Computer Name:");
		lblComputername.setBounds(10, 11, 100, 14);
		contentPane.add(lblComputername);

		JLabel lblIpaddress = new JLabel("IP Address:");
		lblIpaddress.setFont(new Font("Arial", Font.PLAIN, 11));
		lblIpaddress.setToolTipText("");
		lblIpaddress.setBounds(10, 36, 100, 14);
		contentPane.add(lblIpaddress);

		JLabel lblLoggedOnUser = new JLabel("Logged On User:");
		lblLoggedOnUser.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLoggedOnUser.setToolTipText("Logged On User");
		lblLoggedOnUser.setBounds(10, 61, 100, 14);
		contentPane.add(lblLoggedOnUser);

		textComputerName = new JTextField();
		textComputerName.setFont(new Font("Arial", Font.PLAIN, 11));
		textComputerName.setForeground(new Color(51, 153, 255));
		textComputerName.setEditable(false);
		textComputerName.setHorizontalAlignment(SwingConstants.RIGHT);
		textComputerName.setBounds(112, 8, 122, 20);
		contentPane.add(textComputerName);
		textComputerName.setColumns(10);
		textComputerName.setText(computerName);

		textIpAddress = new JTextField();
		textIpAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		textIpAddress.setForeground(new Color(51, 153, 255));
		textIpAddress.setEditable(false);
		textIpAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		textIpAddress.setColumns(10);
		textIpAddress.setBounds(112, 33, 122, 20);
		contentPane.add(textIpAddress);
		textIpAddress.setText(ipAddress);

		textLoggedOnuser = new JTextField();
		textLoggedOnuser.setFont(new Font("Arial", Font.PLAIN, 11));
		textLoggedOnuser.setForeground(new Color(51, 153, 255));
		textLoggedOnuser.setEditable(false);
		textLoggedOnuser.setHorizontalAlignment(SwingConstants.RIGHT);
		textLoggedOnuser.setColumns(10);
		textLoggedOnuser.setBounds(112, 58, 122, 20);
		contentPane.add(textLoggedOnuser);
		textLoggedOnuser.setText(userName);

		lblOsName = new JLabel("OS Name:");
		lblOsName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblOsName.setToolTipText("OS Name:");
		lblOsName.setBounds(10, 86, 100, 14);
		contentPane.add(lblOsName);

		textOsName = new JTextField();
		textOsName.setFont(new Font("Arial", Font.PLAIN, 11));
		textOsName.setForeground(new Color(51, 153, 255));
		textOsName.setEditable(false);
		textOsName.setHorizontalAlignment(SwingConstants.RIGHT);
		textOsName.setColumns(10);
		textOsName.setBounds(112, 83, 122, 20);
		contentPane.add(textOsName);
		textOsName.setText(osName);

		lblOsVersion = new JLabel("OS Version:");
		lblOsVersion.setFont(new Font("Arial", Font.PLAIN, 11));
		lblOsVersion.setToolTipText("OS Version: ");
		lblOsVersion.setBounds(10, 111, 100, 14);
		contentPane.add(lblOsVersion);

		textOSVersion = new JTextField();
		textOSVersion.setFont(new Font("Arial", Font.PLAIN, 11));
		textOSVersion.setForeground(new Color(51, 153, 255));
		textOSVersion.setEditable(false);
		textOSVersion.setHorizontalAlignment(SwingConstants.RIGHT);
		textOSVersion.setColumns(10);
		textOSVersion.setBounds(112, 108, 122, 20);
		contentPane.add(textOSVersion);
		textOSVersion.setText(osVersion);

		textConnectionStatus = new JTextField();
		textConnectionStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		textConnectionStatus.setForeground(SystemColor.textHighlight);
		textConnectionStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		textConnectionStatus.setEditable(false);
		textConnectionStatus.setColumns(10);
		textConnectionStatus.setBounds(10, 222, 86, 20);
		contentPane.add(textConnectionStatus);
		textConnectionStatus.setForeground(Color.green);

		{
			textConnectionStatus.setText("Connected");

		}
		
		JCheckBox chckbxPing = new JCheckBox("Ping ");
	
	
		chckbxPing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
	
					
				   
				
			}	
				 
				  
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
		});
		chckbxPing.setBackground(Color.WHITE);
		chckbxPing.setSelected(true);
		chckbxPing.setBounds(179, 221, 49, 23);
		contentPane.add(chckbxPing);
		
		
		
		
	}
}
