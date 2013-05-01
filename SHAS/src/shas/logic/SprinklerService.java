//------------------------------------------------------------------------//
//SHAS Team Omega
//Author : Abu Hassan
//Last changed : 24 April 2013
//Handles Power usage 
//
//------------------------------------------------------------------------//
/**
 * 
 */
package shas.logic;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.sql.Statement; 
import java.sql.DriverManager;

import java.sql.PreparedStatement;

import shas.devices.Schedule;
import shas.devices.usage;
//import shas.devices.usage;
import shas.devices.interfaces.*;
import sun.org.mozilla.javascript.internal.ObjArray;

/**
 * @author Abu Hassan
 * Scheduler related service
 */
public class SprinklerService implements ISprinkler{

	//---------------------------------------------------------//
	// Set the sprinkler settings
	//
	//---------------------------------------------------------//
	public boolean SetSprinklerSetting(Schedule objSchedule, boolean override) throws SQLException
	{
		Connection dbConnection = null;
		PreparedStatement stmtUpdateSchedule = null;
		
		java.sql.Timestamp tsFrom = new java.sql.Timestamp(objSchedule.getDtfrom().getTime());
		java.sql.Timestamp tsTo = new java.sql.Timestamp(objSchedule.getDtto().getTime());
				
		
	    String updateString;
	   
	    	updateString =
	    		"update " + "tb_sprinkler_schedule " +
		        "set level = ?, duration =?, status=?, fromdatetime=?, todatetime=?,"+
		        "monday=?, tuesday=?,wednesday=?,thursday=?,friday=?,saturday=?,sunday=? "+
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
			stmtUpdateSchedule.setInt(6, objSchedule.getMonday());
			stmtUpdateSchedule.setInt(7, objSchedule.getTuesday());
			stmtUpdateSchedule.setInt(8, objSchedule.getWednesday());			
			stmtUpdateSchedule.setInt(9, objSchedule.getThursday());			
			stmtUpdateSchedule.setInt(10, objSchedule.getFriday());
			stmtUpdateSchedule.setInt(11, objSchedule.getSaturday());
			stmtUpdateSchedule.setInt(12, objSchedule.getSunday());
			Integer updatedrows = stmtUpdateSchedule.executeUpdate();
			
			if(updatedrows>0)
			{
				if (updatedays(objSchedule)){
					return true;	
				}
				else 
					return false;
				
				
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

	//---------------------------------------------------------//
	// Update days schedule settings
	//
	//---------------------------------------------------------//
	public boolean updatedays(Schedule objSchedule) throws SQLException
	{
		
		
	
		
		Hashtable<String,ArrayList<Timestamp>> hTable=new Hashtable<String,ArrayList<Timestamp>>();
		
		
		ArrayList<Timestamp> obj = new ArrayList<Timestamp>();	
		java.sql.Timestamp tsMonFrom = new java.sql.Timestamp(objSchedule.getMondayfrom().getTime());
		java.sql.Timestamp tsMonTo = new java.sql.Timestamp(objSchedule.getMondayto().getTime());
		obj.add(tsMonFrom);
		obj.add(tsMonTo);
		
		hTable.put("monday", obj);
		
		java.sql.Timestamp tsTueFrom = new java.sql.Timestamp(objSchedule.getTuesdayfrom().getTime());
		java.sql.Timestamp tsTueTo = new java.sql.Timestamp(objSchedule.getTuesdayto().getTime());
		ArrayList<Timestamp> obj2 = new ArrayList<Timestamp>();		
		obj2.add(tsTueFrom);
		obj2.add(tsTueTo);
		
		hTable.put("tuesday", obj2);
		
		
		java.sql.Timestamp tsWedFrom = new java.sql.Timestamp(objSchedule.getWednesdayfrom().getTime());
		java.sql.Timestamp tsWedTo = new java.sql.Timestamp(objSchedule.getWednesdayto().getTime());
		ArrayList<Timestamp> obj3 = new ArrayList<Timestamp>();	
		obj3.add(tsWedFrom);
		obj3.add(tsWedTo);
		
		hTable.put("wednesday", obj3);
		
		java.sql.Timestamp tsThuFrom = new java.sql.Timestamp(objSchedule.getThursdayfrom().getTime());
		java.sql.Timestamp tsThuTo = new java.sql.Timestamp(objSchedule.getThursdayto().getTime());
		ArrayList<Timestamp> obj4 = new ArrayList<Timestamp>();	
		obj4.add(tsThuFrom);
		obj4.add(tsThuTo);
		
		hTable.put("thursday", obj4);
		
		
		java.sql.Timestamp tsFriFrom = new java.sql.Timestamp(objSchedule.getFridayfrom().getTime());
		java.sql.Timestamp tsFriTo = new java.sql.Timestamp(objSchedule.getFridayto().getTime());
		ArrayList<Timestamp> obj5 = new ArrayList<Timestamp>();	
		obj5.add(tsFriFrom);
		obj5.add(tsFriTo);
		
		hTable.put("friday", obj5);
		
		

		java.sql.Timestamp tsSatFrom = new java.sql.Timestamp(objSchedule.getSaturdayfrom().getTime());
		java.sql.Timestamp tsSatTo = new java.sql.Timestamp(objSchedule.getSaturdayto().getTime());
		ArrayList<Timestamp> obj6 = new ArrayList<Timestamp>();	
		obj6.add(tsSatFrom );
		obj6.add(tsSatTo);
		
		hTable.put("saturday", obj6);
		
		
		java.sql.Timestamp tsSunFrom = new java.sql.Timestamp(objSchedule.getSundayfrom().getTime());
		java.sql.Timestamp tsSunTo = new java.sql.Timestamp(objSchedule.getSundayto().getTime());
		ArrayList<Timestamp> obj7 = new ArrayList<Timestamp>();	
		obj7.add(tsSunFrom);
		obj7.add(tsSunTo);
		
		hTable.put("sunday", obj7);
		
		
		java.sql.Timestamp tsDwnFrom = new java.sql.Timestamp(objSchedule.getDowntimefrom().getTime());
		java.sql.Timestamp tsDwnTo = new java.sql.Timestamp(objSchedule.getDowntimeto().getTime());
		ArrayList<Timestamp> obj8 = new ArrayList<Timestamp>();	
		obj8.add(tsDwnFrom);
		obj8.add(tsDwnTo);
		
		hTable.put("down", obj8);
		
		
		int rowscount =0;
		Connection dbConnection = null;
		PreparedStatement stmtUpdateSchedule = null;
		try
		{			
				
				Set set = hTable.entrySet();
			    Iterator it = set.iterator();
			    
			    while (it.hasNext()) 
			    
			    {
			        Map.Entry entry = (Map.Entry) it.next();		      
			      
			        ArrayList<Timestamp> objarr = new ArrayList<Timestamp>();
					objarr = (ArrayList<Timestamp>) entry.getValue();
					
					
						  String updatedaysString =
								"update tb_sprinklerdays" +
								" set fromdate = ?, todate =? " +
								" where day = ?";
						  dbConnection = GetDBConnection();
						  stmtUpdateSchedule = dbConnection.prepareStatement(updatedaysString);
						  
						  
						  Timestamp from = objarr.get(0);
						  Timestamp to = objarr.get(1);
						  
						  stmtUpdateSchedule.setTimestamp(1,from);
						  stmtUpdateSchedule.setTimestamp(2, to);
						  stmtUpdateSchedule.setString(3, (String) entry.getKey());
						  Integer updatedrows = stmtUpdateSchedule.executeUpdate();
						  stmtUpdateSchedule = null;
						  
						  if(updatedrows>0)
						  {
							  rowscount ++;  
						  }						  
					
					
			    }	
			    
			   
			    
					
		}
		catch (SQLException e) {
			 
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
		 if(rowscount >0)
		    	return true;
		    else
		    	return false;
		
	}
	

	//---------------------------------------------------------//
	// Get active schedules
	//
	//---------------------------------------------------------//
	public Schedule GetActiveSchedule(String Type) throws SQLException
	{
		Connection dbConnection = null;
		Statement stmtSchedule = null;
		Statement stmtDays = null;
		
		Schedule objActiveSchedule = new Schedule();
		try
		{
			dbConnection = GetDBConnection();
			//-from schedule--------//
			stmtSchedule = dbConnection.createStatement();
			
			String SelectString ="";
			
			if(Type.compareTo("override")== 0)
			{
				SelectString ="select * from tb_sprinkler_override where sprinklerid = 'sprinkler1'";
			}
			else
			{
				SelectString ="select * from tb_sprinkler_schedule where sprinklerid = 'sprinkler1'";
			}
			
			ResultSet rsSchedule = stmtSchedule.executeQuery(SelectString);			
			
			while(rsSchedule.next()){
		         //Retrieve by column name
				 objActiveSchedule.setSprinklerid(rsSchedule.getString("sprinklerid"));
				 objActiveSchedule.setDtfrom(rsSchedule.getTimestamp("fromdatetime"));
				 objActiveSchedule.setDtto(rsSchedule.getTimestamp("todatetime"));
				 objActiveSchedule.setLevel(rsSchedule.getInt("level"));
				 objActiveSchedule.setDuration(rsSchedule.getInt("duration"));
				 objActiveSchedule.setStatus(rsSchedule.getInt("status"));
				 objActiveSchedule.setMonday(rsSchedule.getInt("monday"));
				 objActiveSchedule.setTuesday(rsSchedule.getInt("tuesday"));
				 objActiveSchedule.setWednesday(rsSchedule.getInt("wednesday"));
				 objActiveSchedule.setThursday(rsSchedule.getInt("thursday"));
				 objActiveSchedule.setFriday(rsSchedule.getInt("friday"));
				 objActiveSchedule.setSaturday(rsSchedule.getInt("saturday"));
				 objActiveSchedule.setSunday(rsSchedule.getInt("sunday"));
//			     objActiveSchedule.setDowntime(rsSchedule.getInt("down"));				 
		      }
			
			//-- from days ------------------//
			
			
			String days[] = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday","down"};
					
			for(int i=0;i<days.length;i++)
			{
				stmtDays = dbConnection.createStatement();
				String querystr = "select * from tb_sprinklerdays where day = '"+days[i]+"'"; 
				ResultSet rsDays = stmtDays.executeQuery(querystr);
				while(rsDays.next()){
					
					if(days[i].toString().compareTo("monday") == 0)
					{
						objActiveSchedule.setMondayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setMondayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("tuesday") == 0)
					{
						objActiveSchedule.setTuesdayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setTuesdayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("wednesday") == 0)
					{
						objActiveSchedule.setWednesdayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setWednesdayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("thursday") == 0)
					{
						objActiveSchedule.setThursdayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setThursdayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("friday") == 0)
					{
						objActiveSchedule.setFridayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setFridayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("saturday") == 0)
					{
						objActiveSchedule.setSaturdayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setSaturdayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("sunday") == 0)
					{
						objActiveSchedule.setSundayfrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setSundayto(rsDays.getTimestamp("todate"));	
					}
					if(days[i].toString().compareTo("down") == 0)
					{
						objActiveSchedule.setDowntimefrom(rsDays.getTimestamp("fromdate"));
						objActiveSchedule.setDowntimeto(rsDays.getTimestamp("todate"));	
					}
					
				}
				
				rsDays.close();
				stmtDays.close();
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
	

	//---------------------------------------------------------//
	// Get usage details
	//
	//---------------------------------------------------------//
	public Hashtable<String, Integer> GetUsage(String Type, Date from, Date to) throws SQLException
	{
		ResultSet varRs = null;
		Connection dbConnection = null;
		Statement stmtUsage = null;
		
		Hashtable<String,Integer> htPower = new Hashtable<String, Integer>();
		
		try
		{
			dbConnection = GetDBConnection();
			//-from schedule--------//
			stmtUsage = dbConnection.createStatement();
			
			String SelectString ="";
			java.sql.Timestamp tsFrom = new java.sql.Timestamp(from.getTime());
			java.sql.Timestamp tsTo = new java.sql.Timestamp(to.getTime());
			
			ResultSet rsUsage = null;
			if(Type.compareTo("power")== 0)
			{
				System.out.println("In the power result set");
				SelectString ="select usagedate,duration,max(powerconsumed ) As powerused from tb_electricity_usage " +
				" where DATE(usagedate) >= DATE('"+ tsFrom +"') and DATE(usagedate) <= DATE('"+ tsTo +"') "+ 
				" group by DATE(usagedate)";
				
				rsUsage = stmtUsage.executeQuery(SelectString);
				
				while(rsUsage.next())
				{
					System.out.print(rsUsage.getTimestamp("usagedate").toString());
					htPower.put(rsUsage.getTimestamp("usagedate").toString(), (int)rsUsage.getFloat("powerused"));
				}
			}
			else if(Type.compareTo("water")== 0)
			{
				System.out.println("In the water res set");
				SelectString ="select usagedate,max(gallons) As totalgallons from tb_water_usage " +
				" where DATE(usagedate) >= DATE('"+ tsFrom +"') and DATE(usagedate) <= DATE('"+ tsTo +"') "+ 
				" group by DATE(usagedate)";
				
				
				rsUsage = stmtUsage.executeQuery(SelectString);
				
				while(rsUsage.next())
				{
					System.out.print(rsUsage.getTimestamp("usagedate").toString());
					htPower.put(rsUsage.getTimestamp("usagedate").toString(), rsUsage.getInt("totalgallons"));
				}
			}
			else if(Type.compareTo("poweryear")== 0)
			{
				System.out.println("In the water res set");
				SelectString ="select MONTHNAME(usagedate) as usagedate,max(powerconsumed ) As powerused from tb_electricity_usage " +
				" where DATE(usagedate) >= DATE('"+ tsFrom +"') and DATE(usagedate) <= DATE('"+ tsTo +"') "+ 
				" group by MONTH(usagedate) order by MONTH(usagedate) ";
				
				rsUsage = stmtUsage.executeQuery(SelectString);
				
				while(rsUsage.next())
				{	
					htPower.put(rsUsage.getString("usagedate").toString(), (int)rsUsage.getFloat("powerused"));
				}
			}
			else if(Type.compareTo("wateryear")== 0)
			{
				System.out.println("In the water res set");
				SelectString ="select MONTHNAME(usagedate) as usagedate,max(gallons) As totalgallons from tb_water_usage " +
				" where DATE(usagedate) >= DATE('"+ tsFrom +"') and DATE(usagedate) <= DATE('"+ tsTo +"') "+ 
				" group by MONTH(usagedate) order by MONTH(usagedate) ";
				
				
				rsUsage = stmtUsage.executeQuery(SelectString);
				
				while(rsUsage.next())
				{
					
					htPower.put(rsUsage.getString("usagedate").toString(), rsUsage.getInt("totalgallons"));
				}
			}
			
			rsUsage.close();
			
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
			if (stmtUsage!= null) {
				stmtUsage.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return htPower;
		
		
	}
	

	//---------------------------------------------------------//
	// Get Rain Gauge level
	//
	//---------------------------------------------------------//

	public int GetRainGausgeReading() throws SQLException
	{
		Connection dbConnection = null;
		Statement stmt= null;				
		int rainlevel=0;
		
		try
		{
			dbConnection = GetDBConnection();
			//-from schedule--------//
			stmt = dbConnection.createStatement();			
			String SelectString ="select * from tb_raingauge where daterained >= DATE_ADD(CURDATE(), INTERVAL -1 DAY) and daterained < CURDATE()";
			ResultSet rsInches = stmt.executeQuery(SelectString);			
			
			while(rsInches.next()){
		         //Retrieve by column name
				rainlevel = rainlevel + rsInches.getInt("level");
				 			 
		      }
			
			rsInches.close();
		    
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
			if (stmt!= null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return rainlevel;
		
	}
	


	//---------------------------------------------------------//
	// Update usage settings
	//
	//---------------------------------------------------------//
	public boolean UpdateUsage(usage objusage) throws SQLException
	{
	
		UpdateWaterUsage(objusage);
		Connection dbConnection = null;
		PreparedStatement stmtUpdateSchedule = null;
		
		java.sql.Timestamp tsDate = new java.sql.Timestamp(objusage.getDate().getTime());
		System.out.println("utilDate:" + objusage.getDate());
		
		String updateString =
			"insert into  tb_electricity_usage" +
	        "(device, usagedate, duration, powerconsumed)values(?,?,?,?)";
			
		try
		{
			
			dbConnection = GetDBConnection();
			stmtUpdateSchedule = dbConnection.prepareStatement(updateString);
			stmtUpdateSchedule.setString(1, objusage.getDeviceid() );
			stmtUpdateSchedule.setTimestamp(2,tsDate);
			stmtUpdateSchedule.setFloat(3,objusage.getDurationran());
			stmtUpdateSchedule.setFloat(4,objusage.getPowerconsumed());
			
			Integer updatedrows = stmtUpdateSchedule.executeUpdate();
			
			if(updatedrows>0)
			{
				System.out.println("Usage Updated Successfully");
				return true;
				
			}
			else
				{return false;}
			
			
				
			
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
				try {
					stmtUpdateSchedule.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
		
		
	 return true;
	}
	

	//---------------------------------------------------------//
	// Update water usage
	//
	//---------------------------------------------------------//
	public void  UpdateWaterUsage(usage objusage) throws SQLException
	{
	
		Connection dbConnection = null;
		PreparedStatement stmtUpdateSchedule = null;
		
		java.sql.Timestamp tsDate = new java.sql.Timestamp(objusage.getDate().getTime());
		System.out.println("utilDate:" + objusage.getDate());
		
		String updateString =
			"insert into  tb_water_usage" +
	        "(device, usagedate, gallons)values(?,?,?)";
			
		try
		{
			
			dbConnection = GetDBConnection();
			stmtUpdateSchedule = dbConnection.prepareStatement(updateString);
			stmtUpdateSchedule.setString(1, objusage.getDeviceid() );
			stmtUpdateSchedule.setTimestamp(2,tsDate);
			stmtUpdateSchedule.setFloat(3,objusage.getWaterconsumed());
						
			Integer updatedrows = stmtUpdateSchedule.executeUpdate();
			
//			if(updatedrows>0)
//			{
//				System.out.println("Usage Updated Successfully");
//				return true;
//			}
//			else
//				return false;
//			
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
				try {
					stmtUpdateSchedule.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
	 
	}
	
	@Override
	public void Set_sprinklers(String day_of_week, Date time_of_day,
			Integer length) {
		// TODO Auto-generated method stub
		Schedule objSchedule = new Schedule();
		
		
		
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


