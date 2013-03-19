/**
 * 
 */
package shas.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Statement; 
import java.sql.DriverManager;

import java.sql.PreparedStatement;

import shas.devices.Schedule;
import shas.devices.interfaces.*;

/**
 * @author Abu Hassan
 * Scheduler related service
 */
public class SprinklerService implements ISprinkler{

	public boolean SetSprinklerSetting(Schedule objSchedule) throws SQLException
	{
		Connection dbConnection = null;
		//Statement statement = null;
		PreparedStatement stmtUpdateSchedule = null;
		
		String updateString =
			"update " + "tb_sprinkler_schedule " +
	        "set level = ? where sprinklerid = 'sprinkler1'";
		 
//		String insertTableSQL = "UPDATE tb_sprinkler_schedule SET level="+objSchedule.getLevel()+", duration ="+objSchedule.getDuration()+","
//			+ "status=1,from ='"+objSchedule.getDtfrom()+"', to ='"+objSchedule.getDtto()+"' WHERE  sprinklerid = 'sprinkler1'";
			
		try
		{
			
			dbConnection = GetDBConnection();
			stmtUpdateSchedule = dbConnection.prepareStatement(updateString);
			stmtUpdateSchedule.setInt(1, objSchedule.getLevel()); 
			Integer updatedrows = stmtUpdateSchedule.executeUpdate();
			
			if(updatedrows>0)
			{
				System.out.println("Schedule Updated Successfully");
			}
			
		}catch (SQLException e) {
			 
			 if (dbConnection != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                dbConnection.rollback();
		            } catch(SQLException excep) {
		            	System.out.println(e.getMessage());
		            }
		        }
			
 
		} finally {
 
			if (stmtUpdateSchedule != null) {
				stmtUpdateSchedule.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
	 return true;
	}

	@Override
	public void Set_sprinklers(String day_of_week, Date time_of_day,
			Integer length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Turn_off_sprinklers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Rain_sensor(Integer day_begins, Integer time_begin,
			Integer time_of_day, Integer length) {
		// TODO Auto-generated method stub
		
	}
	
	static Connection GetDBConnection()
	{
		System.out.println("MySQL Connection.");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check stack trace");
			e.printStackTrace();
			return null;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
		 
	}
	
}
