//-------------------------------------------------------------------------------------------------------//
//Home servlet
//SHAS 
//Author Abu Hassan
// March 4, 2013
//-------------------------------------------------------------------------------------------------------//


package shas.devices;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shas.logic.SprinklerService;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entering Home servlet dopost");
		
		ServletContext context = request.getSession().getServletContext();
		SprinklerService objService = new SprinklerService();		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
		Date dtfromdate=null,dttodate=null;
		try {
			dtfromdate = df.parse("2012-01-01 00:00");
			dttodate = df.parse("2012-12-31 00:00") ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Hashtable<String, Integer> objRs = null;
		Hashtable<String, Integer> objRswater = null;
		try {
			objRs = objService.GetUsage("poweryear", dtfromdate, dttodate);
			objRswater = objService.GetUsage("wateryear", dtfromdate, dttodate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
		context.setAttribute("rsPowerYear", objRs);
		context.setAttribute("rsWaterYear", objRswater);
		UpdateSprinklerOutput( request,  response);
		request.getRequestDispatcher("home.jsp").forward(request,response);
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	void UpdateSprinklerOutput(HttpServletRequest request, HttpServletResponse response)
	{
			System.out.println("Sprinkler sprinkling........");
			System.out.println("In the upodate sprinkler");
			ServletContext context = request.getSession().getServletContext();
			SprinklerService objSpklrService = new SprinklerService();
			
			
			try {
				
			
				//------initial settings zero ----------------------------//
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = new Date();
				int TotalLevel =0;
				long Totalrunningtime =0;				
				float PowerConsumed = 0;
				int TotalGallons =0;
				
				if(context.getAttribute("ssSprinklerLevel")==null )
				{
					context.setAttribute("ssSprinklerLevel", 0);
				}
				
				//-----------------------The DB hit-----------------------------------//
				Schedule ObjectSchedule = objSpklrService.GetActiveSchedule("");
				Date dtSettingFrom = ObjectSchedule .getDtfrom();
				Date dtSettingTo= ObjectSchedule.getDtto();
				//----Cuurent dates----//
				Date currdatetime = new Date();
				//----current day ----------//
				SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week abbreviated
				String CurrentDay = simpleDateformat.format(currdatetime);		      
				int RainlevelRead = objSpklrService.GetRainGausgeReading(); 
				//--set rain level in home---/
				context.setAttribute("ssRainLevel", RainlevelRead);
				
				
		        int CurrentDayOn=0;		        
		        long FromTime =0;
		        long ToTime = 0;
		        
		    	int FromHours_mins = 0;
	        	int ToHours_mins= 0;
	        	
	        	int TotalMinsSet = 0;
	        	int MaxDuration =0;
		        
		        if (CurrentDay.compareToIgnoreCase("Monday") == 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getMonday();	     
		        	FromHours_mins  = (ObjectSchedule.getMondayfrom().getHours() * 60)+ (ObjectSchedule.getMondayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getMondayto().getHours() * 60)+ (ObjectSchedule.getMondayto().getMinutes());		
		        	
		        }
		        else if (CurrentDay.compareToIgnoreCase("Tuesday") == 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getTuesday();	 
		        	FromHours_mins  = (ObjectSchedule.getTuesdayfrom().getHours() * 60)+ (ObjectSchedule.getTuesdayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getTuesdayto().getHours() * 60)+ (ObjectSchedule.getTuesdayto().getMinutes());
		        	
		        }
		        else if (CurrentDay.compareToIgnoreCase("Wednesday") == 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getWednesday();     
		        	FromHours_mins  = (ObjectSchedule.getWednesdayfrom().getHours() * 60)+ (ObjectSchedule.getWednesdayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getWednesdayto().getHours() * 60)+ (ObjectSchedule.getWednesdayto().getMinutes());
		        	
		        }
		        else if (CurrentDay.compareToIgnoreCase("Thursday")== 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getThursday();
		        	FromHours_mins  = (ObjectSchedule.getThursdayfrom().getHours() * 60)+ (ObjectSchedule.getThursdayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getThursdayto().getHours() * 60)+ (ObjectSchedule.getThursdayto().getMinutes());
		        }
		        else if (CurrentDay.compareToIgnoreCase("Friday")== 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getFriday();
		        	FromHours_mins  = (ObjectSchedule.getFridayfrom().getHours() * 60)+ (ObjectSchedule.getFridayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getFridayto().getHours() * 60)+ (ObjectSchedule.getFridayto().getMinutes());		        	
		        }
		        else if (CurrentDay.compareToIgnoreCase("Saturday") == 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getSaturday();
		        	FromHours_mins  = (ObjectSchedule.getSaturdayfrom().getHours() * 60)+ (ObjectSchedule.getSaturdayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getSaturdayto().getHours() * 60)+ (ObjectSchedule.getSaturdayto().getMinutes());	
		        	
		        }
		        else if (CurrentDay.compareToIgnoreCase("Sunday") == 0)
		        {
		        	CurrentDayOn = ObjectSchedule.getSunday();
 	
		        	FromHours_mins  = (ObjectSchedule.getSundayfrom().getHours() * 60)+ (ObjectSchedule.getSundayfrom().getMinutes());
		        	ToHours_mins  = (ObjectSchedule.getSundayto().getHours() * 60)+ (ObjectSchedule.getSundayto().getMinutes());		        	
		        }
		        
		        if (currdatetime.compareTo(ObjectSchedule.getDowntimefrom()) >= 0 && currdatetime.compareTo(ObjectSchedule.getDowntimeto())<=0)
		        {
		        	CurrentDayOn = 0;
		        	
		        }
		        
		       
		        if(CurrentDayOn > 0)
		        {
		        	 TotalMinsSet = ToHours_mins -FromHours_mins;  
		        	 context.setAttribute("ssTotalDuration", TotalMinsSet);
		        	 TotalLevel =  ObjectSchedule.getLevel();
		        	 if (RainlevelRead > 10)
		        		  	MaxDuration = 0;
						else if (RainlevelRead <=  10 && RainlevelRead > 5)
							MaxDuration = TotalMinsSet / 2;
						else if (RainlevelRead <= 5)
							MaxDuration = TotalMinsSet;
		        	 
		        	 
		        	 context.setAttribute("ssTotalMinSet", TotalMinsSet);
		        	 context.setAttribute("ssMaxDuration", MaxDuration);
		        	 
		        	 
		        	if(dtSettingTo.compareTo(dtSettingFrom)>= 0 && currdatetime.compareTo(dtSettingFrom)>=0 && currdatetime.compareTo(dtSettingTo)<=0)
					{	
		        		int curtime_in_min = (currdatetime.getHours() * 60 )+ (currdatetime.getMinutes()); 
						if (curtime_in_min >= FromHours_mins && curtime_in_min < ToHours_mins && ((curtime_in_min - FromHours_mins)< MaxDuration) )
						{	
							    long diff = curtime_in_min - FromHours_mins;
								context.setAttribute("ssSprinklerLevel", ObjectSchedule.getLevel());
								Totalrunningtime = diff ;
								
								float fltotallevel = TotalLevel;
								if (RainlevelRead > 20)
									fltotallevel = 10;
								else if (RainlevelRead <=  20 && RainlevelRead > 10)
									fltotallevel = 50;
								else if (RainlevelRead <= 10)
									fltotallevel = 100;
								
								
								int floatvalueTotalrunningtime = (int) Totalrunningtime;
								TotalLevel = (int) fltotallevel;
								
								
								///-------------water usage------------------///
								
								TotalGallons = (curtime_in_min - FromHours_mins) *15;
								context.setAttribute("ssWater", TotalGallons);
								///--------------------------------------------///
								///---- power calculation ---------------------///
								//- power consumed = level * duration-----------//
								PowerConsumed = (float)((curtime_in_min - FromHours_mins))/1000;
								context.setAttribute("ssTotalPower", PowerConsumed);
								
								context.setAttribute("ssTotalLevel", TotalLevel);
								context.setAttribute("ssTotalRunningtime", Totalrunningtime);
						}
						 else
				        	{
				        		TotalLevel = 0;
				        		TotalGallons = 0;
				        		context.setAttribute("ssTotalLevel", TotalLevel);
				        		context.setAttribute("ssWater", 0);
				        	}
					}
		        	
		        	
		        	usage objUsage = new usage();
					String strSprinkler = "sprinkler1";
					objUsage.setDeviceid(strSprinkler);
					objUsage.setDate(currdatetime);
					objUsage.setDurationran(Totalrunningtime);
					objUsage.setPowerconsumed(PowerConsumed);
					objUsage.setWaterconsumed(TotalGallons);
				
					//-------- update usage ------//					
					SprinklerService objService = new SprinklerService();					
					boolean usageUpdated = objService.UpdateUsage(objUsage);		
					
					if(usageUpdated)
					{
						System.out.println("Usage Updated Successfully");
					}
			
		        	
		        }
		        else
	        	{
	        		TotalLevel = 0;
	        		TotalGallons = 0;
	        		context.setAttribute("ssTotalLevel", TotalLevel);
	        		context.setAttribute("ssWater", 0);
	        	}
		       
		       
					
					
									
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}

}
