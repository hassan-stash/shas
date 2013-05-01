package shas.devices;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.catalina.connector.Request;

import shas.logic.SprinklerService;

/**
 * Servlet implementation class SprinklerServlet
 */
public class SprinklerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Boolean bRequired = false;
    StringBuilder sbMessage ;
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
	 System.out.println("In the GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("entering dopost");
			
		if(request.getParameter("btnSchedule")!=null)
		{
			try {
				
				HandleSchedule(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("btnScheduleOff")!= null)
		{
			try {
				
				HandleScheduleOff(request,response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
		request.getRequestDispatcher("SprinklerGUI.jsp").forward(request,response);
		 //System.out.println("Sprinkler...!!");
	}

	
	
	void HandleScheduleOff(HttpServletRequest request,HttpServletResponse response)throws SQLException
	{
		if(request.getParameter("btnScheduleOff")!= null)
		{	
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
			Date dtnull =null;
			
			try {
				dtnull = dtf.parse("2000-01-01 00:00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Schedule objSchedule = new Schedule(dtnull, dtnull, 0, 0, 0,0,0,0,0,0,0,0,0,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull,dtnull);
			SprinklerService objSprService = new SprinklerService();
			Boolean SprinklerStatus = objSprService.SetSprinklerSetting(objSchedule, false);
			if (SprinklerStatus == true)
			{
				ClearFields(request,response);
				
//				request.setAttribute("schedulerstatus", "Scheduler On");
								
				System.out.println("Sprinkler  Settings Off");				
				
				request.setAttribute("ssSprinklerOn", "");
			}
		}
	}
	
	void HandleSchedule(HttpServletRequest request, HttpServletResponse response) throws SQLException
	{		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
		Date dtfromdate=null,dttodate=null;
		int statusMon,statusTue, statusWed, statusThu, statusFri,statusSat, statusSun,statusDwn;
		statusMon=statusTue=statusWed= statusThu= statusFri=statusSat=statusSun=statusDwn = 0;
		 Date dtMonfrom ,dtMonto,dtTuefrom,dtTueto,dtWedfrom, dtWedto ,dtThufrom ,dtThuto ,dtFrifrom ,dtFrito ,dtSatfrom ,dtSatto, dtSunfrom, dtSunto, dtDwnfrom , dtDwnto;
		 dtMonfrom =dtMonto=dtTuefrom=dtTueto=dtWedfrom=dtWedto =dtThufrom =dtThuto =dtFrifrom =dtFrito =dtSatfrom =dtSatto=dtSunfrom= dtSunto= dtDwnfrom = dtDwnto=null;
	    Integer intlevel=10, intduration=15;
	    sbMessage= new StringBuilder("Please enter / correct the following:");
	    bRequired = false;
	    
		 try {
			 
				 if (!ValidateInputs(request, response)&& request.getParameter("btnSchedule").compareTo("Scheduler On")==0)
				 {
					 if (bRequired == false)
						{
						 
						 	
							if(request.getParameter("fromDate").trim()=="")
							{
								dtfromdate = df.parse("2000-01-01 00:00"); 
							}
							else
							{
								dtfromdate = df.parse((String)request.getParameter("fromDate"));
							}
							
							if(request.getParameter("toDate").trim()=="")
							{
								dttodate  = df.parse("2000-01-01 00:00");
							}
							else
							{
								dttodate = df.parse((String)request.getParameter("toDate"));
							}
					    	

							if(dttodate.compareTo(dtfromdate) < 0)					
							{
								 bRequired = true;
								 sbMessage.append("\n From Date should be less than the To Date");
							}
								
						}		
					 
				 }
			 
				 if(bRequired==true)
					{
						request.setAttribute("ssReqFieldDefault", sbMessage.toString());
						SetFields(request,response);
						return;
					}
						
				//intlevel = Integer.parseInt(request.getParameter("level"));
				
				//----check checked boxes -----//
				
				if(request.getParameter("chkMon")==null && request.getParameter("chkTue")==null && request.getParameter("chkWed")==null && request.getParameter("chkThu")==null && request.getParameter("chkFri")==null && request.getParameter("chkSat")==null && request.getParameter("chkSun")==null )
				{
					sbMessage.append("Please select the schedule for the week");
					request.setAttribute("ssReqFieldDefault", sbMessage.toString());
					SetFields(request,response);
					return;
					
				}
				if(request.getParameter("chkMon")!=null)
				{
					 statusMon = 1;
					 dtMonfrom =  df.parse("2000-01-01 "+ request.getParameter("MonFromtime"));
					 dtMonto =df.parse("2000-01-01 "+request.getParameter("MonTotime"));
					 
					 	if(dtMonto.compareTo(dtMonfrom) < 0)					
						{
							 bRequired = true;
							 sbMessage.append("\n From Date should be less than the To Date");
						}
						
				}
				else
				{
					statusMon = 0;
					 dtMonfrom =  df.parse("2000-01-01 00:00");
					 dtMonto =df.parse("2000-01-01 00:00");
					
				}
				
				if(request.getParameter("chkTue")!=null)
				{
					statusTue = 1;
					dtTuefrom =  df.parse("2000-01-01 "+ request.getParameter("TueFromtime"));
					dtTueto  =df.parse("2000-01-01 "+request.getParameter("TueTotime"));
					if(dtTueto.compareTo(dtTuefrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}
						
				}
				else
				{
					statusTue = 0;
					dtTuefrom =  df.parse("2000-01-01 00:00");
					dtTueto  =df.parse("2000-01-01 00:00");
					
				}
				
				if(request.getParameter("chkWed")!=null)
				{
					statusWed = 1;
					dtWedfrom =  df.parse("2000-01-01 "+request.getParameter("WedFromtime"));
					dtWedto = df.parse("2000-01-01 "+request.getParameter("WedTotime"));
					if(dtWedto.compareTo(dtWedfrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}
						
				}
				else
				{
					statusWed = 0;
					dtWedfrom =  df.parse("2000-01-01 00:00");
					dtWedto =df.parse("2000-01-01 00:00");
				}
				
				if(request.getParameter("chkThu")!=null)
				{
					statusThu = 1;
					dtThufrom =  df.parse("2000-01-01 "+request.getParameter("ThuFromtime"));
					dtThuto =df.parse("2000-01-01 "+request.getParameter("ThuTotime"));
					if(dtThuto.compareTo(dtThufrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}	
				}
				else
				{
					statusThu = 0;
					dtThufrom = df.parse("2000-01-01 00:00");
					dtThuto =df.parse("2000-01-01 00:00");
				}
				
				if(request.getParameter("chkFri")!=null)
				{
					statusFri = 1;
					dtFrifrom =  df.parse("2000-01-01 "+request.getParameter("FriFromtime"));
					dtFrito =df.parse("2000-01-01 "+request.getParameter("FriTotime"));
					if(dtFrito.compareTo(dtFrifrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}
						
				}
				else
				{
					statusFri = 0;
					dtFrifrom =  df.parse("2000-01-01 00:00");
					dtFrito =df.parse("2000-01-01 00:00");
					
				}
				
				if(request.getParameter("chkSat")!=null)
				{
					statusSat = 1;
					dtSatfrom =  df.parse("2000-01-01 "+request.getParameter("SatFromtime"));
					dtSatto =df.parse("2000-01-01 "+request.getParameter("SatTotime"));
					if(dtSatto.compareTo(dtSatfrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}
						
				}
				else
				{
					statusSat = 0;
					dtSatfrom =  df.parse("2000-01-01 00:00");
					dtSatto = df.parse("2000-01-01 00:00");
				}
				
				if(request.getParameter("chkSun")!=null)
				{
					statusSun = 1;
					dtSunfrom =  df.parse("2000-01-01 "+request.getParameter("SunFromtime"));
					dtSunto =df.parse("2000-01-01 "+request.getParameter("SunTotime"));
					if(dtSunto.compareTo(dtSunfrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}
						
				}
				else
				{
					statusSun = 0;
					dtSunfrom =  df.parse("2000-01-01 00:00");
					dtSunto = df.parse("2000-01-01 00:00");
					
				}
				
				if(request.getParameter("chkDown")!=null)
				{
					statusDwn = 1;
					dtDwnfrom =  df.parse(request.getParameter("DownFromtime"));
					dtDwnto =df.parse(request.getParameter("DownTotime"));
					if(dtDwnto.compareTo(dtDwnfrom) < 0)					
					{
						 bRequired = true;
						 sbMessage.append("\n From Date should be less than the To Date");
					}
						
				}
				else
				{
					statusDwn = 0;
					dtDwnfrom =  df.parse("2000-01-01 00:00");
					dtDwnto = df.parse("2000-01-01 00:00");
					
				}
				
				if(bRequired==true)
				{
					request.setAttribute("ssReqFieldDefault", sbMessage.toString());
					SetFields(request,response);
					return;
				}
				//------------------------------//
		  
		//---- toggle button value to show status --------------------------//
		
		if(request.getParameter("btnSchedule").compareTo("Scheduler On")==0)
		{
			
			//---- Call the function to set the sprinkler On ----------------//
			
			Schedule objSchedule = new Schedule(dtfromdate, dttodate, intlevel, intduration, 1,statusMon,statusTue,statusWed,statusThu,statusFri,statusSat,statusSun,statusDwn,dtMonfrom,dtMonto,dtTuefrom,dtTueto,dtWedfrom,dtWedto,dtThufrom,dtThuto,dtFrifrom,dtFrito,dtSatfrom,dtSatto,dtSunfrom,dtSunto,dtDwnfrom,dtDwnto);
			SprinklerService objSprService = new SprinklerService();
			Boolean SprinklerStatus = objSprService.SetSprinklerSetting(objSchedule, false);
			if (SprinklerStatus == true)
			{
				//request.setAttribute("schedulerstatus", "Scheduler Off");
							
				System.out.println("Sprinkler  Settings on");				
				SetFields(request,response);
				
				
				//---set session for refresh ----//
				request.setAttribute("ssSprinklerOn", "The Sprinkler set successfully.");
			}
			 
		}
		
		
		 } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  }
					
		
		
	}
	
	public boolean ValidateInputs(HttpServletRequest request, HttpServletResponse response )
	{
		//-------- required field validations -----------------------------//
		 
			if(request.getParameter("fromDate").trim()== "")
			{
				sbMessage.append("From Date");
				bRequired = true;
			}
			if(request.getParameter("toDate").trim()== "")
			{
				sbMessage.append(", To Date");
				bRequired = true;
			}			
			if(request.getParameter("chkMon")!= null)
			{
				if(request.getParameter("MonFromtime")== "" || request.getParameter("MonTotime")== "")
				{
					sbMessage.append(", Monday Schedule required., ");
					bRequired = true;					
				}				
			}
			
			if(request.getParameter("chkTue")!= null)
			{
				if(request.getParameter("TueFromtime")== "" || request.getParameter("TueTotime")== "")
				{
					sbMessage.append(", Tuesday Schedule required., ");
					bRequired = true;					
				}				
			}
			
			if(request.getParameter("chkWed")!= null)
			{
				if(request.getParameter("WedFromtime")== "" || request.getParameter("WedTotime")== "")
				{
					sbMessage.append(", Wednesday Schedule required., ");
					bRequired = true;					
				}				
			}
			
			if(request.getParameter("chkThu")!= null)
			{
				if(request.getParameter("ThuFromtime")== "" || request.getParameter("ThuTotime")== "")
				{
					sbMessage.append(", Thursday Schedule required., ");
					bRequired = true;					
				}				
			}
			
			if(request.getParameter("chkFri")!= null)
			{
				if(request.getParameter("FriFromtime")== "" || request.getParameter("FriTotime")== "")
				{
					sbMessage.append(", Friday Schedule required., ");
					bRequired = true;					
				}				
			}

			if(request.getParameter("chkSat")!= null)
			{
				if(request.getParameter("SatFromtime")== "" || request.getParameter("SatTotime")== "")
				{
					sbMessage.append(", Saturday Schedule required., ");
					bRequired = true;					
				}				
			}
			
			if(request.getParameter("chkSun")!= null)
			{
				if(request.getParameter("SunFromtime")== "" || request.getParameter("SunTotime")== "")
				{
					sbMessage.append(", Sunday Schedule required., ");
					bRequired = true;					
				}				
			}
			
			if(request.getParameter("chkDown")!= null)
			{
				if(request.getParameter("DownFromtime")== "" || request.getParameter("DownTotime")== "")
				{
					sbMessage.append(", Down Schedule required., ");
					bRequired = true;					
				}				
			}

			
		return false;
	}
	
    public void SetFields(HttpServletRequest request, HttpServletResponse response)
    {
    	//---maintain control values----------------------------------//
    	ServletContext context = request.getSession().getServletContext();
		request.setAttribute("cfromDate", request.getParameter("fromDate"));
		context.setAttribute("cfromDate", request.getParameter("fromDate"));
		
		
		
		
		request.setAttribute("ctoDate", request.getParameter("toDate"));
		context.setAttribute("ctoDate", request.getParameter("toDate"));
		
		
		
		request.setAttribute("cMonFrom", request.getParameter("MonFromtime"));
		context.setAttribute("cMonFrom", request.getParameter("MonFromtime"));
		
		request.setAttribute("cMonTo", request.getParameter("MonTotime"));
		context.setAttribute("cMonTo", request.getParameter("MonTotime"));
		
		request.setAttribute("cTueFrom", request.getParameter("TueFromtime"));
		context.setAttribute("cTueFrom", request.getParameter("TueFromtime"));
		
		request.setAttribute("cTueTo", request.getParameter("TueTotime"));
		context.setAttribute("cTueTo", request.getParameter("TueTotime"));
		
		request.setAttribute("cWedFrom", request.getParameter("WedFromtime"));
		context.setAttribute("cWedFrom", request.getParameter("WedFromtime"));
		
		request.setAttribute("cWedTo", request.getParameter("WedTotime"));
		context.setAttribute("cWedTo", request.getParameter("WedTotime"));
		
		request.setAttribute("cThuFrom", request.getParameter("ThuFromtime"));
		context.setAttribute("cThuFrom", request.getParameter("ThuFromtime"));
		
		request.setAttribute("cThuTo", request.getParameter("ThuTotime"));
		context.setAttribute("cThuTo", request.getParameter("ThuTotime"));
		
		request.setAttribute("cFriFrom", request.getParameter("FriFromtime"));
		context.setAttribute("cFriFrom", request.getParameter("FriFromtime"));
		
		request.setAttribute("cFriTo", request.getParameter("FriTotime"));
		context.setAttribute("cFriTo", request.getParameter("FriTotime"));
		
		request.setAttribute("cSatFrom", request.getParameter("SatFromtime"));
		context.setAttribute("cSatFrom", request.getParameter("SatFromtime"));
		
		request.setAttribute("cSatTo", request.getParameter("SatTotime"));
		context.setAttribute("cSatTo", request.getParameter("SatTotime"));
		
		request.setAttribute("cSunFrom", request.getParameter("SunFromtime"));
		context.setAttribute("cSunFrom", request.getParameter("SunFromtime"));
		
		request.setAttribute("cSunTo", request.getParameter("SunTotime"));
		context.setAttribute("cSunTo", request.getParameter("SunTotime"));
		
		request.setAttribute("cDwnFrom", request.getParameter("DownFromtime"));
		context.setAttribute("cDwnFrom", request.getParameter("DownFromtime"));
		
		request.setAttribute("cDwnTo", request.getParameter("DownTotime"));
		context.setAttribute("cDwnTo", request.getParameter("DownTotime"));
		
		
		request.setAttribute("cmonday", request.getParameter("chkMon"));
		context.setAttribute("cmonday", request.getParameter("chkMon"));
		
		request.setAttribute("ctuesday", request.getParameter("chkTue"));
		context.setAttribute("ctuesday", request.getParameter("chkTue"));
		
		request.setAttribute("cwednesday", request.getParameter("chkWed"));
		context.setAttribute("cwednesday", request.getParameter("chkWed"));
		
		request.setAttribute("cthursday", request.getParameter("chkThu"));
		context.setAttribute("cthursday", request.getParameter("chkThu"));
		
		request.setAttribute("cfriday", request.getParameter("chkFri"));
		context.setAttribute("cfriday", request.getParameter("chkFri"));
		
		request.setAttribute("csaturday", request.getParameter("chkSat"));
		context.setAttribute("csaturday", request.getParameter("chkSat"));
		
		request.setAttribute("csunday", request.getParameter("chkSun"));
		context.setAttribute("csunday", request.getParameter("chkSun"));
		
		request.setAttribute("cdown", request.getParameter("chkDown"));		
		context.setAttribute("cdown", request.getParameter("chkDown"));
		
    	
    }
    
    public void ClearFields(HttpServletRequest request, HttpServletResponse response)
    {
    	//---maintain control values----------------------------------//
    	ServletContext context = request.getSession().getServletContext();
    	
		context.removeAttribute("cfromDate");
		
		
		
		
		
		context.removeAttribute("ctoDate");
		
		
		
		
		
		context.removeAttribute("cMonFrom");
		
		
		context.removeAttribute("cMonTo");
		
		
		context.removeAttribute("cTueFrom");
		
		
		context.removeAttribute("cTueTo");
		
		
		context.removeAttribute("cWedFrom");
		
		
		context.removeAttribute("cWedTo");
		
		
		context.removeAttribute("cThuFrom");
		
		
		context.removeAttribute("cThuTo");
		
		
		context.removeAttribute("cFriFrom");
		
		
		context.removeAttribute("cFriTo");
		
		
		context.removeAttribute("cSatFrom");
		
		
		context.removeAttribute("cSatTo");
		
		
		context.removeAttribute("cSunFrom");
		
		
		context.removeAttribute("cSunTo");
		
		
		context.removeAttribute("cDwnFrom");
		
		
		context.removeAttribute("cDwnTo");
		
		
		
		context.removeAttribute("cmonday");
		
		
		context.removeAttribute("ctuesday");
		
		
		context.removeAttribute("cwednesday");
		
		
		context.removeAttribute("cthursday");
		
		
		context.removeAttribute("cfriday");
		
		
		context.removeAttribute("csaturday");
		
		
		context.removeAttribute("csunday");
		
				
		context.removeAttribute("cdown");
		
    	
    }
	
	
}
