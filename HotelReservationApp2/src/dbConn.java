import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConn {

	private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String user = "root";
    private String pass = "root"; //put in database password
    private String database = "hotelreservation";
    private double kingPrice = 101.54;
    private double doublePrice = 130.54;
    private double suitePrice = 715.54;
    private int kingBed = 1;
    private int doubleBed = 2;
    private int suiteBed = 3;
 
	
	
    public dbConn() throws SQLException {

	}
	
	public void insertData(String sql, String database) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?user="+user+"&password="+pass);
		} catch (Exception e) {
			createDropDatabase("Error Inserting Data");
		}
		statement = conn.createStatement();
		
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void createDropDatabase(String sql) throws SQLException {
		Connection databaseconn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			databaseconn = DriverManager.getConnection("jdbc:mysql://localhost/?user="+user+"&password="+pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		statement = databaseconn.createStatement();
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public ResultSet getData(String sql) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?user="+user+"&password="+pass);
		} catch (Exception e) {
			createDropDatabase("Error connecting to the Database");
		}
		statement = conn.createStatement();
		
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return resultSet;
	}
	

	
	private void initDatabase() throws SQLException {

		createDropDatabase("CREATE DATABASE hotelreservation");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelreservation?user="+user+"&password="+pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		statement = conn.createStatement();
        String clientInfoTable = "CREATE TABLE clientInfo ( userid INT not null, name VARCHAR(255) not null, email VARCHAR(255), phone VARCHAR(50) not null, address VARCHAR(255) NOT NULL,"
        		+ "password VARCHAR(255) NOT NULL, PRIMARY KEY (userid) )";
        String roomInfoTable = "CREATE TABLE roomInfo ( roomNum INT not null, roomType VARCHAR(255) not null, price decimal(15,2), numBeds INT not null, PRIMARY KEY (roomNum))";
		String ktransactionTable = "CREATE TABLE kingTransaction ( transNum INT not null, sDate DATE NOT NULL, eDate DATE NOT NULL, userid INT NOT NULL, roomNum INT NOT NULL, "
				+ "totalCost DECIMAL(15,2), PRIMARY KEY (transNum), FOREIGN KEY (userid) REFERENCES clientInfo(userid) ON DELETE CASCADE, "
				+ "FOREIGN KEY (roomNum) REFERENCES roomInfo(roomNum) ON DELETE CASCADE)";
		String dtransactionTable = "CREATE TABLE doubleTransaction ( transNum INT not null, sDate DATE NOT NULL, eDate DATE NOT NULL, userid INT NOT NULL, roomNum INT NOT NULL, "
				+ "totalCost DECIMAL(15,2), PRIMARY KEY (transNum), FOREIGN KEY (userid) REFERENCES clientInfo(userid) ON DELETE CASCADE, "
				+ "FOREIGN KEY (roomNum) REFERENCES roomInfo(roomNum) ON DELETE CASCADE)";
		String stransactionTable = "CREATE TABLE suiteTransaction ( transNum INT not null, sDate DATE NOT NULL, eDate DATE NOT NULL, userid INT NOT NULL, roomNum INT NOT NULL, "
				+ "totalCost DECIMAL(15,2), PRIMARY KEY (transNum), FOREIGN KEY (userid) REFERENCES clientInfo(userid) ON DELETE CASCADE, "
				+ "FOREIGN KEY (roomNum) REFERENCES roomInfo(roomNum) ON DELETE CASCADE)";
		String calendarTable = "create table datecalendar (id int auto_increment primary key, thedate date, calendarmonth int, calendarday int, "
				+ "calendaryear int, dayofweek int, dayofyear int, calmonth varchar(20), dayweek varchar(12), yyyy-mm-dd varchar(10), unique days (thedate))";
		try {
			statement.executeUpdate(clientInfoTable);
			statement.executeUpdate(roomInfoTable);
			statement.executeUpdate(ktransactionTable);
			statement.executeUpdate(dtransactionTable);
			statement.executeUpdate(stransactionTable);
			statement.executeUpdate(calendarTable);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		initProcedure();
				
	}
	
	private void initProcedure() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelreservation?user="+user+"&password="+pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		String dropProCal = "drop procedure if exists calendar";
		String dropProCalLoad = "drop procedure if exists calendarload";
		
		try {
			statement.executeUpdate(dropProCal);
			statement.executeUpdate(dropProCalLoad);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}
	
	
	
	private void initRooms() throws SQLException {
		double price =0;
		String roomType = "king";
		int beds = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelreservation?user="+user+"&password="+pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for(int i=100; i <= 150; i++ ) {
			for(int x =0; x < 8; x++) {
				if ((i+(x*100) == 100+(x*100)) | (i+(x*100) == 150+(x*100))) {
				roomType = "Suite";
				beds = suiteBed;
					price = suitePrice;
				} else if (( i+(x*100) > 100+(x*100)) & (i+(x*100) < 130+(x*100))) {
					roomType = "King";
					beds = kingBed;
					price = kingPrice;
				} else {
					roomType = "Double";
					beds = doubleBed;
					price = doublePrice;
				}
				statement = conn.createStatement();
				String roomInfoTable = "INSERT INTO roomInfo values ('"+(i+(x*100))+"', '"+roomType+"', '"+price+"', '"+beds+"')";
				try {
					statement.executeUpdate(roomInfoTable);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		}	
	}
	
	
	/*
	public static void main(String[] args) throws SQLException {
		dbConn myConn = new dbConn();
		myConn.initDatabase();
		myConn.initRooms();

	
	}*/
}
