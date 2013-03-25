package shas.devices;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import shas.logic.SprinklerService;

/**
 * Servlet implementation class SprinklerServlet
 */
public class SprinklerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SprinklerServlet() {
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
		
		System.out.println("entering dopost");
		
	
//			Date stroverridefromDate = df.parse(request.getParameter("overridefromDate"));
//			Date stroverrideToDate = df.parse(request.getParameter("overrideToDate"));
//			Date strshutFromDate = df.parse(request.getParameter("shutFromDate"));
//			Date strshutToDate = df.parse(request.getParameter("shutToDate"));
//			
//			System.out.println(strfromdate);
//			System.out.println(strtodate);
//			System.out.println(stroverridefromDate);
//			System.out.println(stroverrideToDate);
//			System.out.println(strfromdate);
//			System.out.println(strshutFromDate);
//			System.out.println(strshutToDate);
			
		
		//-------------------------------------------------------------------
		
		
		if(request.getParameter("btnSchedule")!=null)
		{
			try {
				HandleSchedule(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("btnApplyOverride")!=null)
		{
			HandleOverrideSchedule(request,response);
		}
		if(request.getParameter("btnApplyMaintenance")!=null)
		{
			HandleMaintenanceSchedule(request,response);
		}

		String schedulestatus = request.getParameter("btnSchedule");
		
		String str = (String )request.getAttribute("btnApplyMaintenance");

		
		request.getRequestDispatcher("SprinklerGUI.jsp").forward(request,response);
		 //System.out.println("Sprinkler...!!");
	}

	

	

	void HandleSchedule(HttpServletRequest request, HttpServletResponse response) throws SQLException
	{
		
		
		Date dtfromdate=null,dttodate=null;
		Integer intlevel=10, intduration=15;
		 try {
			 
		    	if((request.getParameter("fromDate")!="") && (request.getParameter("toDate")!="" )) 
		    	{
		    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		    		dtfromdate = df.parse(request.getParameter("fromDate"));
					dttodate = df.parse(request.getParameter("toDate"));					
					intlevel = Integer.parseInt(request.getParameter("level"));
					intduration = Integer.parseInt(request.getParameter("duration"));					
					
		    	}
		  } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  }
					
		  
		//---- toggle button value to show status --------------------------//
		
		if(request.getParameter("btnSchedule").compareTo("Scheduler On")==0)
		{
			
			//---- Call the function to set the sprinkler On ----------------//
			Schedule objSchedule = new Schedule(dtfromdate, dttodate, intlevel, intduration, 1);
			SprinklerService objSprService = new SprinklerService();
			Boolean SprinklerStatus = objSprService.SetSprinklerSetting(objSchedule);
			if (SprinklerStatus == true)
			{
				request.setAttribute("schedulerstatus", "Scheduler Off");
				System.out.println("Sprinkler  Settings on");	
				//---maintain control values----------------------------------//
				request.setAttribute("cfromDate", request.getParameter("fromDate"));
				request.setAttribute("ctoDate", request.getParameter("toDate"));
				request.setAttribute("clevel", request.getParameter("level"));		
				request.setAttribute("cduration", request.getParameter("duration"));
				//---set session for refresh ----//
				request.setAttribute("ssSprinklerOn", "yes");
			}
			 
		}else if(request.getParameter("btnSchedule").compareTo("Scheduler Off")==0)
		{	
			
			//---- Call the function to set the sprinkler off ----------------//
			Schedule objSchedule = new Schedule(dtfromdate, dttodate, intlevel, intduration, 0);
			SprinklerService objSprService = new SprinklerService();
			Boolean SprinklerStatus = objSprService.SetSprinklerSetting(objSchedule);
			if (SprinklerStatus == true)
			{
				request.setAttribute("schedulerstatus", "Scheduler On");
				System.out.println("Sprinkler  Settings Off");	
				//---maintain control values----------------------------------//
				request.setAttribute("cfromDate", "");
				request.setAttribute("ctoDate", "");
				request.setAttribute("clevel", "10");		
				request.setAttribute("cduration","15");
			}
						
		}
		
		
		
	}
	
	private void HandleOverrideSchedule(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void HandleMaintenanceSchedule(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	
}
