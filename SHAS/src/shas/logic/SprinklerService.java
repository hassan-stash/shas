/**
 * 
 */
package shas.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.sql.Statement; 
import java.sql.DriverManager;

import java.sql.PreparedStatement;

import shas.devices.Schedule;
import shas.devices.interfaces.*;
import sun.org.mozilla.javascript.internal.ObjArray;

/**
 * @author Abu Hassan
 * Scheduler related service
 */
public class SprinklerService implements ISprinkler{

	public boolean SetSprinklerSetting(Schedule objSchedule) throws SQLException
	{
		Connection dbConnection = null;
		PreparedStatement stmtUpdateSchedule = null;
		
		java.sql.Timestamp tsFrom = new java.sql.Timestamp(objSchedule.getDtfrom().getTime());
		java.sql.Timestamp tsTo = new java.sql.Timestamp(objSchedule.getDtto().getTime());
	    System.out.println("utilDate:" + objSchedule.getDtfrom().getTime());
		
		String updateString =
			"update " + "tb_sprinkler_schedule " +
	        "set level = ?, duration =?, status=?, fromdatetime=?, todatetime=? "+
			"where sprinklerid = 'sprinkler1'";
		 
			
		try
		{
			
			dbConnection = GetDBConnection();
			stmtUpdateSchedule = dbConnection.prepareStatement(updateString);
			stmtUpdateSchedule.setInt(1, objSchedule.getLevel());
			stmtUpdateSchedule.setInt(2, objSchedule.getDuration());
			stmtUpdateSchedule.setInt(3, objSchedule.getStatus());
			stmtUpdateSchedule.setTimestamp(4,tsFrom);
			stmtUpdateSchedule.setTimestamp(5, tsTo);
			Integer updatedrows = stmtUpdateSchedule.executeUpdate();
			
			if(updatedrows>0)
			{
				System.out.println("Schedule Updated Successfully");
				return true;
			}
			else
				return false;
			
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

	
	public Schedule GetActiveSchedule() throws SQLException
	{
		Connection dbConnection = null;
		Statement stmtSchedule = null;
		Schedule objActiveSchedule = new Schedule();
		try
		{
			dbConnection = GetDBConnection();
			stmtSchedule = dbConnection.createStatement();
			String SelectString ="select * from tb_sprinkler_schedule where sprinklerid = 'sprinkler1'";
			ResultSet rsSchedule = stmtSchedule.executeQuery(SelectString);
			
			
			 while(rsSchedule.next()){
		         //Retrieve by column name
				 objActiveSchedule.setSprinklerid(rsSchedule.getString("sprinklerid"));
				 objActiveSchedule.setDtfrom(rsSchedule.getDate("fromdatetime"));
				 objActiveSchedule.setDtto(rsSchedule.getDate("todatetime"));
				 objActiveSchedule.setLevel(rsSchedule.getInt("level"));
				 objActiveSchedule.setDuration(rsSchedule.getInt("duration"));
				 objActiveSchedule.setStatus(rsSchedule.getInt("status"));
				 
		      }
		      
			 rsSchedule.close();
		      
			
			
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
			//Clean-up environment
			if (stmtSchedule!= null) {
				stmtSchedule.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return objActiveSchedule;
		
		
		
		
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
