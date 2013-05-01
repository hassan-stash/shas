//------------------------------------------------------------------------//
//SHAS Team Omega
//Author : Nawaz, Abu Hassan
//Last changed : 24 April 2013
//Handles Power usage 
//
//------------------------------------------------------------------------//
package shas.devices;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
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
 * Servlet implementation class UsageServlet
 */
public class WaterUsageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StringBuilder sbMessage ;
	public Boolean bRequired = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaterUsageServlet() {
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
		// TODO Auto-generated method stub
		
		System.out.println("In the servlet");
		try {
			sbMessage = new StringBuilder();
			bRequired=false;
			GetUsageReport(request,response);
			request.getRequestDispatcher("Wreport.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void GetUsageReport(HttpServletRequest request, HttpServletResponse response) throws SQLException
	{
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
		Date dtfromdate=null,dttodate=null;
		
		if (ValidateInputs(request, response))
		{
			request.setAttribute("ssReqField", sbMessage.toString());
			SetFields(request,response);
			return;			
		}
		
		try {
			dtfromdate = df.parse((String)request.getParameter("PfromDate"));
			dttodate = df.parse((String)request.getParameter("PtoDate")) ;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dttodate.compareTo(dtfromdate) < 0)					
		{
			request.setAttribute("ssReqField", sbMessage.toString());
			return;	
		}
		
		ServletContext context = request.getSession().getServletContext();
		SprinklerService objService = new SprinklerService();
		
		//------initial settings zero ----------------------------//
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		
		Hashtable<String,Integer> objRs = objService.GetUsage("water", dtfromdate, dttodate); 				
		context.setAttribute("rsWater", objRs);
		SetFields(request,response);		
		
	}
	
	   public void SetFields(HttpServletRequest request, HttpServletResponse response)
	    {
	    	//---maintain control values----------------------------------//
			request.setAttribute("cPfromDate", request.getParameter("PfromDate"));
			request.setAttribute("cPtoDate", request.getParameter("PtoDate"));
			
	    }
	   
		public boolean ValidateInputs(HttpServletRequest request, HttpServletResponse response )
		{
			//-------- required field validations -----------------------------//
			 
				
				if(request.getParameter("PfromDate").trim()== "")
				{
					sbMessage.append("Start Date required");
					bRequired = true;					
				}
				if(request.getParameter("PtoDate").trim()== "")
				{
					sbMessage.append(", End Date required");
					bRequired = true;
				}		
				
				
				
			return bRequired;
		}


}
