import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConn {

	private Connection conn = null;
    private Statement statement = null;
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
	

	
	public void initDatabase() throws SQLException {

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
		String ktransactionTable = "CREATE TABLE kingTransaction ( transNum INT not null AUTO_INCREMENT, sDate DATE NOT NULL, eDate DATE NOT NULL, userid INT NOT NULL, roomNum INT NOT NULL, "
				+ "totalCost DECIMAL(15,2), PRIMARY KEY (transNum), FOREIGN KEY (userid) REFERENCES clientInfo(userid) ON DELETE CASCADE, "
				+ "FOREIGN KEY (roomNum) REFERENCES roomInfo(roomNum) ON DELETE CASCADE)";
		String dtransactionTable = "CREATE TABLE doubleTransaction ( transNum INT not null AUTO_INCREMENT, sDate DATE NOT NULL, eDate DATE NOT NULL, userid INT NOT NULL, roomNum INT NOT NULL, "
				+ "totalCost DECIMAL(15,2), PRIMARY KEY (transNum), FOREIGN KEY (userid) REFERENCES clientInfo(userid) ON DELETE CASCADE, "
				+ "FOREIGN KEY (roomNum) REFERENCES roomInfo(roomNum) ON DELETE CASCADE)";
		String stransactionTable = "CREATE TABLE suiteTransaction ( transNum INT not null AUTO_INCREMENT, sDate DATE NOT NULL, eDate DATE NOT NULL, userid INT NOT NULL, roomNum INT NOT NULL, "
				+ "totalCost DECIMAL(15,2), PRIMARY KEY (transNum), FOREIGN KEY (userid) REFERENCES clientInfo(userid) ON DELETE CASCADE, "
				+ "FOREIGN KEY (roomNum) REFERENCES roomInfo(roomNum) ON DELETE CASCADE)";
		String calendarTable = "create table datecalendar (id int auto_increment primary key, thedate date, calendarmonth int, calendarday int, "
				+ "calendaryear int, dayofweek int, dayofyear int, calmonth varchar(20), dayweek varchar(12), yyyymmdd varchar(10), unique days (thedate))";
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
		initRooms();
		createProcedures();
				
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
	
	private void createProcedures() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelreservation?user="+user+"&password="+pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		statement = conn.createStatement();
		String dropProCal = "drop procedure if exists calendar";
		String dropProKing = "drop procedure if exists avalKingDate";
		String dropProDouble = "drop procedure if exists avalSuiteDate";
		String dropProSuite = "drop procedure if exists avalDoubleDate";
		String dropProCalLoad = "drop procedure if exists calendarload";
		
		String kingProcedure= "Create procedure avalKingDate( checkInDate datetime, checkOutDate datetime, numRoom int) "
				+ "Deterministic Begin select datecalendar.thedate, numRoom-(COUNT(transNum)) available from datecalendar left "
				+ "join kingTransaction on datecalendar.thedate >= kingTransaction.sDate and datecalendar.thedate < kingTransaction.eDate "
				+ "where datecalendar.thedate BETWEEN checkInDate and checkOutDate group by thedate order by thedate; END";
		String suiteProcedure = "Create procedure avalSuiteDate( checkInDate datetime, checkOutDate datetime, numRoom int) "
				+ "Deterministic Begin select datecalendar.thedate, numRoom-(COUNT(transNum)) available from datecalendar left "
				+ "join suiteTransaction on datecalendar.thedate >= suiteTransaction.sDate and datecalendar.thedate < suiteTransaction.eDate "
				+ "where datecalendar.thedate BETWEEN checkInDate and checkOutDate group by thedate order by thedate; END";
		String doubleProcedure = "Create procedure avalDoubleDate( checkInDate datetime, checkOutDate datetime, numRoom int) "
				+ "Deterministic Begin select datecalendar.thedate, numRoom-(COUNT(transNum)) available from datecalendar left "
				+ "join doubleTransaction on datecalendar.thedate >= doubleTransaction.sDate and datecalendar.thedate < doubleTransaction.eDate "
				+ "where datecalendar.thedate BETWEEN checkInDate and checkOutDate group by thedate order by thedate; END";
		String calendarload = "create procedure calendarload(beginingdate datetime, endingdate datetime, daystoprocess int ) deterministic begin "
				+ "declare startdate datetime; set startdate=beginingdate; insert into datecalendar (thedate) values (beginingdate); "
				+ "while startdate < endingdate DO set startdate = adddate(startdate, interval daystoprocess day ); "
				+ "insert into datecalendar (thedate) values ( startdate ); end while; end ";
		String calendarGen = "call calendarload('2018-01-01 00:00:00', '2200-12-31 00:00:00', 1);";
		try {
			statement.execute(dropProCal);
			statement.execute(dropProKing);
			statement.execute(dropProDouble);
			statement.execute(dropProSuite);
			statement.execute(dropProCalLoad);
			statement.execute(kingProcedure);
			statement.execute(suiteProcedure);
			statement.execute(doubleProcedure);
			statement.execute(calendarload);
			statement.execute(calendarGen);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		calendarFormat();
	}
	
	private void calendarFormat() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelreservation?user="+user+"&password="+pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		statement = conn.createStatement();
		String dateCol = "update datecalendar set yyyymmdd = date_format(thedate, '%Y%m%d')";
		String monthCol = "update datecalendar set calendarmonth = date_format(thedate, '%m')";
		String dayCol = "update datecalendar set calendarday = date_format(thedate, '%d')";
		String yearCol = "update datecalendar set calendaryear = date_format(thedate, '%y')";
		String dayOfWeekCol = "update datecalendar set dayofweek = date_format(thedate, '%w')";
		String dayOfYearCol = "update datecalendar set dayofyear = date_format(thedate, '%j')";
		String calMonthCol = "update datecalendar set calmonth = date_format(thedate, '%M')";
		String dayWeekCol = "update datecalendar set dayweek = date_format(thedate, '%W')";

		try {
			statement.execute(dateCol);
			statement.execute(monthCol);
			statement.execute(dayCol);
			statement.execute(yearCol);
			statement.execute(dayOfWeekCol);
			statement.execute(dayOfYearCol);
			statement.execute(calMonthCol);
			statement.execute(dayWeekCol);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}

}
