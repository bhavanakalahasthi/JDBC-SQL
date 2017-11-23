import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Testdb {
 
	public static void main(String args[])
	{
		
		String insertQuery = "insert into mainsample.suppliers(SUP_ID,SUP_NAME,STREET,CITY,STATE,ZIP)" +"values(77,'GEORGE','FRANKLIN','KANSAS','MISSOURI','64093')";
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainsample?useSSL=false", "root", "mysql");
		
		Statement statement= connection.createStatement();
		int noofRows= statement.executeUpdate(insertQuery);
		if(noofRows==1)
		{
			System.out.println("record added successfully");
		}
		connection.close();
		}
		catch(Exception e)
		{
	e.printStackTrace();
	}
	}
	}

