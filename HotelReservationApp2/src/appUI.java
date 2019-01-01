

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class appUI {

	private JFrame frame;
	private JPanel subHeadingPanel;
	private JPanel menuPanel;
	private JLabel lblHomeicon;
	private JLabel lblHome;
	private JPanel btnBookingPanel;
	private JLabel blbBRoomIcon;
	private JLabel lblMakeAReservation;
	private JPanel btnReservationPanel;
	private JLabel lblResIcon;
	private JLabel lblReservations;
	private JPanel btnAdminPanel;
	private JLabel lblAdminIcon;
	private JLabel lblAdmin;
	private JPanel btnHomePanel;
	private JPanel welcomePanel;
	private JPanel logInRegPanel;
	private JPanel bookingPanel;
	private JLabel lblCheckIn;
	private JLabel lblCheckOut;
	private JTextField txtCheckInDate;
	private JTextField txtCheckOutDate;
	private JLabel lblExit;
	private JTextArea txtResultArea;
	private JTextField txtFieldEmail;
	private JTextPane txtpnPleaseInputYour;
	private JPanel logInPanel;
	
	private Integer userNum;
	private String name;
	private JTextPane txtpnWelcome;
	private JPanel reservationPanel;
	private JScrollPane scrollPane_1;
	protected static JTextArea reservationTextArea;
	private JLabel lblReservationLogIn;
	private JPanel registerPanel;
	private JLabel lblName;
	private JLabel lblEmail_1;
	private JLabel lblAddress;
	private JLabel lblPhoneNumber;
	private JLabel lblPassword_1;
	private JTextField txtFieldName;
	private JTextField txtEmailEntry;
	private JTextField txtFieldAddress;
	private JTextField txtFieldPhoneNum;
	private JTextField txtFieldPass;
	private JLabel lblRegisterGreeting;
	private JButton btnRegister;
	private JButton btnReserve;
	
	public String[] roomAmount = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	public String[] roomType = {"king","double","suite"};
	private JLabel label;
	private JPanel adminPanel;
	private JLabel lblAdministrionPage;
	private JButton btnInstall;
	private JTextPane txtpnAdminmessage;
	private JPasswordField pwdUserpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appUI window = new appUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public appUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 888, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0, 0, 128));
		menuPanel.setBounds(0, 0, 252, 630);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);
		
		btnHomePanel = new JPanel();
		btnHomePanel.setBackground(new Color(102, 153, 204));
		btnHomePanel.setBounds(0, 134, 252, 47);
		menuPanel.add(btnHomePanel);
		btnHomePanel.setLayout(null);
		
		lblHomeicon = new JLabel("");
		lblHomeicon.setIcon(new ImageIcon(appUI.class.getResource("/resources/home.png")));
		lblHomeicon.setBounds(36, 12, 24, 24);
		btnHomePanel.add(lblHomeicon);
		
		lblHome = new JLabel("Home");
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(75, 6, 177, 35);
		lblHome.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				welcomePanel.setVisible(true);
				logInPanel.setVisible(false);
				bookingPanel.setVisible(false);
				registerPanel.setVisible(false);
				reservationPanel.setVisible(false);
				adminPanel.setVisible(false);
			}
			public void mousePressed(MouseEvent e) {
				lblHome.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblHome.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		btnHomePanel.add(lblHome);
		
		btnBookingPanel = new JPanel();
		btnBookingPanel.setLayout(null);
		btnBookingPanel.setBackground(new Color(51, 102, 153));
		btnBookingPanel.setBounds(0, 181, 252, 47);
		menuPanel.add(btnBookingPanel);
		
		blbBRoomIcon = new JLabel("");
		blbBRoomIcon.setIcon(new ImageIcon(appUI.class.getResource("/resources/room.png")));
		blbBRoomIcon.setBounds(36, 12, 24, 24);
		btnBookingPanel.add(blbBRoomIcon);
		
		lblMakeAReservation = new JLabel("Book a Room");
		lblMakeAReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblMakeAReservation.setForeground(Color.WHITE);
		lblMakeAReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMakeAReservation.setBounds(75, 6, 177, 35);
		lblMakeAReservation.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				welcomePanel.setVisible(false);
				logInPanel.setVisible(false);
				reservationPanel.setVisible(false);
				registerPanel.setVisible(false);
				bookingPanel.setVisible(true);
			}
			public void mousePressed(MouseEvent e) {
				lblMakeAReservation.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblMakeAReservation.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		btnBookingPanel.add(lblMakeAReservation);
		
		btnReservationPanel = new JPanel();
		btnReservationPanel.setLayout(null);
		btnReservationPanel.setBackground(new Color(51, 102, 153));
		btnReservationPanel.setBounds(0, 228, 252, 47);
		menuPanel.add(btnReservationPanel);
		
		lblResIcon = new JLabel("");
		lblResIcon.setIcon(new ImageIcon(appUI.class.getResource("/resources/order.png")));
		lblResIcon.setBounds(36, 12, 24, 24);
		btnReservationPanel.add(lblResIcon);
		
		lblReservations = new JLabel("Reservations");
		lblReservations.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservations.setForeground(Color.WHITE);
		lblReservations.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReservations.setBounds(75, 6, 177, 35);
		lblReservations.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				welcomePanel.setVisible(false);
				logInPanel.setVisible(false);
				reservationPanel.setVisible(true);
				bookingPanel.setVisible(false);
				adminPanel.setVisible(false);
			}
			public void mousePressed(MouseEvent e) {
				lblReservations.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblReservations.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});		
		btnReservationPanel.add(lblReservations);
		
		btnAdminPanel = new JPanel();
		btnAdminPanel.setLayout(null);
		btnAdminPanel.setBackground(new Color(51, 102, 153));
		btnAdminPanel.setBounds(0, 275, 252, 47);
		menuPanel.add(btnAdminPanel);
		
		lblAdminIcon = new JLabel("");
		lblAdminIcon.setIcon(new ImageIcon(appUI.class.getResource("/resources/admin.png")));
		lblAdminIcon.setBounds(36, 12, 24, 24);
		btnAdminPanel.add(lblAdminIcon);
		
		lblAdmin = new JLabel("Administration");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAdmin.setBounds(75, 6, 177, 35);
		lblAdmin.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				logInPanel.setVisible(false);
				welcomePanel.setVisible(false);
				bookingPanel.setVisible(false);
				reservationPanel.setVisible(false);
				registerPanel.setVisible(false);
				adminPanel.setVisible(true);
				
			}
			public void mousePressed(MouseEvent e) {
				lblAdmin.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblAdmin.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {	
			}
		});
		btnAdminPanel.add(lblAdmin);
		
		JPanel btnExitPanel = new JPanel();
		btnExitPanel.setLayout(null);
		btnExitPanel.setBackground(new Color(51, 102, 153));
		btnExitPanel.setBounds(0, 322, 252, 47);
		menuPanel.add(btnExitPanel);

		
		JLabel lblExitIcon = new JLabel("");
		lblExitIcon.setIcon(new ImageIcon(appUI.class.getResource("/resources/exit.png")));
		lblExitIcon.setBounds(36, 12, 24, 24);
		btnExitPanel.add(lblExitIcon);
		
		lblExit = new JLabel("Exit");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblExit.setBounds(75, 6, 177, 35);
		lblExit.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mousePressed(MouseEvent e) {
				lblExit.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		btnExitPanel.add(lblExit);

		
		subHeadingPanel = new JPanel();
		subHeadingPanel.setBackground(new Color(102, 102, 255));
		subHeadingPanel.setBounds(252, 95, 636, 132);
		frame.getContentPane().add(subHeadingPanel);
		subHeadingPanel.setLayout(null);
		
		txtpnWelcome = new JTextPane();
		txtpnWelcome.setFont(new Font("Apple Chancery", Font.PLAIN, 28));
		txtpnWelcome.setText("Welcome to Hotels");
		txtpnWelcome.setBackground(new Color(102, 102, 255));
		txtpnWelcome.setEditable(false);
		txtpnWelcome.setBounds(41, 37, 350, 89);
		subHeadingPanel.add(txtpnWelcome);
		
		JPanel headingPanel = new JPanel();
		headingPanel.setBackground(Color.LIGHT_GRAY);
		headingPanel.setBounds(252, 0, 636, 96);
		frame.getContentPane().add(headingPanel);
		headingPanel.setLayout(null);
		
		logInRegPanel = new JPanel();
		logInRegPanel.setBackground(Color.LIGHT_GRAY);
		logInRegPanel.setBounds(486, 0, 150, 30);
		headingPanel.add(logInRegPanel);
		logInRegPanel.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(83, 6, 61, 16);
		lblRegister.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				logInPanel.setVisible(false);
				welcomePanel.setVisible(false);
				bookingPanel.setVisible(false);
				reservationPanel.setVisible(false);
				registerPanel.setVisible(true);
				adminPanel.setVisible(false);
				
			}
			public void mousePressed(MouseEvent e) {
				lblRegister.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblRegister.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {	
			}
		});
		logInRegPanel.add(lblRegister);
		
		JLabel lblSlash = new JLabel("/");
		lblSlash.setBounds(74, 6, 7, 16);
		logInRegPanel.add(lblSlash);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setBounds(32, 6, 39, 16);
		lblLogIn.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				logInPanel.setVisible(true);
				welcomePanel.setVisible(false);
				bookingPanel.setVisible(false);
				reservationPanel.setVisible(false);
				registerPanel.setVisible(false);
				adminPanel.setVisible(false);
			}
			public void mousePressed(MouseEvent e) {
				lblLogIn.setForeground(Color.YELLOW);
			}
			public void mouseReleased(MouseEvent e) {
				lblLogIn.setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {	
			}
		});
		logInRegPanel.add(lblLogIn);
		
		registerPanel = new JPanel();
		registerPanel.setBounds(252, 227, 636, 404);
		registerPanel.setVisible(false);
		
		bookingPanel = new JPanel();
		bookingPanel.setBackground(Color.LIGHT_GRAY);
		bookingPanel.setBounds(252, 226, 636, 404);
		bookingPanel.setVisible(false);
		
		logInPanel = new JPanel();
		logInPanel.setBackground(Color.LIGHT_GRAY);
		logInPanel.setBounds(252, 227, 636, 404);
		logInPanel.setVisible(false);
		frame.getContentPane().add(logInPanel);
		logInPanel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEmail.setBounds(81, 123, 101, 16);
		logInPanel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(81, 165, 101, 16);
		logInPanel.add(lblPassword);
		
		txtFieldEmail = new JTextField();
		txtFieldEmail.setBounds(194, 121, 336, 26);
		logInPanel.add(txtFieldEmail);
		txtFieldEmail.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(513, 340, 117, 29);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservationTextArea.setText("");
				String email = txtFieldEmail.getText();
				String password = pwdUserpassword.getText();
				try {
					userNum = appInteraction.userID(email,password);
					name = appInteraction.userName(email,password);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				txtpnWelcome.setText("Welcome, "+name+"\n Account Number: "+userNum);
				logInPanel.setVisible(false);
				welcomePanel.setVisible(true);
				bookingPanel.setVisible(false);	
				lblReservationLogIn.setText("Your Reservations are Listed Below");
				try {
					appInteraction.reservationList(userNum);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		logInPanel.add(btnLogIn);
		
		txtpnPleaseInputYour = new JTextPane();
		txtpnPleaseInputYour.setBackground(Color.LIGHT_GRAY);
		txtpnPleaseInputYour.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		txtpnPleaseInputYour.setText("Please input your email and password.");
		txtpnPleaseInputYour.setBounds(48, 42, 501, 29);
		logInPanel.add(txtpnPleaseInputYour);
		
		pwdUserpassword = new JPasswordField();
		pwdUserpassword.setBounds(194, 163, 336, 26);
		logInPanel.add(pwdUserpassword);
		
		welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.LIGHT_GRAY);
		welcomePanel.setBounds(252, 227, 636, 404);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(appUI.class.getResource("/resources/hotel.png")));
		label.setBounds(524, 279, 106, 119);
		welcomePanel.add(label);
		frame.getContentPane().add(bookingPanel);
		bookingPanel.setLayout(null);
		
		lblCheckIn = new JLabel("Check In");
		lblCheckIn.setBounds(27, 36, 85, 16);
		bookingPanel.add(lblCheckIn);
		
		lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setBounds(27, 76, 85, 16);
		bookingPanel.add(lblCheckOut);
		
		txtCheckInDate = new JTextField();
		txtCheckInDate.setBounds(124, 31, 130, 26);
		bookingPanel.add(txtCheckInDate);
		txtCheckInDate.setColumns(10);
		
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setBounds(124, 71, 130, 26);
		bookingPanel.add(txtCheckOutDate);
		txtCheckOutDate.setColumns(10);
		
		JLabel lblNumberOfRooms = new JLabel("Number Of Rooms");
		lblNumberOfRooms.setBounds(341, 36, 135, 16);
		bookingPanel.add(lblNumberOfRooms);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(341, 76, 135, 16);
		bookingPanel.add(lblRoomType);
		JComboBox cbxNumOfRooms = new JComboBox(roomAmount);
		cbxNumOfRooms.setSelectedIndex(0);
		cbxNumOfRooms.setMaximumRowCount(10);
		cbxNumOfRooms.setBounds(488, 32, 121, 27);
		bookingPanel.add(cbxNumOfRooms);
		JComboBox cbxRoomType = new JComboBox(roomType);
		cbxRoomType.setSelectedIndex(0);
		cbxRoomType.setBounds(488, 72, 121, 27);
		bookingPanel.add(cbxRoomType);
		
		JButton btnSearchAndBook = new JButton("Search");
		btnSearchAndBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 0;
				double totalprice = 0;
				boolean avali = true;
				String inDay = txtCheckInDate.getText();
				String outDay = txtCheckOutDate.getText();
				int rooms = Integer.valueOf((String) cbxNumOfRooms.getSelectedItem());
				String roomType =  (String) cbxRoomType.getSelectedItem();
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
					txtResultArea.setText("The is currently a room avaliable for the dates selected.\n"
							+ "Check In Date: "+inDay+"\nCheck Out Date: " +outDay+"\nRoom Type: "+roomType+"\nNumber of Rooms: "+rooms
									+ "\nThe price of all the rooms per days is :"+ price+"\nYour total stay of the price is: "+String.format("%,.2f", totalprice));
				} else {
					txtResultArea.setText("Unfortunalty there are not avaliable rooms for that "
							+ "date meeting the select requirments. Please try again with a "
							+ "different room perference.");
				}
			}
		});
		btnSearchAndBook.setBounds(513, 369, 117, 29);
		bookingPanel.add(btnSearchAndBook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 120, 624, 239);
		bookingPanel.add(scrollPane);
		
		txtResultArea = new JTextArea();
		txtResultArea.setEditable(false);
		txtResultArea.setBackground(Color.WHITE);
		txtResultArea.setLineWrap(true);
		txtResultArea.setWrapStyleWord(true);
		scrollPane.setViewportView(txtResultArea);
		
		JLabel lblChkInFormat = new JLabel("YYYY-MM-DD");
		lblChkInFormat.setHorizontalAlignment(SwingConstants.CENTER);
		lblChkInFormat.setBounds(124, 17, 130, 16);
		bookingPanel.add(lblChkInFormat);
		
		JLabel lblChkOutFormat = new JLabel("YYYY-MM-DD");
		lblChkOutFormat.setHorizontalAlignment(SwingConstants.CENTER);
		lblChkOutFormat.setBounds(124, 60, 130, 16);
		bookingPanel.add(lblChkOutFormat);
		
		btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean reserved;
				String inDay = txtCheckInDate.getText();
				String outDay = txtCheckOutDate.getText();
				int rooms = Integer.valueOf((String) cbxNumOfRooms.getSelectedItem());
				String roomType =  (String) cbxRoomType.getSelectedItem();
				reserved = appInteraction.reserveRoom(userNum,inDay,outDay, rooms, roomType);
				if (reserved) {
					txtResultArea.setText("The room has been reserved for the following dates selected.\n"
							+ "Check In Date: "+inDay+"\nCheck Out Date: " +outDay+"\nRoom Type: "+roomType+"\nNumber of Rooms: "+rooms);
				} else {
					txtResultArea.setText("Unfortunalty your room has not been reserved. Please try again.");
				}
				try {
					appInteraction.reservationList(userNum);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnReserve.setBounds(16, 369, 117, 29);
		bookingPanel.add(btnReserve);
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(null);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(25, 43, 95, 16);
		registerPanel.add(lblName);
		
		lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setBounds(25, 71, 95, 16);
		registerPanel.add(lblEmail_1);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(25, 99, 95, 16);
		registerPanel.add(lblAddress);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(25, 127, 107, 16);
		registerPanel.add(lblPhoneNumber);
		
		lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(25, 155, 95, 16);
		registerPanel.add(lblPassword_1);
		
		txtFieldName = new JTextField();
		txtFieldName.setBounds(132, 38, 386, 26);
		registerPanel.add(txtFieldName);
		txtFieldName.setColumns(10);
		
		txtEmailEntry = new JTextField();
		txtEmailEntry.setBounds(132, 66, 386, 26);
		registerPanel.add(txtEmailEntry);
		txtEmailEntry.setColumns(10);
		
		txtFieldAddress = new JTextField();
		txtFieldAddress.setBounds(132, 94, 386, 26);
		registerPanel.add(txtFieldAddress);
		txtFieldAddress.setColumns(10);
		
		txtFieldPhoneNum = new JTextField();
		txtFieldPhoneNum.setBounds(132, 122, 386, 26);
		registerPanel.add(txtFieldPhoneNum);
		txtFieldPhoneNum.setColumns(10);
		
		txtFieldPass = new JTextField();
		txtFieldPass.setBounds(132, 150, 386, 26);
		registerPanel.add(txtFieldPass);
		txtFieldPass.setColumns(10);
		
		lblRegisterGreeting = new JLabel("Please provide your information");
		lblRegisterGreeting.setBounds(177, 10, 281, 16);
		registerPanel.add(lblRegisterGreeting);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtFieldName.getText();
				String phoneNum = txtFieldPhoneNum.getText();
				String email = txtEmailEntry.getText();
				String address = txtFieldAddress.getText();
				String password = txtFieldPass.getText();
				
				try {
					appInteraction.createUser(name,email,phoneNum,address,password);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				logInPanel.setVisible(true);
				welcomePanel.setVisible(false);
				bookingPanel.setVisible(false);
				reservationPanel.setVisible(false);
				registerPanel.setVisible(false);
			}
		});
		btnRegister.setBounds(490, 337, 117, 29);
		registerPanel.add(btnRegister);
		
		
		reservationPanel = new JPanel();
		reservationPanel.setBackground(new Color(192, 192, 192));
		reservationPanel.setBounds(252, 227, 636, 404);
		reservationPanel.setVisible(false);
		frame.getContentPane().add(reservationPanel);
		reservationPanel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(21, 117, 594, 253);
		reservationPanel.add(scrollPane_1);
		
		reservationTextArea = new JTextArea();
		reservationTextArea.setEditable(false);
		reservationTextArea.setLineWrap(true);
		reservationTextArea.setWrapStyleWord(true);
		scrollPane_1.setViewportView(reservationTextArea);
		
		lblReservationLogIn = new JLabel("Please Log in to view your reservation history.");
		lblReservationLogIn.setBounds(24, 55, 334, 39);
		reservationPanel.add(lblReservationLogIn);
		
		adminPanel = new JPanel();
		adminPanel.setBackground(Color.LIGHT_GRAY);
		adminPanel.setBounds(252, 227, 636, 404);
		adminPanel.setVisible(false);
		frame.getContentPane().add(adminPanel);
		adminPanel.setLayout(null);
		
		lblAdministrionPage = new JLabel("Administrion Page");
		lblAdministrionPage.setFont(new Font("Apple Chancery", Font.PLAIN, 27));
		lblAdministrionPage.setBounds(31, 17, 264, 45);
		adminPanel.add(lblAdministrionPage);
		
		btnInstall = new JButton("Install");
		btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					appInteraction.initDatabase();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInstall.setBounds(491, 355, 117, 29);
		adminPanel.add(btnInstall);
		
		txtpnAdminmessage = new JTextPane();
		txtpnAdminmessage.setBackground(new Color(192, 192, 192));
		txtpnAdminmessage.setText("This page is to set up the database for the application. Please run this at the start of the application.");
		txtpnAdminmessage.setBounds(318, 75, 290, 78);
		adminPanel.add(txtpnAdminmessage);
	}
}
