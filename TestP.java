import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.db.Suppliers;



public class TestP {
	public static void addProducts(int id,String name,String street,String city,String state,int zip)
	{

		String insertQuery = "insert into mainsample.suppliers(SUP_ID,SUP_NAME,STREET,CITY,STATE,ZIP)" +"values(?,?,?,?,?,?)";
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainsample?useSSL=false", "root", "mysql");
		
		PreparedStatement preparedStatement= connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, street);
		preparedStatement.setString(4,city);
		preparedStatement.setString(5, state);
		preparedStatement.setInt(6, zip);
		
		
		int noofRows= preparedStatement.executeUpdate(insertQuery);
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

public static void addProducts(Suppliers sup)
{

	String insertQuery = "insert into mainsample.suppliers(SUP_ID,SUP_NAME,STREET,CITY,STATE,ZIP)" +"values(?,?,?,?,?,?)";
	try
	{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainsample?useSSL=false", "root", "mysql");
	
	PreparedStatement preparedStatement= connection.prepareStatement(insertQuery);
	preparedStatement.setInt(1, sup.getId());
	preparedStatement.setString(2, sup.getName());
	preparedStatement.setString(3, sup.getStreet());
	preparedStatement.setString(4,sup.getCity());
	preparedStatement.setString(5, sup.getState());
	preparedStatement.setInt(6, sup.getZip());
	
	
	int noofRows= preparedStatement.executeUpdate(insertQuery);
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
	public static void main(String[] args) {
		
		Suppliers sup=new Suppliers(75,"sam","sht","sfr","ca",67890);
		addProducts(sup);
	}

}
