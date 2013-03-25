package shas.devices;

import java.io.IOException;
import java.sql.SQLException;

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
		
		
		UpdateSprinklerOutput( request,  response);
		request.getRequestDispatcher("home.jsp").forward(request,response);
		
		
		
	}
	
	void UpdateSprinklerOutput(HttpServletRequest request, HttpServletResponse response)
	{

			Schedule objActiveSchedule = new Schedule();
			ServletContext context = request.getSession().getServletContext();
			SprinklerService objSpklrService = new SprinklerService();
			String strLevel;
			try {
														
					strLevel = Integer.toString(objSpklrService.GetActiveSchedule().getLevel());					
					context.setAttribute("ssSprinklerLevel", strLevel) ;
//					request.setAttribute("ssSprinklerLevel",strLevel);
					request.setAttribute("ssObjSchedule", objActiveSchedule);
					
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}

}
