import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random; 
import java.security.*;


public class appInteraction extends applicationUI {

	private int userIdNum;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	static int num;
	static String name;
	
	private appInteraction(){

		
		
	}
	
	
	public static void reservationList(int userId) throws SQLException {
		String[] roomtable = {"king", "double", "suite"};


		for (int i =0; i < roomtable.length; i++) {
			String query = "SELECT * FROM "+roomtable[i]+"Transaction where userid = '"+userId+"'";
			System.out.println(query);
			dbConn db = new dbConn();
			ResultSet reservation = db.getData(query);
			while (reservation.next()) {
				int transactionNum = reservation.getInt("transNum");
				Date sDate = reservation.getDate("sDate");
				Date lDate = reservation.getDate("eDate");
				//int roomNum = reservation.getInt("roomNum");
				resTextArea.append("The reservation confirmation number is "+ transactionNum);
				resTextArea.append("\n The reservation is set for "+ sDate+ " to "+ lDate);
				resTextArea.append("\n Your room type reserved is a " + roomtable[i]);
				resTextArea.append("\n----------------------------------------------\n");
			}
		}
	}
	
	public static void createUser(String name, String email, String phoneNum, String address, String password) throws SQLException {
		Random rand = new Random(); 
		int userId = rand.nextInt(100000) + 10000;
		String query = "Insert into clientInfo values (" +userId+ ", '"+ name + "', '" + email + "', '" +phoneNum+ "', '"+address+"', '"+password+"')";
		System.out.println(query);
		
		dbConn db = new dbConn();
		db.insertData(query, "hotelreservation");

	}
	
	public static Integer userID(String email, String pass) throws SQLException {
		String query = "select userid from clientInfo where email='" + email +"' AND password='"+pass+"'";
		dbConn db = new dbConn();
		ResultSet memberNum = db.getData(query);
		memberNum.next();
		num = memberNum.getInt("userid");
		return num;
		
	}
	
	public static String userName(String email, String pass) throws SQLException {
		String query = "select name from clientInfo where email='" + email +"' AND password='"+pass+"'";
		dbConn db = new dbConn();
		ResultSet memberNum = db.getData(query);
		memberNum.next();
		name = memberNum.getString("name");
		System.out.println(name);
		return name;
		
	}
	
	public static boolean availRoomsChk(String chkInDate, String chkOutDate, int amountRooms, String roomType) throws SQLException {
		int totalRooms = numRoomsPerCateg(roomType);
		boolean avaliable = true;
		String query = "call aval"+roomType+"Date('"+chkInDate+"','"+chkOutDate+"',"+totalRooms+")";
		dbConn db = new dbConn();
		ResultSet availRooms = db.getData(query);
		while (availRooms.next()) {
			if ((availRooms.getInt("available") >= amountRooms) | avaliable == false) {
				avaliable = true;
			} else {
				avaliable = false;
			}
		}
		System.out.println(avaliable);
		return avaliable;
		
	}
	
	
	public static double getRoomPrice(String roomType) {
		double cost = 0;
		String query = "SELECT price from roomInfo where roomType = '"+roomType+"' limit 1";
		dbConn db;
		try {
			db = new dbConn();
			ResultSet roomPrice = db.getData(query);
			roomPrice.next();
			cost = roomPrice.getDouble("price");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cost;
	}
	
	public static boolean reserveRoom(int userNum, String chkInDate, String chkOutDate, int amountRooms, String roomType) {
		boolean reserved = true;
		double price = getRoomPrice(roomType);
		dbConn db;
		for (int i = 0; i < amountRooms; i++) {
			String query = "INSERT INTO "+roomType+"Transaction (sDate, eDate, userid, roomNum, totalCost) values ('"+chkInDate+"', '"+chkOutDate+"', "+userNum+", 150, "+price+")";
			try {
				db = new dbConn();
				db.insertData(query, "hotelreservation");
			} catch (SQLException e) {
				e.printStackTrace();
				reserved = false;
			}
		}
		
		
		return reserved;
	}
	
	public static int numRoomsPerCateg(String roomType) {
		ResultSet result = null;
		dbConn db;
		int roomTotal = 0;
		try {
			db = new dbConn();
			result = db.getData("SELECT count(*) FROM roomInfo WHERE roomType = '"+roomType+"'");
			result.next();
			roomTotal = result.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomTotal;
	}
		
	public static int numOfDays(String chkInDate, String chkOutDate) {
		int numDays = 0;
		String query = "select count(*) from datecalendar where thedate between '"+chkInDate+"' and '"+chkOutDate+"'";
		dbConn db;
		try {
			db = new dbConn();
			ResultSet numDate = db.getData(query);
			numDate.next();
			numDays = numDate.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numDays;
	}
	
}
