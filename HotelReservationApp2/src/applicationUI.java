import java.awt.EventQueue;
import java.sql.ResultSet;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;



public class applicationUI {

	private JFrame frmHotelReservationApplication;
	private JPanel defaultPanel;
	private JPanel userCreatePanel;
	private JPanel bookingPanel;
	private JPanel reservationPanel;
	
	private JTextField textField;
	private JButton userCreateButton;
	private JButton reservationButton;
	private JButton exitButton;
	private JPanel loginPanel;
	private JTextField passwordTextField;
	private JTextField usernameTextField;
	private JTextField txtHotelEnrolmentEnrol;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneNumField;
	private JTextField addressField;
	private JTextField chkInTextField;
	private JTextField chkOutTextField;
	private JComboBox comboBox;
	private JButton homeButtonFrmS;
	private JButton homeButtonFrmL;

	private JButton resHomeButton;
	private JScrollPane scroller;
	public static JTextArea resTextArea;
	private JTextArea txtrWelcomeToHotel;
	private JTextField passField;
	private JLabel passLabel;

	
	
	private Integer userNum;
	private String name;
	private JEditorPane welcomeMessage;
	private JLabel resLabel;
	private JComboBox roomTypeBox;
	private JLabel roomsLabel;
	private JTextArea resultTextArea;
	private JScrollPane scrollPane_1;
	private JButton btnReserveRoom;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicationUI window = new applicationUI();
					window.frmHotelReservationApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public applicationUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotelReservationApplication = new JFrame();
		frmHotelReservationApplication.getContentPane().setBackground(Color.BLUE);
		frmHotelReservationApplication.setTitle("Hotel Reservation Application");
		frmHotelReservationApplication.setBounds(100, 100, 516, 550);
		frmHotelReservationApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotelReservationApplication.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		defaultPanel = new JPanel();
		defaultPanel.setBackground(Color.BLUE);
		defaultPanel.setLayout(null);
		frmHotelReservationApplication.getContentPane().add(defaultPanel, "name_474083583817");

		
		textField = new JTextField();
		textField.setBackground(Color.ORANGE);
		textField.setEditable(false);
		textField.setBounds(0, 270, 515, 77);
		defaultPanel.add(textField);
		textField.setColumns(10);
		
		
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.setVisible(false);
				bookingPanel.setVisible(true);
			}
		});
		searchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		searchButton.setBounds(0, 342, 264, 104);
		defaultPanel.add(searchButton);
		
		userCreateButton = new JButton("Login or Register");
		userCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(true);
				defaultPanel.setVisible(false);
			}
		});
		userCreateButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userCreateButton.setBounds(0, 442, 264, 86);
		defaultPanel.add(userCreateButton);
		
		reservationButton = new JButton("Reservation");
		reservationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.setVisible(false);
				reservationPanel.setVisible(true);
			}
		});
		reservationButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		reservationButton.setBounds(261, 342, 254, 134);
		defaultPanel.add(reservationButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		exitButton.setBounds(261, 472, 254, 56);
		defaultPanel.add(exitButton);
		
		txtrWelcomeToHotel = new JTextArea();
		txtrWelcomeToHotel.setWrapStyleWord(true);
		txtrWelcomeToHotel.setLineWrap(true);
		txtrWelcomeToHotel.setEditable(false);
		txtrWelcomeToHotel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		txtrWelcomeToHotel.setText("Welcome to Hotel Reservation!");
		txtrWelcomeToHotel.setForeground(Color.WHITE);
		txtrWelcomeToHotel.setBackground(Color.BLUE);
		txtrWelcomeToHotel.setBounds(21, 33, 355, 127);
		defaultPanel.add(txtrWelcomeToHotel);

		
		userCreatePanel = new JPanel();
		userCreatePanel.setBackground(Color.LIGHT_GRAY);
		frmHotelReservationApplication.getContentPane().add(userCreatePanel, "name_476261800449");
		userCreatePanel.setLayout(null);
		
		txtHotelEnrolmentEnrol = new JTextField();
		txtHotelEnrolmentEnrol.setText("Enrol to start enjoing the benefits of our Hotel.");
		txtHotelEnrolmentEnrol.setEditable(false);
		txtHotelEnrolmentEnrol.setBackground(Color.LIGHT_GRAY);
		txtHotelEnrolmentEnrol.setBounds(0, 89, 516, 129);
		userCreatePanel.add(txtHotelEnrolmentEnrol);
		txtHotelEnrolmentEnrol.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(0, 265, 61, 16);
		userCreatePanel.add(nameLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(0, 303, 61, 16);
		userCreatePanel.add(emailLabel);
		
		JLabel phoneNumLabel = new JLabel("Phone Number");
		phoneNumLabel.setBounds(0, 341, 135, 16);
		userCreatePanel.add(phoneNumLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(0, 379, 61, 16);
		userCreatePanel.add(addressLabel);
		
		nameField = new JTextField();
		nameField.setBounds(136, 260, 380, 26);
		userCreatePanel.add(nameField);
		nameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(136, 298, 380, 26);
		userCreatePanel.add(emailField);
		
		phoneNumField = new JTextField();
		phoneNumField.setColumns(10);
		phoneNumField.setBounds(136, 336, 380, 26);
		userCreatePanel.add(phoneNumField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(136, 374, 380, 26);
		userCreatePanel.add(addressField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String phoneNum = phoneNumField.getText();
				String email = emailField.getText();
				String address = addressField.getText();
				String password = passField.getText();
				
				try {
					appInteraction.createUser(name,email,phoneNum,address,password);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				defaultPanel.setVisible(true);
				userCreatePanel.setVisible(false);
			}
		});
		registerButton.setBounds(0, 452, 516, 29);
		userCreatePanel.add(registerButton);
		
		JLabel label = new JLabel("Log In");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label.setBounds(0, 6, 516, 50);
		userCreatePanel.add(label);
		
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userCreatePanel.setVisible(false);
				defaultPanel.setVisible(true);
			}
		});
		homeButton.setBounds(393, 493, 117, 29);
		userCreatePanel.add(homeButton);
		
		JButton regLogButton = new JButton("Log In");
		regLogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(true);
				userCreatePanel.setVisible(false);
			}
		});
		regLogButton.setBounds(0, 48, 265, 29);
		userCreatePanel.add(regLogButton);
		
		JButton regRegButton = new JButton("Register");
		regRegButton.setEnabled(false);
		regRegButton.setBounds(251, 48, 265, 29);
		userCreatePanel.add(regRegButton);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(136, 412, 380, 26);
		userCreatePanel.add(passField);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(0, 417, 61, 16);
		userCreatePanel.add(passLabel);
		
		bookingPanel = new JPanel();
		bookingPanel.setBackground(Color.LIGHT_GRAY);
		frmHotelReservationApplication.getContentPane().add(bookingPanel, "name_535067318579");
		bookingPanel.setLayout(null);
		
		JLabel chkInLabel = new JLabel("Check In (Year-Month-day)");
		chkInLabel.setBounds(6, 133, 201, 16);
		bookingPanel.add(chkInLabel);
		
		JLabel chkOutLabel = new JLabel("Check Out (year-Month-day)");
		chkOutLabel.setBounds(6, 161, 193, 16);
		bookingPanel.add(chkOutLabel);
		
		roomsLabel = new JLabel("Rooms");
		roomsLabel.setBounds(6, 189, 61, 16);
		bookingPanel.add(roomsLabel);
		
		chkInTextField = new JTextField();
		chkInTextField.setBounds(219, 128, 130, 26);
		bookingPanel.add(chkInTextField);
		chkInTextField.setColumns(10);
		
		chkOutTextField = new JTextField();
		chkOutTextField.setColumns(10);
		chkOutTextField.setBounds(219, 156, 130, 26);
		bookingPanel.add(chkOutTextField);
		
		JLabel reservationLabel = new JLabel("Check Availability");
		reservationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reservationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		reservationLabel.setBounds(0, 39, 516, 50);
		bookingPanel.add(reservationLabel);
		
		
		String[] roomAmount = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		comboBox = new JComboBox(roomAmount);
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(79, 185, 85, 27);
		bookingPanel.add(comboBox);
		
		homeButtonFrmS = new JButton("Home");
		homeButtonFrmS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookingPanel.setVisible(false);
				defaultPanel.setVisible(true);
			}
		});
		homeButtonFrmS.setBounds(393, 493, 117, 29);
		bookingPanel.add(homeButtonFrmS);
		
		JButton chkBotton = new JButton("Search");
		chkBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 0;
				double totalprice = 0;
				boolean avali = true;
				String inDay = chkInTextField.getText();
				String outDay = chkOutTextField.getText();
				int rooms = Integer.valueOf((String) comboBox.getSelectedItem());
				String roomType =  (String) roomTypeBox.getSelectedItem();
				try {
					avali = appInteraction.availRoomsChk(inDay,outDay, rooms, roomType);
					price = appInteraction.getRoomPrice(roomType);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				int numDays = appInteraction.numOfDays(inDay, outDay) - 1;
				price = price * rooms;
				totalprice = price * numDays;
				if (avali) {
					resultTextArea.setText("The is currently a room avaliable for the dates selected.\n"
							+ "Check In Date: "+inDay+"\nCheck Out Date: " +outDay+"\nRoom Type: "+roomType+"\nNumber of Rooms: "+rooms
									+ "\nThe price of all the rooms per days is :"+ price+"\nYour total stay of the price is: "+String.format("%,.2f", totalprice));
				} else {
					resultTextArea.setText("Unfortunalty there are not avaliable rooms for that "
							+ "date meeting the select requirments. Please try again with a "
							+ "different room perference.");
				}
			}
		});
		chkBotton.setBounds(393, 217, 117, 29);
		bookingPanel.add(chkBotton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(6, 258, 510, 235);
		bookingPanel.add(scrollPane_1);
		
		resultTextArea = new JTextArea();
		resultTextArea.setEditable(false);
		resultTextArea.setWrapStyleWord(true);
		scrollPane_1.setViewportView(resultTextArea);
		
		btnReserveRoom = new JButton("Reserve Room");
		btnReserveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean reserved;
				String inDay = chkInTextField.getText();
				String outDay = chkOutTextField.getText();
				int rooms = Integer.valueOf((String) comboBox.getSelectedItem());
				String roomType =  (String) roomTypeBox.getSelectedItem();
				reserved = appInteraction.reserveRoom(userNum,inDay,outDay, rooms, roomType);
				if (reserved) {
					resultTextArea.setText("The room has been reserved for the following dates selected.\n"
							+ "Check In Date: "+inDay+"\nCheck Out Date: " +outDay+"\nRoom Type: "+roomType+"\nNumber of Rooms: "+rooms);
				} else {
					resultTextArea.setText("Unfortunalty your room has not been reserved. Please try again.");
				}
				try {
					appInteraction.reservationList(userNum);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnReserveRoom.setEnabled(false);
		btnReserveRoom.setBounds(6, 217, 117, 29);
		bookingPanel.add(btnReserveRoom);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(202, 189, 101, 16);
		bookingPanel.add(lblRoomType);
		
		String[] roomType = {"king","double","suite"};
		roomTypeBox = new JComboBox(roomType);
		roomTypeBox.setSelectedIndex(0);
		roomTypeBox.setBounds(297, 185, 117, 27);
		bookingPanel.add(roomTypeBox);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.LIGHT_GRAY);
		frmHotelReservationApplication.getContentPane().add(loginPanel, "name_4158228634877");
		loginPanel.setLayout(null);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(0, 218, 516, 43);
		loginPanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(0, 138, 516, 43);
		loginPanel.add(usernameTextField);
		
		JLabel loginLabel = new JLabel("Log In");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		loginLabel.setBounds(0, 6, 516, 50);
		loginPanel.add(loginLabel);
		
		JButton loginButton = new JButton("Log In");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = usernameTextField.getText();
				String password = passwordTextField.getText();
				try {
					userNum = appInteraction.userID(email,password);
					name = appInteraction.userName(email,password);
					System.out.println(userNum +","+ name);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				textField.setText("Welcome Back, " + name);
				welcomeMessage.setText("Welcome, "+name+"\n Account Number: "+userNum);
				loginPanel.setVisible(false);
				defaultPanel.setVisible(true);
				btnReserveRoom.setEnabled(true);
				try {
					appInteraction.reservationList(userNum);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		loginButton.setBounds(0, 273, 516, 29);
		loginPanel.add(loginButton);
		
		JLabel usernameLabel = new JLabel("Email");
		usernameLabel.setBounds(6, 121, 122, 16);
		loginPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(6, 201, 122, 16);
		loginPanel.add(passwordLabel);
		
		homeButtonFrmL = new JButton("Home");
		homeButtonFrmL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				defaultPanel.setVisible(false);
			}
		});
		homeButtonFrmL.setBounds(393, 493, 117, 29);
		loginPanel.add(homeButtonFrmL);
		
		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				userCreatePanel.setVisible(true);
			}
		});
		button.setBounds(251, 50, 265, 29);
		loginPanel.add(button);
		
		JButton button_1 = new JButton("Log In");
		button_1.setEnabled(false);
		button_1.setBounds(0, 50, 265, 29);
		loginPanel.add(button_1);
		
		reservationPanel = new JPanel();
		reservationPanel.setBackground(Color.LIGHT_GRAY);
		frmHotelReservationApplication.getContentPane().add(reservationPanel, "name_2546889521538");
		reservationPanel.setLayout(null);
		
		welcomeMessage = new JEditorPane();
		welcomeMessage.setText("Your Reservations");
		welcomeMessage.setBackground(Color.LIGHT_GRAY);
		welcomeMessage.setEditable(false);
		welcomeMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		welcomeMessage.setBounds(21, 24, 418, 109);
		reservationPanel.add(welcomeMessage);
		
		resHomeButton = new JButton("Home");
		resHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservationPanel.setVisible(false);
				defaultPanel.setVisible(true);
			}
		});
		resHomeButton.setBounds(393, 493, 117, 29);
		reservationPanel.add(resHomeButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 215, 504, 271);
		reservationPanel.add(scrollPane);
		
		resTextArea = new JTextArea();
		scrollPane.setViewportView(resTextArea);
		resTextArea.setLineWrap(true);
		resTextArea.setWrapStyleWord(true);
		
		resLabel = new JLabel("Reservations");
		resLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		resLabel.setBounds(166, 181, 173, 22);
		reservationPanel.add(resLabel);

	}
}
